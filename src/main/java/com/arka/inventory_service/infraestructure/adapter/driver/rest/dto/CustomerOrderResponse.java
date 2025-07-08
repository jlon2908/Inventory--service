//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Generated;

public class CustomerOrderResponse {
    private UUID id;
    private String orderCode;
    private String status;
    private String warehousePickupCode;
    private LocalDateTime createdAt;
    private List<CustomerOrderItemResponse> items;

    @Generated
    public static CustomerOrderResponseBuilder builder() {
        return new CustomerOrderResponseBuilder();
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
    public String getStatus() {
        return this.status;
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
    public List<CustomerOrderItemResponse> getItems() {
        return this.items;
    }

    @Generated
    public CustomerOrderResponse(final UUID id, final String orderCode, final String status, final String warehousePickupCode, final LocalDateTime createdAt, final List<CustomerOrderItemResponse> items) {
        this.id = id;
        this.orderCode = orderCode;
        this.status = status;
        this.warehousePickupCode = warehousePickupCode;
        this.createdAt = createdAt;
        this.items = items;
    }

    @Generated
    public CustomerOrderResponse() {
    }

    @Generated
    public static class CustomerOrderResponseBuilder {
        @Generated
        private UUID id;
        @Generated
        private String orderCode;
        @Generated
        private String status;
        @Generated
        private String warehousePickupCode;
        @Generated
        private LocalDateTime createdAt;
        @Generated
        private List<CustomerOrderItemResponse> items;

        @Generated
        CustomerOrderResponseBuilder() {
        }

        @Generated
        public CustomerOrderResponseBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public CustomerOrderResponseBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public CustomerOrderResponseBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public CustomerOrderResponseBuilder warehousePickupCode(final String warehousePickupCode) {
            this.warehousePickupCode = warehousePickupCode;
            return this;
        }

        @Generated
        public CustomerOrderResponseBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Generated
        public CustomerOrderResponseBuilder items(final List<CustomerOrderItemResponse> items) {
            this.items = items;
            return this;
        }

        @Generated
        public CustomerOrderResponse build() {
            return new CustomerOrderResponse(this.id, this.orderCode, this.status, this.warehousePickupCode, this.createdAt, this.items);
        }

        @Generated
        public String toString() {
            return "CustomerOrderResponse.CustomerOrderResponseBuilder(id=" + this.id + ", orderCode=" + this.orderCode + ", status=" + this.status + ", warehousePickupCode=" + this.warehousePickupCode + ", createdAt=" + this.createdAt + ", items=" + this.items + ")";
        }
    }
}
