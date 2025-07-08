package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.input.SkuExistenceValidationService;
import com.arka.inventory_service.application.ports.output.*;
import com.arka.inventory_service.domain.exception.inventory.SkuNotFoundException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByIdException;
import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.domain.model.InventoryDelta;
import com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto.OrderPlacedEventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InventoryServiceImplTest {

    @MockBean
    private InventoryPersistencePort inventoryPersistencePort;
    @MockBean
    private InventoryTransactionPersistencePort transactionPersistencePort;
    @MockBean
    private SkuExistenceValidationService skuExistenceValidationService;
    @MockBean
    private WarehouseQueryPort warehouseQueryPort;
    @MockBean
    private CustomerOrderPersistencePort customerOrderPersistencePort;
    @MockBean
    private CustomerOrderItemPersistencePort customerOrderItemPersistencePort;
    @MockBean
    private OrderDistributionPersistencePort orderDistributionPersistencePort;
    @MockBean
    private ReservedInventoryPersistencePort reservedInventoryPersistencePort;
    @MockBean
    private WarehousePersistencePort warehousePersistencePort;

    private InventoryServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new InventoryServiceImpl(
                inventoryPersistencePort,
                transactionPersistencePort,
                skuExistenceValidationService,
                warehouseQueryPort,
                customerOrderPersistencePort,
                customerOrderItemPersistencePort,
                orderDistributionPersistencePort,
                reservedInventoryPersistencePort,
                warehousePersistencePort
        );
    }

    @Test
    void increaseStockManually_success() {
        String sku = "SKU1";
        int quantity = 10;
        UUID warehouseId = UUID.randomUUID();
        when(warehouseQueryPort.findById(warehouseId)).thenReturn(Mono.just(new com.arka.inventory_service.domain.model.Warehouse()));
        when(skuExistenceValidationService.skuExists(sku)).thenReturn(Mono.just(true));
        when(inventoryPersistencePort.findBySkuAndWarehouseId(sku, warehouseId)).thenReturn(Mono.empty());
        when(inventoryPersistencePort.save(any(Inventory.class))).thenReturn(Mono.just(new Inventory()));
        when(transactionPersistencePort.save(any())).thenReturn(Mono.empty());

        StepVerifier.create(service.increaseStockManually(sku, quantity, warehouseId))
                .verifyComplete();
    }

    @Test
    void increaseStockManually_warehouseNotFound() {
        String sku = "SKU1";
        int quantity = 10;
        UUID warehouseId = UUID.randomUUID();
        when(warehouseQueryPort.findById(warehouseId)).thenReturn(Mono.empty());
        // Mock necesario para evitar NullPointerException
        when(skuExistenceValidationService.skuExists(sku)).thenReturn(Mono.just(true));

        StepVerifier.create(service.increaseStockManually(sku, quantity, warehouseId))
                .expectError(WarehouseNotFoundByIdException.class)
                .verify();
    }

    @Test
    void increaseStockManually_skuNotFound() {
        String sku = "SKU1";
        int quantity = 10;
        UUID warehouseId = UUID.randomUUID();
        when(warehouseQueryPort.findById(warehouseId)).thenReturn(Mono.just(new com.arka.inventory_service.domain.model.Warehouse()));
        when(skuExistenceValidationService.skuExists(sku)).thenReturn(Mono.just(false));

        StepVerifier.create(service.increaseStockManually(sku, quantity, warehouseId))
                .expectError(SkuNotFoundException.class)
                .verify();
    }

    @Test
    void getStockBySku_success() {
        String sku = "SKU1";
        when(inventoryPersistencePort.findBySku(sku)).thenReturn(Mono.just(new Inventory(UUID.randomUUID(), sku, UUID.randomUUID(), 20, LocalDateTime.now())));
        StepVerifier.create(service.getStockBySku(sku))
                .expectNext(20)
                .verifyComplete();
    }

    @Test
    void filterByMinQuantity_success() {
        when(inventoryPersistencePort.findByMinQuantity(5)).thenReturn(Flux.just(new Inventory()));
        StepVerifier.create(service.filterByMinQuantity(5))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void getStockBySkuAcrossWarehouses_skuNotFound() {
        String sku = "SKU1";
        when(inventoryPersistencePort.findAllBySku(sku)).thenReturn(Flux.empty());
        StepVerifier.create(service.getStockBySkuAcrossWarehouses(sku))
                .expectError(SkuNotFoundException.class)
                .verify();
    }
}
