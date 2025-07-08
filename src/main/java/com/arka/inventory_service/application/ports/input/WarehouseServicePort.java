package com.arka.inventory_service.application.ports.input;

import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WarehouseServicePort {
    Mono<Warehouse> createWarehouse(Warehouse warehouse);

    Mono<Void> deleteWarehouseByCode(String code);

    Flux<Warehouse> getAllWarehouses();

    Mono<WarehouseInventoryResponse> getWarehouseInventoryByCode(String code);

    Mono<Warehouse> findById(UUID id);
}