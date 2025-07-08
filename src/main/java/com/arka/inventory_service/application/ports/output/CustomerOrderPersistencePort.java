package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.CustomerOrder;
import java.time.LocalDateTime;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerOrderPersistencePort {
    Mono<CustomerOrder> save(CustomerOrder order);

    Mono<CustomerOrder> findByOrderCode(String orderCode);

    Mono<Void> update(CustomerOrder customerOrder);

    Flux<CustomerOrder> filterOrders(String orderCode, String warehousePickupCode, String status, LocalDateTime from, LocalDateTime to);
}