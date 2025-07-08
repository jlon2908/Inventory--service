package com.arka.inventory_service.application.ports.input;


import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DistributedOrderServicePort {
    Flux<GroupedDistributionsByOrder> getGroupedDistributionsByOrder(String sourceWarehouseCode, String status);

    Mono<Integer> updateDistributionsStatus(String orderCode, String sourceWarehouseCode, String newStatus);
}