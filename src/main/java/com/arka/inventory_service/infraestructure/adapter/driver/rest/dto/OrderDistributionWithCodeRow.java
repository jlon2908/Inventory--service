//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record OrderDistributionWithCodeRow(UUID id, UUID customerOrderItemId, UUID sourceWarehouseId, String destinationWarehouseCode, String sku, int assignedQuantity, String status, LocalDateTime assignedAt, String orderCode) {
    public OrderDistributionWithCodeRow(UUID id, UUID customerOrderItemId, UUID sourceWarehouseId, String destinationWarehouseCode, String sku, int assignedQuantity, String status, LocalDateTime assignedAt, String orderCode) {
        this.id = id;
        this.customerOrderItemId = customerOrderItemId;
        this.sourceWarehouseId = sourceWarehouseId;
        this.destinationWarehouseCode = destinationWarehouseCode;
        this.sku = sku;
        this.assignedQuantity = assignedQuantity;
        this.status = status;
        this.assignedAt = assignedAt;
        this.orderCode = orderCode;
    }

    public UUID id() {
        return this.id;
    }

    public UUID customerOrderItemId() {
        return this.customerOrderItemId;
    }

    public UUID sourceWarehouseId() {
        return this.sourceWarehouseId;
    }

    public String destinationWarehouseCode() {
        return this.destinationWarehouseCode;
    }

    public String sku() {
        return this.sku;
    }

    public int assignedQuantity() {
        return this.assignedQuantity;
    }

    public String status() {
        return this.status;
    }

    public LocalDateTime assignedAt() {
        return this.assignedAt;
    }

    public String orderCode() {
        return this.orderCode;
    }
}
