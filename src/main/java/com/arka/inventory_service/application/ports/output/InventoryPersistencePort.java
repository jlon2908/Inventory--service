package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.Inventory;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryPersistencePort {
    Mono<Inventory> findBySku(String sku);

    Mono<Inventory> save(Inventory inventory);

    Mono<Void> increaseQuantityBySku(String sku, int quantity);

    Flux<Inventory> findByMinQuantity(int minQuantity);

    Mono<Inventory> findBySkuAndWarehouseId(String sku, UUID warehouseId);

    Mono<Void> increaseQuantityBySkuAndWarehouseId(String sku, int quantity, UUID warehouseId);

    Flux<Inventory> findAllBySku(String sku);
}