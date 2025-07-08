//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.adapter;

import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.WarehousePersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.WarehouseRepository;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class WarehousePersistenceAdapter implements WarehousePersistencePort {
    private final WarehouseRepository repository;

    public Mono<Warehouse> save(Warehouse warehouse) {
        return this.repository.insertWarehouse(warehouse.getId(), warehouse.getName(), warehouse.getCountry(), warehouse.getState(), warehouse.getCity(), warehouse.getAddress(), warehouse.getCode(), warehouse.getLatitude(), warehouse.getLongitude(), warehouse.getCreatedAt()).thenReturn(warehouse);
    }

    public Mono<Void> deleteById(UUID id) {
        return this.repository.deleteById(id);
    }

    public Flux<Warehouse> findAll() {
        return this.repository.findAll().map(WarehousePersistenceMapper::toDomain);
    }

    public Mono<Warehouse> findByCode(String code) {
        return this.repository.findByCode(code).map(WarehousePersistenceMapper::toDomain);
    }

    public Mono<Boolean> existsByCode(String code) {
        return this.repository.existsByCode(code);
    }

    public Flux<WarehouseInventoryResponse.InventoryItem> findInventoryByWarehouseId(UUID warehouseId) {
        return this.repository.findInventoryByWarehouseId(warehouseId);
    }

    public Mono<Warehouse> findById(UUID id) {
        return this.repository.findById(id).map(WarehousePersistenceMapper::toDomain);
    }

    @Generated
    public WarehousePersistenceAdapter(final WarehouseRepository repository) {
        this.repository = repository;
    }
}
