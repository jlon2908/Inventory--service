//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.util.UUID;
import lombok.Generated;

public class IncreaseStockRequestDto {
    private String sku;
    private int quantity;
    private UUID warehouseId;

    @Generated
    public static IncreaseStockRequestDtoBuilder builder() {
        return new IncreaseStockRequestDtoBuilder();
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    @Generated
    public UUID getWarehouseId() {
        return this.warehouseId;
    }

    @Generated
    public IncreaseStockRequestDto(final String sku, final int quantity, final UUID warehouseId) {
        this.sku = sku;
        this.quantity = quantity;
        this.warehouseId = warehouseId;
    }

    @Generated
    public IncreaseStockRequestDto() {
    }

    @Generated
    public static class IncreaseStockRequestDtoBuilder {
        @Generated
        private String sku;
        @Generated
        private int quantity;
        @Generated
        private UUID warehouseId;

        @Generated
        IncreaseStockRequestDtoBuilder() {
        }

        @Generated
        public IncreaseStockRequestDtoBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public IncreaseStockRequestDtoBuilder quantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Generated
        public IncreaseStockRequestDtoBuilder warehouseId(final UUID warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        @Generated
        public IncreaseStockRequestDto build() {
            return new IncreaseStockRequestDto(this.sku, this.quantity, this.warehouseId);
        }

        @Generated
        public String toString() {
            return "IncreaseStockRequestDto.IncreaseStockRequestDtoBuilder(sku=" + this.sku + ", quantity=" + this.quantity + ", warehouseId=" + this.warehouseId + ")";
        }
    }
}
