//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class CustomerOrder {
    private UUID id;
    private String orderCode;
    private UUID userId;
    private String warehousePickupCode;
    private LocalDateTime createdAt;
    private String status;

    @Generated
    public static CustomerOrderBuilder builder() {
        return new CustomerOrderBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public UUID getUserId() {
        return this.userId;
    }

    @Generated
    public String getWarehousePickupCode() {
        return this.warehousePickupCode;
    }

    @Generated
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    @Generated
    public void setUserId(final UUID userId) {
        this.userId = userId;
    }

    @Generated
    public void setWarehousePickupCode(final String warehousePickupCode) {
        this.warehousePickupCode = warehousePickupCode;
    }

    @Generated
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Generated
    public void setStatus(final String status) {
        this.status = status;
    }

    @Generated
    public CustomerOrder(final UUID id, final String orderCode, final UUID userId, final String warehousePickupCode, final LocalDateTime createdAt, final String status) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.warehousePickupCode = warehousePickupCode;
        this.createdAt = createdAt;
        this.status = status;
    }

    @Generated
    public CustomerOrder() {
    }

    @Generated
    public static class CustomerOrderBuilder {
        @Generated
        private UUID id;
        @Generated
        private String orderCode;
        @Generated
        private UUID userId;
        @Generated
        private String warehousePickupCode;
        @Generated
        private LocalDateTime createdAt;
        @Generated
        private String status;

        @Generated
        CustomerOrderBuilder() {
        }

        @Generated
        public CustomerOrderBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public CustomerOrderBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public CustomerOrderBuilder userId(final UUID userId) {
            this.userId = userId;
            return this;
        }

        @Generated
        public CustomerOrderBuilder warehousePickupCode(final String warehousePickupCode) {
            this.warehousePickupCode = warehousePickupCode;
            return this;
        }

        @Generated
        public CustomerOrderBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Generated
        public CustomerOrderBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public CustomerOrder build() {
            return new CustomerOrder(this.id, this.orderCode, this.userId, this.warehousePickupCode, this.createdAt, this.status);
        }

        @Generated
        public String toString() {
            return "CustomerOrder.CustomerOrderBuilder(id=" + this.id + ", orderCode=" + this.orderCode + ", userId=" + this.userId + ", warehousePickupCode=" + this.warehousePickupCode + ", createdAt=" + this.createdAt + ", status=" + this.status + ")";
        }
    }
}
