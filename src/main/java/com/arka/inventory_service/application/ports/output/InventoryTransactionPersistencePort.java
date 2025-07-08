package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.InventoryTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryTransactionPersistencePort {
    Mono<InventoryTransaction> save(InventoryTransaction transaction);

    Flux<InventoryTransaction> findBySku(String sku);
}
