//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.InventoryTransactionEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryTransactionRepository extends ReactiveCrudRepository<InventoryTransactionEntity, UUID> {
    Flux<InventoryTransactionEntity> findBySku(String sku);

    @Query("    INSERT INTO inventory_transaction (id, sku, warehouse_id, quantity_change, type, occurred_at)\n    VALUES (:id, :sku, :warehouseId, :quantityChange, :type, :occurredAt)\n")
    Mono<Void> insertTransaction(UUID id, String sku, UUID warehouseId, int quantityChange, String type, LocalDateTime occurredAt);
}
