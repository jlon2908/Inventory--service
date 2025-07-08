//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.WarehouseQueryPort;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.WarehousePersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.WarehouseRepository;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class WarehouseQueryAdapter implements WarehouseQueryPort {
    private final WarehouseRepository repository;

    public Mono<UUID> findIdByCode(String warehouseCode) {
        return this.repository.findIdByCode(warehouseCode);
    }

    public Mono<Warehouse> findById(UUID id) {
        return this.repository.findById(id).map(WarehousePersistenceMapper::toDomain);
    }

    @Generated
    public WarehouseQueryAdapter(final WarehouseRepository repository) {
        this.repository = repository;
    }
}
