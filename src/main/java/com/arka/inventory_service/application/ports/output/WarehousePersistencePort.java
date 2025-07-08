package com.arka.inventory_service.application.ports.output;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WarehousePersistencePort {
    Mono<Warehouse> save(Warehouse warehouse);

    Mono<Void> deleteById(UUID id);

    Flux<Warehouse> findAll();

    Mono<Warehouse> findByCode(String code);

    Mono<Boolean> existsByCode(String code);

    Flux<WarehouseInventoryResponse.InventoryItem> findInventoryByWarehouseId(UUID warehouseId);

    Mono<Warehouse> findById(UUID id);
}

