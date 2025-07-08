package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.CustomerOrderItem;
import java.util.List;
import reactor.core.publisher.Flux;

public interface CustomerOrderItemPersistencePort {
    Flux<CustomerOrderItem> saveAll(List<CustomerOrderItem> items);
}
