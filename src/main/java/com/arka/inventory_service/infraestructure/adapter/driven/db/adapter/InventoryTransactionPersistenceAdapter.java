//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.InventoryTransactionPersistencePort;
import com.arka.inventory_service.domain.model.InventoryTransaction;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.InventoryTransactionPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.InventoryTransactionRepository;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class InventoryTransactionPersistenceAdapter implements InventoryTransactionPersistencePort {
    private final InventoryTransactionRepository repository;

    public Mono<InventoryTransaction> save(InventoryTransaction transaction) {
        return this.repository.insertTransaction(transaction.getId(), transaction.getSku(), transaction.getWarehouseId(), transaction.getQuantityChange(), transaction.getType(), transaction.getOccurredAt()).thenReturn(transaction);
    }

    public Flux<InventoryTransaction> findBySku(String sku) {
        return this.repository.findBySku(sku).map(InventoryTransactionPersistenceMapper::toDomain);
    }

    @Generated
    public InventoryTransactionPersistenceAdapter(final InventoryTransactionRepository repository) {
        this.repository = repository;
    }
}
