package com.arka.inventory_service.application.ports.input;

import com.arka.inventory_service.domain.model.CustomerOrder;
import java.time.LocalDateTime;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerOrderInServicePort {
    Mono<Void> updateStatus(String orderCode, String newStatus);

    Flux<CustomerOrder> filterOrders(String orderCode, String warehousePickupCode, String status, LocalDateTime from, LocalDateTime to);

    Mono<Void> cancelOrderByCustomer(String orderCode, UUID customerId);
}
