//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.CustomerOrderItemPersistencePort;
import com.arka.inventory_service.domain.model.CustomerOrderItem;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.CustomerOrderItemPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.CustomerOrderItemRepository;
import java.util.List;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class CustomerOrderItemPersistenceAdapter implements CustomerOrderItemPersistencePort {
    private final CustomerOrderItemRepository repository;
    private final CustomerOrderItemPersistenceMapper mapper;

    public Flux<CustomerOrderItem> saveAll(List<CustomerOrderItem> items) {
        return Flux.fromIterable(items).flatMap((item) -> this.repository.insertCustomerOrderItem(item.getId(), item.getCustomerOrderId(), item.getSku(), item.getQuantity()).thenReturn(item));
    }

    @Generated
    public CustomerOrderItemPersistenceAdapter(final CustomerOrderItemRepository repository, final CustomerOrderItemPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
