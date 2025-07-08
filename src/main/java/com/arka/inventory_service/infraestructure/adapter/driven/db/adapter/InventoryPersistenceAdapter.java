//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.InventoryPersistencePort;
import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.InventoryPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.InventoryRepository;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InventoryPersistenceAdapter implements InventoryPersistencePort {
    private final InventoryRepository repository;

    public Mono<Inventory> findBySku(String sku) {
        return this.repository.findBySku(sku).map(InventoryPersistenceMapper::toDomain);
    }

    public Mono<Inventory> save(Inventory inventory) {
        PrintStream var10000 = System.out;
        String var10001 = inventory.getSku();
        var10000.println("➡️ UPSERT SKU: " + var10001 + ", WH: " + inventory.getWarehouseId());
        return this.repository.upsertInventory(inventory.getId(), inventory.getSku(), inventory.getWarehouseId(), inventory.getQuantity(), inventory.getUpdatedAt()).doOnSuccess((v) -> System.out.println("✅ UPSERT exitoso")).doOnError((e) -> System.out.println("❌ Error en UPSERT: " + e.getMessage())).thenReturn(inventory);
    }

    public Mono<Void> increaseQuantityBySku(String sku, int quantity) {
        return this.repository.increaseStock(sku, quantity, LocalDateTime.now());
    }

    public Flux<Inventory> findByMinQuantity(int minQuantity) {
        return this.repository.findByQuantityGreaterThanEqual(minQuantity).map(InventoryPersistenceMapper::toDomain);
    }

    public Mono<Inventory> findBySkuAndWarehouseId(String sku, UUID warehouseId) {
        return this.repository.findBySkuAndWarehouseId(sku, warehouseId).map(InventoryPersistenceMapper::toDomain);
    }

    public Mono<Void> increaseQuantityBySkuAndWarehouseId(String sku, int quantity, UUID warehouseId) {
        return this.repository.increaseQuantityBySkuAndWarehouseId(sku, quantity, warehouseId);
    }

    public Flux<Inventory> findAllBySku(String sku) {
        return this.repository.findAllBySku(sku).map(InventoryPersistenceMapper::toDomain);
    }

    @Generated
    public InventoryPersistenceAdapter(final InventoryRepository repository) {
        this.repository = repository;
    }
}
