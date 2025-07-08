package com.arka.inventory_service.application.ports.output;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.domain.model.OrderDistribution;
import javax.annotation.Nullable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderDistributionPersistencePort {
    Mono<OrderDistribution> save(OrderDistribution distribution);

    Flux<GroupedDistributionsByOrder> findGroupedByOrderCodeFromSource(String sourceWarehouseCode, @Nullable String status);

    Mono<Integer> updateStatusByOrderCodeAndDestinationWarehouse(String orderCode, String destinationWarehouseCode, String newStatus);

    Mono<Integer> updateStatusByOrderCodeAndSourceWarehouse(String orderCode, String sourceWarehouseCode, String newStatus);
}

