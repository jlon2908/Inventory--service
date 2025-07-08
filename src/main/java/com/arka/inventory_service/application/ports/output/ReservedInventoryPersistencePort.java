package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.ReservedInventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReservedInventoryPersistencePort {
    Mono<Void> upsertReservedInventory(ReservedInventory reserved);

    Flux<ReservedInventory> findByOrderCode(String orderCode);
}
