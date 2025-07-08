//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.CustomerOrderPersistencePort;
import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.CustomerOrderPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.CustomerOrderRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CustomerOrderPersistenceAdapter implements CustomerOrderPersistencePort {
    private final CustomerOrderRepository repository;
    private final CustomerOrderPersistenceMapper mapper;

    public Mono<CustomerOrder> save(CustomerOrder order) {
        return this.repository.insertCustomerOrder(order.getId(), order.getOrderCode(), order.getUserId(), order.getWarehousePickupCode(), order.getCreatedAt(), order.getStatus()).thenReturn(order);
    }

    public Mono<CustomerOrder> findByOrderCode(String orderCode) {
        Mono<com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderEntity> entityMono = this.repository.findByOrderCode(orderCode);
        CustomerOrderPersistenceMapper var10001 = this.mapper;
        Objects.requireNonNull(var10001);
        return entityMono.map(var10001::toDomain);
    }

    public Mono<Void> update(CustomerOrder customerOrder) {
        return this.repository.updateStatusByOrderCode(customerOrder.getOrderCode(), customerOrder.getStatus());
    }

    public Flux<CustomerOrder> filterOrders(String orderCode, String warehousePickupCode, String status, LocalDateTime from, LocalDateTime to) {
        Flux<com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderEntity> entityFlux = this.repository.filterOrders(orderCode, warehousePickupCode, status, from, to);
        CustomerOrderPersistenceMapper var10001 = this.mapper;
        Objects.requireNonNull(var10001);
        return entityFlux.map(var10001::toDomain);
    }

    @Generated
    public CustomerOrderPersistenceAdapter(final CustomerOrderRepository repository, final CustomerOrderPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
