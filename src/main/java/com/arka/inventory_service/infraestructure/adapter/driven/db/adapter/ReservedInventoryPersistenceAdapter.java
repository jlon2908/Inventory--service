//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.ReservedInventoryPersistencePort;
import com.arka.inventory_service.domain.model.ReservedInventory;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.ReservedInventoryPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.ReservedInventoryRepository;
import java.util.Objects;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReservedInventoryPersistenceAdapter implements ReservedInventoryPersistencePort {
    private final ReservedInventoryRepository repository;
    private final ReservedInventoryPersistenceMapper mapper;

    public Mono<Void> upsertReservedInventory(ReservedInventory reserved) {
        return this.repository.upsertReservedInventory(reserved.getId(), reserved.getWarehouseCode(), reserved.getOrderCode(), reserved.getSku(), reserved.getReservedQuantity(), reserved.getStatus(), reserved.getUpdatedAt());
    }

    public Flux<ReservedInventory> findByOrderCode(String orderCode) {
        Flux<com.arka.inventory_service.infraestructure.adapter.driven.db.entity.ReservedInventoryEntity> entityFlux = this.repository.findByOrderCode(orderCode);
        ReservedInventoryPersistenceMapper var10001 = this.mapper;
        Objects.requireNonNull(var10001);
        return entityFlux.map(var10001::toDomain);
    }

    @Generated
    public ReservedInventoryPersistenceAdapter(final ReservedInventoryRepository repository, final ReservedInventoryPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
