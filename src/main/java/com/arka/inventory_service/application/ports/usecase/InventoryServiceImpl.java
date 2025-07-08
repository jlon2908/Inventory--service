package com.arka.inventory_service.application.ports.usecase;


import com.arka.inventory_service.application.ports.input.InventoryServicePort;
import com.arka.inventory_service.application.ports.input.SkuExistenceValidationService;
import com.arka.inventory_service.application.ports.output.CustomerOrderItemPersistencePort;
import com.arka.inventory_service.application.ports.output.CustomerOrderPersistencePort;
import com.arka.inventory_service.application.ports.output.InventoryPersistencePort;
import com.arka.inventory_service.application.ports.output.InventoryTransactionPersistencePort;
import com.arka.inventory_service.application.ports.output.OrderDistributionPersistencePort;
import com.arka.inventory_service.application.ports.output.ReservedInventoryPersistencePort;
import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.application.ports.output.WarehouseQueryPort;
import com.arka.inventory_service.domain.exception.inventory.SkuNotFoundException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByIdException;
import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.domain.model.CustomerOrderItem;
import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.domain.model.InventoryDelta;
import com.arka.inventory_service.domain.model.InventoryTransaction;
import com.arka.inventory_service.domain.model.OrderDistribution;
import com.arka.inventory_service.domain.model.ReservedInventory;
import com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto.OrderPlacedEventDto;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventoryServiceImpl implements InventoryServicePort {
    private final InventoryPersistencePort inventoryPersistencePort;
    private final InventoryTransactionPersistencePort transactionPersistencePort;
    private final SkuExistenceValidationService skuExistenceValidationService;
    private final WarehouseQueryPort warehouseQueryPort;
    private final CustomerOrderPersistencePort customerOrderPersistencePort;
    private final CustomerOrderItemPersistencePort customerOrderItemPersistencePort;
    private final OrderDistributionPersistencePort orderDistributionPersistencePort;
    private final ReservedInventoryPersistencePort reservedInventoryPersistencePort;
    private final WarehousePersistencePort warehousePersistencePort;

    public Mono<Void> increaseStockByEvent(List<InventoryDelta> deltas) {
        return Flux.fromIterable(deltas).flatMap(this::processDelta).then();
    }

    private Mono<Void> processDelta(InventoryDelta delta) {
        return this.warehouseQueryPort.findIdByCode(delta.getWarehouseCode()).flatMap((warehouseId) -> this.inventoryPersistencePort.findBySkuAndWarehouseId(delta.getSku(), warehouseId).defaultIfEmpty(new Inventory(UUID.randomUUID(), delta.getSku(), warehouseId, 0, (LocalDateTime)null)).flatMap((existing) -> {
            int newQuantity = existing.getQuantity() + delta.getQuantity();
            Inventory updated = new Inventory(existing.getId(), existing.getSku(), warehouseId, newQuantity, LocalDateTime.now());
            InventoryTransaction transaction = new InventoryTransaction(UUID.randomUUID(), existing.getSku(), warehouseId, delta.getQuantity(), "RECEIPT", LocalDateTime.now());
            return this.inventoryPersistencePort.save(updated).then(this.transactionPersistencePort.save(transaction)).then();
        }));
    }

    public Mono<Void> increaseStockManually(String sku, int quantity, UUID warehouseId) {
        System.out.println("\ud83d\udfe1 Inicio increaseStockManually");
        return this.warehouseQueryPort.findById(warehouseId).doOnNext((w) -> System.out.println("✅ Warehouse encontrado: " + w.getCode())).switchIfEmpty(Mono.defer(() -> {
            System.out.println("❌ No se encontró el warehouse");
            return Mono.error(new WarehouseNotFoundByIdException(warehouseId));
        })).then(this.skuExistenceValidationService.skuExists(sku).doOnNext((exists) -> System.out.println("\ud83d\udd0d SKU existe? " + exists))).flatMap((exists) -> {
            if (!exists) {
                System.out.println("❌ SKU NO existe");
                return Mono.error(new SkuNotFoundException(sku));
            } else {
                return this.inventoryPersistencePort.findBySkuAndWarehouseId(sku, warehouseId).map(Optional::of).defaultIfEmpty(Optional.empty()).flatMap((optional) -> {
                    if (optional.isPresent()) {
                        Inventory existing = (Inventory)optional.get();
                        System.out.println("\ud83d\udd0e Inventario encontrado, cantidad: " + existing.getQuantity());
                        System.out.println("\ud83d\udfe2 Actualizando inventario existente...");
                        Inventory updated = new Inventory(existing.getId(), sku, warehouseId, existing.getQuantity() + quantity, LocalDateTime.now());
                        InventoryTransaction transaction = new InventoryTransaction(UUID.randomUUID(), sku, warehouseId, quantity, "MANUAL", LocalDateTime.now());
                        return this.inventoryPersistencePort.save(updated).then(this.transactionPersistencePort.save(transaction)).then();
                    } else {
                        System.out.println("\ud83c\udd95 No existía inventario, creando uno nuevo...");
                        Inventory newInventory = new Inventory(UUID.randomUUID(), sku, warehouseId, quantity, LocalDateTime.now());
                        InventoryTransaction transaction = new InventoryTransaction(UUID.randomUUID(), sku, warehouseId, quantity, "MANUAL", LocalDateTime.now());
                        return this.inventoryPersistencePort.save(newInventory).then(this.transactionPersistencePort.save(transaction)).then();
                    }
                });
            }
        }).onErrorMap((ex) -> {
            if (ex instanceof WarehouseNotFoundByIdException || ex instanceof SkuNotFoundException) {
                return ex;
            }
            System.out.println("❌ Error final: " + ex.getMessage());
            return new RuntimeException("Unexpected error in inventory: " + ex.getMessage(), ex);
        });
    }

    public Mono<Integer> getStockBySku(String sku) {
        return this.inventoryPersistencePort.findBySku(sku).map(Inventory::getQuantity);
    }

    public Flux<Inventory> filterByMinQuantity(int minQuantity) {
        return this.inventoryPersistencePort.findByMinQuantity(minQuantity);
    }

    public Mono<Void> processPlacedOrder(OrderPlacedEventDto event) {
        UUID orderId = UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        CustomerOrder order = new CustomerOrder(orderId, event.getOrderCode(), UUID.fromString(event.getUserId()), event.getWarehousePickupCode(), now, "ASSIGNED");
        List<CustomerOrderItem> items = event.getItems().stream().map((item) -> new CustomerOrderItem(UUID.randomUUID(), orderId, item.getSku(), item.getAssignedDistributions().stream().mapToInt((d) -> d.getQuantity()).sum())).toList();
        Map<String, UUID> warehouseCache = new HashMap();
        return this.customerOrderPersistencePort.save(order).thenMany(this.customerOrderItemPersistencePort.saveAll(items)).thenMany(Flux.fromIterable(event.getItems())).flatMap((item) -> {
            UUID itemId = (UUID)items.stream().filter((i) -> i.getSku().equals(item.getSku())).map(CustomerOrderItem::getId).findFirst().orElseThrow();
            return Flux.fromIterable(item.getAssignedDistributions()).flatMap((dist) -> {
                String warehouseCode = dist.getWarehouseCode();
                int quantity = dist.getQuantity();
                Mono<UUID> warehouseIdMono = Mono.defer(() -> warehouseCache.containsKey(warehouseCode) ? Mono.just((UUID)warehouseCache.get(warehouseCode)) : this.warehouseQueryPort.findIdByCode(warehouseCode).doOnNext((id) -> warehouseCache.put(warehouseCode, id)));
                return warehouseIdMono.flatMap((warehouseId) -> this.inventoryPersistencePort.findBySkuAndWarehouseId(item.getSku(), warehouseId).flatMap((inventory) -> {
                    if (inventory.getQuantity() < quantity) {
                        return Mono.error(new RuntimeException("Not enough inventory"));
                    } else {
                        Inventory updated = new Inventory(inventory.getId(), inventory.getSku(), warehouseId, inventory.getQuantity() - quantity, LocalDateTime.now());
                        InventoryTransaction transaction = new InventoryTransaction(UUID.randomUUID(), inventory.getSku(), warehouseId, -quantity, "ORDER_ALLOCATED", LocalDateTime.now());
                        OrderDistribution distribution = new OrderDistribution(UUID.randomUUID(), itemId, warehouseId, event.getWarehousePickupCode(), inventory.getSku(), quantity, "PENDING", LocalDateTime.now());
                        return this.inventoryPersistencePort.save(updated).then(this.transactionPersistencePort.save(transaction)).then(this.orderDistributionPersistencePort.save(distribution)).flatMap((saved) -> {
                            if (warehouseCode.equals(event.getWarehousePickupCode())) {
                                ReservedInventory reserved = new ReservedInventory(UUID.randomUUID(), warehouseCode, order.getOrderCode(), item.getSku(), quantity, "WAITING_PICKUP", LocalDateTime.now());
                                return this.reservedInventoryPersistencePort.upsertReservedInventory(reserved);
                            } else {
                                return Mono.empty();
                            }
                        });
                    }
                }));
            });
        }).then();
    }

    public Flux<Inventory> getStockBySkuAcrossWarehouses(String sku) {
        return this.inventoryPersistencePort.findAllBySku(sku).switchIfEmpty(Mono.error(new SkuNotFoundException(sku)));
    }

    @Generated
    public InventoryServiceImpl(final InventoryPersistencePort inventoryPersistencePort, final InventoryTransactionPersistencePort transactionPersistencePort, final SkuExistenceValidationService skuExistenceValidationService, final WarehouseQueryPort warehouseQueryPort, final CustomerOrderPersistencePort customerOrderPersistencePort, final CustomerOrderItemPersistencePort customerOrderItemPersistencePort, final OrderDistributionPersistencePort orderDistributionPersistencePort, final ReservedInventoryPersistencePort reservedInventoryPersistencePort, final WarehousePersistencePort warehousePersistencePort) {
        this.inventoryPersistencePort = inventoryPersistencePort;
        this.transactionPersistencePort = transactionPersistencePort;
        this.skuExistenceValidationService = skuExistenceValidationService;
        this.warehouseQueryPort = warehouseQueryPort;
        this.customerOrderPersistencePort = customerOrderPersistencePort;
        this.customerOrderItemPersistencePort = customerOrderItemPersistencePort;
        this.orderDistributionPersistencePort = orderDistributionPersistencePort;
        this.reservedInventoryPersistencePort = reservedInventoryPersistencePort;
        this.warehousePersistencePort = warehousePersistencePort;
    }
}

