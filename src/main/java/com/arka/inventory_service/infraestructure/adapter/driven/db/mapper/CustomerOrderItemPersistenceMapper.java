//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.CustomerOrderItem;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderItemEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderItemPersistenceMapper {
    public CustomerOrderItemPersistenceMapper() {
    }

    public CustomerOrderItemEntity toEntity(CustomerOrderItem domain) {
        return new CustomerOrderItemEntity(domain.getId(), domain.getCustomerOrderId(), domain.getSku(), domain.getQuantity());
    }

    public CustomerOrderItem toDomain(CustomerOrderItemEntity entity) {
        return new CustomerOrderItem(entity.getId(), entity.getCustomerOrderId(), entity.getSku(), entity.getQuantity());
    }
}
