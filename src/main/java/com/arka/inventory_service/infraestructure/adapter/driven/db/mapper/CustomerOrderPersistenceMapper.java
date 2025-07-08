//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderEntity;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.CustomerOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderPersistenceMapper {
    public CustomerOrderPersistenceMapper() {
    }

    public CustomerOrderEntity toEntity(CustomerOrder domain) {
        return new CustomerOrderEntity(domain.getId(), domain.getOrderCode(), domain.getUserId(), domain.getWarehousePickupCode(), domain.getCreatedAt(), domain.getStatus());
    }

    public CustomerOrder toDomain(CustomerOrderEntity entity) {
        return new CustomerOrder(entity.getId(), entity.getOrderCode(), entity.getUserId(), entity.getWarehousePickupCode(), entity.getCreatedAt(), entity.getStatus());
    }

    public CustomerOrderResponse toResponse(CustomerOrder domain) {
        return CustomerOrderResponse.builder().id(domain.getId()).orderCode(domain.getOrderCode()).warehousePickupCode(domain.getWarehousePickupCode()).createdAt(domain.getCreatedAt()).status(domain.getStatus()).build();
    }
}
