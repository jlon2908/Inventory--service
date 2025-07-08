//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.time.LocalDateTime;
import lombok.Generated;

public class ReservedInventoryResponseDto {
    private String warehouseCode;
    private String orderCode;
    private String sku;
    private int reservedQuantity;
    private String status;
    private LocalDateTime updatedAt;

    @Generated
    public static ReservedInventoryResponseDtoBuilder builder() {
        return new ReservedInventoryResponseDtoBuilder();
    }

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getReservedQuantity() {
        return this.reservedQuantity;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @Generated
    public ReservedInventoryResponseDto(final String warehouseCode, final String orderCode, final String sku, final int reservedQuantity, final String status, final LocalDateTime updatedAt) {
        this.warehouseCode = warehouseCode;
        this.orderCode = orderCode;
        this.sku = sku;
        this.reservedQuantity = reservedQuantity;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    @Generated
    public ReservedInventoryResponseDto() {
    }

    @Generated
    public static class ReservedInventoryResponseDtoBuilder {
        @Generated
        private String warehouseCode;
        @Generated
        private String orderCode;
        @Generated
        private String sku;
        @Generated
        private int reservedQuantity;
        @Generated
        private String status;
        @Generated
        private LocalDateTime updatedAt;

        @Generated
        ReservedInventoryResponseDtoBuilder() {
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder warehouseCode(final String warehouseCode) {
            this.warehouseCode = warehouseCode;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder reservedQuantity(final int reservedQuantity) {
            this.reservedQuantity = reservedQuantity;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDtoBuilder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Generated
        public ReservedInventoryResponseDto build() {
            return new ReservedInventoryResponseDto(this.warehouseCode, this.orderCode, this.sku, this.reservedQuantity, this.status, this.updatedAt);
        }

        @Generated
        public String toString() {
            return "ReservedInventoryResponseDto.ReservedInventoryResponseDtoBuilder(warehouseCode=" + this.warehouseCode + ", orderCode=" + this.orderCode + ", sku=" + this.sku + ", reservedQuantity=" + this.reservedQuantity + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}
