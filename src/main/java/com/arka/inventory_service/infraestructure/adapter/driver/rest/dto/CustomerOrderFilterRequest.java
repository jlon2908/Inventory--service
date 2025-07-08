//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.time.LocalDateTime;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class CustomerOrderFilterRequest {
    private String orderCode;
    private String warehousePickupCode;
    private String status;
    @DateTimeFormat(
            iso = ISO.DATE_TIME
    )
    private LocalDateTime createdFrom;
    @DateTimeFormat(
            iso = ISO.DATE_TIME
    )
    private LocalDateTime createdTo;

    @Generated
    public static CustomerOrderFilterRequestBuilder builder() {
        return new CustomerOrderFilterRequestBuilder();
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public String getWarehousePickupCode() {
        return this.warehousePickupCode;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public LocalDateTime getCreatedFrom() {
        return this.createdFrom;
    }

    @Generated
    public LocalDateTime getCreatedTo() {
        return this.createdTo;
    }

    @Generated
    public CustomerOrderFilterRequest(final String orderCode, final String warehousePickupCode, final String status, final LocalDateTime createdFrom, final LocalDateTime createdTo) {
        this.orderCode = orderCode;
        this.warehousePickupCode = warehousePickupCode;
        this.status = status;
        this.createdFrom = createdFrom;
        this.createdTo = createdTo;
    }

    @Generated
    public CustomerOrderFilterRequest() {
    }

    @Generated
    public static class CustomerOrderFilterRequestBuilder {
        @Generated
        private String orderCode;
        @Generated
        private String warehousePickupCode;
        @Generated
        private String status;
        @Generated
        private LocalDateTime createdFrom;
        @Generated
        private LocalDateTime createdTo;

        @Generated
        CustomerOrderFilterRequestBuilder() {
        }

        @Generated
        public CustomerOrderFilterRequestBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public CustomerOrderFilterRequestBuilder warehousePickupCode(final String warehousePickupCode) {
            this.warehousePickupCode = warehousePickupCode;
            return this;
        }

        @Generated
        public CustomerOrderFilterRequestBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public CustomerOrderFilterRequestBuilder createdFrom(final LocalDateTime createdFrom) {
            this.createdFrom = createdFrom;
            return this;
        }

        @Generated
        public CustomerOrderFilterRequestBuilder createdTo(final LocalDateTime createdTo) {
            this.createdTo = createdTo;
            return this;
        }

        @Generated
        public CustomerOrderFilterRequest build() {
            return new CustomerOrderFilterRequest(this.orderCode, this.warehousePickupCode, this.status, this.createdFrom, this.createdTo);
        }

        @Generated
        public String toString() {
            return "CustomerOrderFilterRequest.CustomerOrderFilterRequestBuilder(orderCode=" + this.orderCode + ", warehousePickupCode=" + this.warehousePickupCode + ", status=" + this.status + ", createdFrom=" + this.createdFrom + ", createdTo=" + this.createdTo + ")";
        }
    }
}
