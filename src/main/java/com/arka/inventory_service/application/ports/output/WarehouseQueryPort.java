package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.Warehouse;
import java.util.UUID;
import reactor.core.publisher.Mono;

public interface WarehouseQueryPort {
    Mono<UUID> findIdByCode(String warehouseCode);

    Mono<Warehouse> findById(UUID id);
}
