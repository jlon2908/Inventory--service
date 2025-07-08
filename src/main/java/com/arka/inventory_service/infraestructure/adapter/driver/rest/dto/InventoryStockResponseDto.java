//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.time.LocalDateTime;
import lombok.Generated;

public class InventoryStockResponseDto {
    private String sku;
    private String warehouseCode;
    private int quantity;
    private LocalDateTime lastUpdated;

    @Generated
    public static InventoryStockResponseDtoBuilder builder() {
        return new InventoryStockResponseDtoBuilder();
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    @Generated
    public LocalDateTime getLastUpdated() {
        return this.lastUpdated;
    }

    @Generated
    public InventoryStockResponseDto(final String sku, final String warehouseCode, final int quantity, final LocalDateTime lastUpdated) {
        this.sku = sku;
        this.warehouseCode = warehouseCode;
        this.quantity = quantity;
        this.lastUpdated = lastUpdated;
    }

    @Generated
    public InventoryStockResponseDto() {
    }

    @Generated
    public static class InventoryStockResponseDtoBuilder {
        @Generated
        private String sku;
        @Generated
        private String warehouseCode;
        @Generated
        private int quantity;
        @Generated
        private LocalDateTime lastUpdated;

        @Generated
        InventoryStockResponseDtoBuilder() {
        }

        @Generated
        public InventoryStockResponseDtoBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public InventoryStockResponseDtoBuilder warehouseCode(final String warehouseCode) {
            this.warehouseCode = warehouseCode;
            return this;
        }

        @Generated
        public InventoryStockResponseDtoBuilder quantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Generated
        public InventoryStockResponseDtoBuilder lastUpdated(final LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        @Generated
        public InventoryStockResponseDto build() {
            return new InventoryStockResponseDto(this.sku, this.warehouseCode, this.quantity, this.lastUpdated);
        }

        @Generated
        public String toString() {
            return "InventoryStockResponseDto.InventoryStockResponseDtoBuilder(sku=" + this.sku + ", warehouseCode=" + this.warehouseCode + ", quantity=" + this.quantity + ", lastUpdated=" + this.lastUpdated + ")";
        }
    }
}
