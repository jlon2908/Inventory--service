//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderItemEntity;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerOrderItemRepository extends ReactiveCrudRepository<CustomerOrderItemEntity, UUID> {
    @Query("    INSERT INTO customer_order_item (id, customer_order_id, sku, quantity)\n    VALUES (:id, :customerOrderId, :sku, :quantity)\n")
    Mono<Void> insertCustomerOrderItem(UUID id, UUID customerOrderId, String sku, int quantity);

    @Query("SELECT sku, quantity FROM customer_order_item WHERE customer_order_id = :orderId")
    Flux<CustomerOrderItemEntity> findByCustomerOrderId(UUID orderId);
}
