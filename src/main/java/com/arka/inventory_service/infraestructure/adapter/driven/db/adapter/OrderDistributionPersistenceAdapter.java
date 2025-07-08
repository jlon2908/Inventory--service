//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.OrderDistributionPersistencePort;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.domain.model.OrderDistribution;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.OrderDistributionPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.CustomerOrderRepository;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.OrderDistributionRepository;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.WarehouseRepository;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nullable;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Component
public class OrderDistributionPersistenceAdapter implements OrderDistributionPersistencePort {
    private final OrderDistributionRepository repository;
    private final OrderDistributionPersistenceMapper mapper;
    private final WarehouseRepository warehouseRepository;
    private final CustomerOrderRepository customerOrderRepository;

    public Mono<OrderDistribution> save(OrderDistribution distribution) {
        return this.repository.insertOrderDistribution(distribution.getId(), distribution.getCustomerOrderItemId(), distribution.getSourceWarehouseId(), distribution.getDestinationWarehouseCode(), distribution.getSku(), distribution.getAssignedQuantity(), distribution.getStatus(), distribution.getAssignedAt()).thenReturn(distribution);
    }

    public Flux<GroupedDistributionsByOrder> findGroupedByOrderCodeFromSource(String sourceWarehouseCode, @Nullable String status) {
        return this.repository.findWithOrderCodeBySourceWarehouseCode(sourceWarehouseCode, status).map((row) -> Tuples.of(new OrderDistribution(row.id(), row.customerOrderItemId(), row.sourceWarehouseId(), row.destinationWarehouseCode(), row.sku(), row.assignedQuantity(), row.status(), row.assignedAt()), row.orderCode())).collectMultimap(Tuple2::getT2, Tuple2::getT1).flatMapMany((map) -> Flux.fromIterable(map.entrySet())).map((entry) -> new GroupedDistributionsByOrder((String)entry.getKey(), new ArrayList((Collection)entry.getValue())));
    }

    public Mono<Integer> updateStatusByOrderCodeAndDestinationWarehouse(String orderCode, String destinationWarehouseCode, String newStatus) {
        return this.repository.updateStatusByOrderCodeAndDestinationWarehouse(orderCode, destinationWarehouseCode, newStatus).count().map(Long::intValue);
    }

    public Mono<Integer> updateStatusByOrderCodeAndSourceWarehouse(String orderCode, String sourceWarehouseCode, String newStatus) {
        return this.repository.updateStatusByOrderCodeAndSourceWarehouse(orderCode, sourceWarehouseCode, newStatus).count().map(Long::intValue);
    }

    @Generated
    public OrderDistributionPersistenceAdapter(final OrderDistributionRepository repository, final OrderDistributionPersistenceMapper mapper, final WarehouseRepository warehouseRepository, final CustomerOrderRepository customerOrderRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.warehouseRepository = warehouseRepository;
        this.customerOrderRepository = customerOrderRepository;
    }
}
