//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.ReservedInventoryEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ReservedInventoryRepository extends ReactiveCrudRepository<ReservedInventoryEntity, UUID> {
    @Query("    INSERT INTO reserved_inventory (\n        id,\n        warehouse_code,\n        order_code,\n        sku,\n        reserved_quantity,\n        status,\n        updated_at\n    ) VALUES (\n        :id,\n        :warehouseCode,\n        :orderCode,\n        :sku,\n        :reservedQuantity,\n        :status,\n        :updatedAt\n    )\n    ON CONFLICT (warehouse_code, order_code, sku) DO UPDATE\n    SET reserved_quantity = reserved_inventory.reserved_quantity + EXCLUDED.reserved_quantity,\n        status = EXCLUDED.status,\n        updated_at = EXCLUDED.updated_at\n")
    Mono<Void> upsertReservedInventory(UUID id, String warehouseCode, String orderCode, String sku, int reservedQuantity, String status, LocalDateTime updatedAt);

    @Query("SELECT * FROM reserved_inventory WHERE order_code = :orderCode")
    Flux<ReservedInventoryEntity> findByOrderCode(String orderCode);
}
