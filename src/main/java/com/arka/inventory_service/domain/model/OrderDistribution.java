//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class OrderDistribution {
    private UUID id;
    private UUID customerOrderItemId;
    private UUID sourceWarehouseId;
    private String destinationWarehouseCode;
    private String sku;
    private int assignedQuantity;
    private String status;
    private LocalDateTime assignedAt;

    @Generated
    public static OrderDistributionBuilder builder() {
        return new OrderDistributionBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public UUID getCustomerOrderItemId() {
        return this.customerOrderItemId;
    }

    @Generated
    public UUID getSourceWarehouseId() {
        return this.sourceWarehouseId;
    }

    @Generated
    public String getDestinationWarehouseCode() {
        return this.destinationWarehouseCode;
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getAssignedQuantity() {
        return this.assignedQuantity;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public LocalDateTime getAssignedAt() {
        return this.assignedAt;
    }

    @Generated
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setCustomerOrderItemId(final UUID customerOrderItemId) {
        this.customerOrderItemId = customerOrderItemId;
    }

    @Generated
    public void setSourceWarehouseId(final UUID sourceWarehouseId) {
        this.sourceWarehouseId = sourceWarehouseId;
    }

    @Generated
    public void setDestinationWarehouseCode(final String destinationWarehouseCode) {
        this.destinationWarehouseCode = destinationWarehouseCode;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setAssignedQuantity(final int assignedQuantity) {
        this.assignedQuantity = assignedQuantity;
    }

    @Generated
    public void setStatus(final String status) {
        this.status = status;
    }

    @Generated
    public void setAssignedAt(final LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    @Generated
    public OrderDistribution(final UUID id, final UUID customerOrderItemId, final UUID sourceWarehouseId, final String destinationWarehouseCode, final String sku, final int assignedQuantity, final String status, final LocalDateTime assignedAt) {
        this.id = id;
        this.customerOrderItemId = customerOrderItemId;
        this.sourceWarehouseId = sourceWarehouseId;
        this.destinationWarehouseCode = destinationWarehouseCode;
        this.sku = sku;
        this.assignedQuantity = assignedQuantity;
        this.status = status;
        this.assignedAt = assignedAt;
    }

    @Generated
    public OrderDistribution() {
    }

    @Generated
    public static class OrderDistributionBuilder {
        @Generated
        private UUID id;
        @Generated
        private UUID customerOrderItemId;
        @Generated
        private UUID sourceWarehouseId;
        @Generated
        private String destinationWarehouseCode;
        @Generated
        private String sku;
        @Generated
        private int assignedQuantity;
        @Generated
        private String status;
        @Generated
        private LocalDateTime assignedAt;

        @Generated
        OrderDistributionBuilder() {
        }

        @Generated
        public OrderDistributionBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public OrderDistributionBuilder customerOrderItemId(final UUID customerOrderItemId) {
            this.customerOrderItemId = customerOrderItemId;
            return this;
        }

        @Generated
        public OrderDistributionBuilder sourceWarehouseId(final UUID sourceWarehouseId) {
            this.sourceWarehouseId = sourceWarehouseId;
            return this;
        }

        @Generated
        public OrderDistributionBuilder destinationWarehouseCode(final String destinationWarehouseCode) {
            this.destinationWarehouseCode = destinationWarehouseCode;
            return this;
        }

        @Generated
        public OrderDistributionBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public OrderDistributionBuilder assignedQuantity(final int assignedQuantity) {
            this.assignedQuantity = assignedQuantity;
            return this;
        }

        @Generated
        public OrderDistributionBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public OrderDistributionBuilder assignedAt(final LocalDateTime assignedAt) {
            this.assignedAt = assignedAt;
            return this;
        }

        @Generated
        public OrderDistribution build() {
            return new OrderDistribution(this.id, this.customerOrderItemId, this.sourceWarehouseId, this.destinationWarehouseCode, this.sku, this.assignedQuantity, this.status, this.assignedAt);
        }

        @Generated
        public String toString() {
            return "OrderDistribution.OrderDistributionBuilder(id=" + this.id + ", customerOrderItemId=" + this.customerOrderItemId + ", sourceWarehouseId=" + this.sourceWarehouseId + ", destinationWarehouseCode=" + this.destinationWarehouseCode + ", sku=" + this.sku + ", assignedQuantity=" + this.assignedQuantity + ", status=" + this.status + ", assignedAt=" + this.assignedAt + ")";
        }
    }
}
