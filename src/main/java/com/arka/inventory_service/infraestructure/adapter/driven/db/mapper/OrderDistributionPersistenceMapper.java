//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.mapper;

import com.arka.inventory_service.domain.model.OrderDistribution;
import com.arka.inventory_service.infraestructure.adapter.driven.db.entity.OrderDistributionEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderDistributionPersistenceMapper {
    public OrderDistributionPersistenceMapper() {
    }

    public OrderDistributionEntity toEntity(OrderDistribution domain) {
        return new OrderDistributionEntity(domain.getId(), domain.getCustomerOrderItemId(), domain.getSourceWarehouseId(), domain.getDestinationWarehouseCode(), domain.getSku(), domain.getAssignedQuantity(), domain.getStatus(), domain.getAssignedAt());
    }

    public OrderDistribution toDomain(OrderDistributionEntity entity) {
        return new OrderDistribution(entity.getId(), entity.getCustomerOrderItemId(), entity.getSourceWarehouseId(), entity.getDestinationWarehouseCode(), entity.getSku(), entity.getAssignedQuantity(), entity.getStatus(), entity.getAssignedAt());
    }
}
