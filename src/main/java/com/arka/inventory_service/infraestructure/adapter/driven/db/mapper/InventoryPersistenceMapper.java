//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.InventoryEntity;

public class InventoryPersistenceMapper {
    public InventoryPersistenceMapper() {
    }

    public static InventoryEntity toEntity(Inventory domain) {
        InventoryEntity entity = new InventoryEntity();
        entity.setId(domain.getId());
        entity.setSku(domain.getSku());
        entity.setQuantity(domain.getQuantity());
        entity.setUpdatedAt(domain.getUpdatedAt());
        return entity;
    }

    public static Inventory toDomain(InventoryEntity entity) {
        return new Inventory(entity.getId(), entity.getSku(), entity.getWarehouseId(), entity.getQuantity(), entity.getUpdatedAt());
    }
}
