//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.WarehouseEntity;

public class WarehousePersistenceMapper {
    public WarehousePersistenceMapper() {
    }

    public static Warehouse toDomain(WarehouseEntity entity) {
        return Warehouse.builder().id(entity.getId()).name(entity.getName()).country(entity.getCountry()).state(entity.getState()).city(entity.getCity()).address(entity.getAddress()).code(entity.getCode()).latitude(entity.getLatitude()).longitude(entity.getLongitude()).createdAt(entity.getCreatedAt()).build();
    }

    public static WarehouseEntity toEntity(Warehouse warehouse) {
        WarehouseEntity entity = new WarehouseEntity();
        entity.setId(warehouse.getId());
        entity.setName(warehouse.getName());
        entity.setCountry(warehouse.getCountry());
        entity.setState(warehouse.getState());
        entity.setCity(warehouse.getCity());
        entity.setAddress(warehouse.getAddress());
        entity.setCode(warehouse.getCode());
        entity.setLatitude(warehouse.getLatitude());
        entity.setLongitude(warehouse.getLongitude());
        entity.setCreatedAt(warehouse.getCreatedAt());
        return entity;
    }
}
