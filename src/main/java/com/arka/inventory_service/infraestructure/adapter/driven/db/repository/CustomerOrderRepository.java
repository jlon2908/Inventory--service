//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderEntity;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerOrderRepository extends ReactiveCrudRepository<CustomerOrderEntity, UUID> {
    @Query("    INSERT INTO customer_order (id, order_code, user_id, warehouse_pickup_code, created_at, status)\n    VALUES (:id, :orderCode, :userId, :warehousePickupCode, :createdAt, :status)\n")
    Mono<Void> insertCustomerOrder(UUID id, String orderCode, UUID userId, String warehousePickupCode, LocalDateTime createdAt, String status);

    @Query("SELECT * FROM customer_order WHERE order_code = :orderCode")
    Mono<CustomerOrderEntity> findByOrderCode(String orderCode);

    @Query("    UPDATE customer_order\n    SET status = :status\n    WHERE order_code = :orderCode\n")
    Mono<Void> updateStatusByOrderCode(String orderCode, String status);

    @Query("    SELECT * FROM customer_order\n    WHERE (:orderCode IS NULL OR order_code = :orderCode)\n      AND (:warehousePickupCode IS NULL OR warehouse_pickup_code = :warehousePickupCode)\n      AND (:status IS NULL OR status = :status)\n      AND (\n           (:from IS NULL AND :to IS NULL)\n           OR (:from IS NULL AND created_at <= :to)\n           OR (:to IS NULL AND created_at >= :from)\n           OR (created_at BETWEEN :from AND :to)\n      )\n")
    Flux<CustomerOrderEntity> filterOrders(@Param("orderCode") String orderCode, @Param("warehousePickupCode") String warehousePickupCode, @Param("status") String status, @Param("from") LocalDateTime from, @Param("to") LocalDateTime to);
}
