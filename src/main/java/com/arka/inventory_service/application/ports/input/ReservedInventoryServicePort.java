package com.arka.inventory_service.application.ports.input;

import com.arka.inventory_service.domain.model.ReservedInventory;
import reactor.core.publisher.Flux;

public interface ReservedInventoryServicePort {
    Flux<ReservedInventory> getByOrderCode(String orderCode);
}
