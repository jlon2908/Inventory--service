//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.mapper;

import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseRequestDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseResponseDto;

public class WarehouseRestMapper {
    public WarehouseRestMapper() {
    }

    public static Warehouse toDomain(WarehouseRequestDto dto) {
        return Warehouse.builder().name(dto.getName()).country(dto.getCountry()).state(dto.getState()).city(dto.getCity()).address(dto.getAddress()).code(dto.getCode()).build();
    }

    public static WarehouseResponseDto toResponseDto(Warehouse warehouse) {
        return WarehouseResponseDto.builder().id(warehouse.getId()).name(warehouse.getName()).country(warehouse.getCountry()).state(warehouse.getState()).city(warehouse.getCity()).address(warehouse.getAddress()).code(warehouse.getCode()).latitude(warehouse.getLatitude()).longitude(warehouse.getLongitude()).createdAt(warehouse.getCreatedAt()).build();
    }
}
