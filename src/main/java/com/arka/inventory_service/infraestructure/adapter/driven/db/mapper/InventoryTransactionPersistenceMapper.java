//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.InventoryTransaction;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.InventoryTransactionEntity;

public class InventoryTransactionPersistenceMapper {
    public InventoryTransactionPersistenceMapper() {
    }

    public static InventoryTransactionEntity toEntity(InventoryTransaction domain) {
        InventoryTransactionEntity entity = new InventoryTransactionEntity();
        entity.setId(domain.getId());
        entity.setSku(domain.getSku());
        entity.setQuantityChange(domain.getQuantityChange());
        entity.setType(domain.getType());
        entity.setOccurredAt(domain.getOccurredAt());
        return entity;
    }

    public static InventoryTransaction toDomain(InventoryTransactionEntity entity) {
        return new InventoryTransaction(entity.getId(), entity.getSku(), entity.getWarehouseId(), entity.getQuantityChange(), entity.getType(), entity.getOccurredAt());
    }
}
