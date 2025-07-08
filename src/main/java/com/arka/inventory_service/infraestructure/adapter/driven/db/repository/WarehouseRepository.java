//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.repository;

import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.WarehouseEntity;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WarehouseRepository extends ReactiveCrudRepository<WarehouseEntity, UUID> {
    @Query("SELECT id FROM warehouse WHERE code = :code")
    Mono<UUID> findIdByCode(String code);

    @Query("SELECT COUNT(*) > 0 FROM warehouse WHERE code = :code")
    Mono<Boolean> existsByCode(String code);

    @Query("    INSERT INTO warehouse (\n        id, name, country, state, city, address, code, latitude, longitude, created_at\n    ) VALUES (\n        :id, :name, :country, :state, :city, :address, :code, :latitude, :longitude, :createdAt\n    )\n")
    Mono<Void> insertWarehouse(UUID id, String name, String country, String state, String city, String address, String code, Double latitude, Double longitude, LocalDateTime createdAt);

    @Query("SELECT * FROM warehouse WHERE code = :code")
    Mono<WarehouseEntity> findByCode(String code);

    @Query("    SELECT sku, quantity, updated_at\n    FROM inventory\n    WHERE warehouse_id = :warehouseId\n")
    Flux<WarehouseInventoryResponse.InventoryItem> findInventoryByWarehouseId(UUID warehouseId);
}
