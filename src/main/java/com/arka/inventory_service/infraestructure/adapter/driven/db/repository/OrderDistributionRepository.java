//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.OrderDistributionEntity;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.OrderDistributionWithCodeRow;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.Nullable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OrderDistributionRepository extends ReactiveCrudRepository<OrderDistributionEntity, UUID> {
    @Query("    INSERT INTO order_distribution (\n        id,\n        customer_order_item_id,\n        source_warehouse_id,\n        destination_warehouse_code,\n        sku,\n        assigned_quantity,\n        status,\n        assigned_at\n    ) VALUES (\n        :id,\n        :customerOrderItemId,\n        :sourceWarehouseId,\n        :destinationWarehouseCode,\n        :sku,\n        :assignedQuantity,\n        :status,\n        :assignedAt\n    )\n")
    Mono<Void> insertOrderDistribution(UUID id, UUID customerOrderItemId, UUID sourceWarehouseId, String destinationWarehouseCode, String sku, int assignedQuantity, String status, LocalDateTime assignedAt);

    @Query("    SELECT * FROM order_distribution\n    WHERE source_warehouse_id = (\n        SELECT id FROM warehouse WHERE code = :sourceWarehouseCode\n    )\n")
    Flux<OrderDistributionEntity> findBySourceWarehouseCode(String sourceWarehouseCode);

    @Query("    SELECT\n        od.id,\n        od.customer_order_item_id,\n        od.source_warehouse_id,\n        od.destination_warehouse_code,\n        od.sku,\n        od.assigned_quantity,\n        od.status,\n        od.assigned_at,\n        co.order_code\n    FROM order_distribution od\n    JOIN customer_order_item coi ON coi.id = od.customer_order_item_id\n    JOIN customer_order co ON co.id = coi.customer_order_id\n    JOIN warehouse w ON w.code = :sourceWarehouseCode\n    WHERE od.source_warehouse_id = w.id\n      AND (:status IS NULL OR od.status = :status)\n")
    Flux<OrderDistributionWithCodeRow> findWithOrderCodeBySourceWarehouseCode(String sourceWarehouseCode, @Nullable String status);

    @Query("    UPDATE order_distribution od\n    SET status = :newStatus\n    WHERE od.destination_warehouse_code = :destinationWarehouseCode\n      AND od.customer_order_item_id IN (\n        SELECT coi.id FROM customer_order_item coi\n        JOIN customer_order co ON co.id = coi.customer_order_id\n        WHERE co.order_code = :orderCode\n      )\n    RETURNING 1\n")
    Flux<Integer> updateStatusByOrderCodeAndDestinationWarehouse(String orderCode, String destinationWarehouseCode, String newStatus);

    @Query("    UPDATE order_distribution od\n    SET status = :newStatus\n    WHERE od.source_warehouse_id = (\n        SELECT id FROM warehouse WHERE code = :sourceWarehouseCode\n    )\n      AND od.customer_order_item_id IN (\n        SELECT coi.id FROM customer_order_item coi\n        JOIN customer_order co ON co.id = coi.customer_order_id\n        WHERE co.order_code = :orderCode\n      )\n    RETURNING 1\n")
    Flux<Integer> updateStatusByOrderCodeAndSourceWarehouse(String orderCode, String sourceWarehouseCode, String newStatus);
}
