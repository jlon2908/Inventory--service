//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.ReservedInventory;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.ReservedInventoryEntity;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.ReservedInventoryResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ReservedInventoryPersistenceMapper {
    public ReservedInventoryPersistenceMapper() {
    }

    public ReservedInventoryEntity toEntity(ReservedInventory domain) {
        return new ReservedInventoryEntity(domain.getId(), domain.getWarehouseCode(), domain.getOrderCode(), domain.getSku(), domain.getReservedQuantity(), domain.getStatus(), domain.getUpdatedAt());
    }

    public ReservedInventory toDomain(ReservedInventoryEntity entity) {
        return new ReservedInventory(entity.getId(), entity.getWarehouseCode(), entity.getOrderCode(), entity.getSku(), entity.getReservedQuantity(), entity.getStatus(), entity.getUpdatedAt());
    }

    public ReservedInventoryResponseDto toResponse(ReservedInventory domain) {
        return ReservedInventoryResponseDto.builder().warehouseCode(domain.getWarehouseCode()).orderCode(domain.getOrderCode()).sku(domain.getSku()).reservedQuantity(domain.getReservedQuantity()).status(domain.getStatus()).updatedAt(domain.getUpdatedAt()).build();
    }
}
