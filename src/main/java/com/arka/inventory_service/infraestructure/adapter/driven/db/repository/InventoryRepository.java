//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.InventoryEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryRepository extends ReactiveCrudRepository<InventoryEntity, UUID> {
    Mono<InventoryEntity> findBySku(String sku);

    @Query("    INSERT INTO inventory (id, sku, warehouse_id, quantity, updated_at)\n    VALUES (:id, :sku, :warehouseId, :quantity, :updatedAt)\n    ON CONFLICT (sku, warehouse_id) DO UPDATE\nSET quantity = EXCLUDED.quantity,\n    updated_at = EXCLUDED.updated_at\n")
    Mono<Void> upsertInventory(UUID id, String sku, UUID warehouseId, int quantity, LocalDateTime updatedAt);

    @Query("    UPDATE inventory\n    SET quantity = quantity + :quantity,\n        updated_at = :updatedAt\n    WHERE sku = :sku\n")
    Mono<Void> increaseStock(String sku, int quantity, LocalDateTime updatedAt);

    @Query("    SELECT * FROM inventory\n    WHERE quantity >= :minQuantity\n")
    Flux<InventoryEntity> findByQuantityGreaterThanEqual(int minQuantity);

    @Query("    SELECT * FROM inventory\n    WHERE sku = :sku AND warehouse_id = :warehouseId\n")
    Mono<InventoryEntity> findBySkuAndWarehouseId(String sku, UUID warehouseId);

    @Query("    UPDATE inventory\n    SET quantity = quantity + :quantity,\n        updated_at = CURRENT_TIMESTAMP\n    WHERE sku = :sku AND warehouse_id = :warehouseId\n")
    Mono<Void> increaseQuantityBySkuAndWarehouseId(String sku, int quantity, UUID warehouseId);

    @Query("SELECT * FROM inventory WHERE sku = :sku")
    Flux<InventoryEntity> findAllBySku(String sku);
}
