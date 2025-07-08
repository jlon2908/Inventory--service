//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto;

import lombok.Generated;

public class StockItemDto {
    private String sku;
    private int quantity;
    private String warehouseCode;

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setWarehouseCode(final String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StockItemDto)) {
            return false;
        } else {
            StockItemDto other = (StockItemDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getQuantity() != other.getQuantity()) {
                return false;
            } else {
                Object this$sku = this.getSku();
                Object other$sku = other.getSku();
                if (this$sku == null) {
                    if (other$sku != null) {
                        return false;
                    }
                } else if (!this$sku.equals(other$sku)) {
                    return false;
                }

                Object this$warehouseCode = this.getWarehouseCode();
                Object other$warehouseCode = other.getWarehouseCode();
                if (this$warehouseCode == null) {
                    if (other$warehouseCode != null) {
                        return false;
                    }
                } else if (!this$warehouseCode.equals(other$warehouseCode)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof StockItemDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantity();
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $warehouseCode = this.getWarehouseCode();
        result = result * 59 + ($warehouseCode == null ? 43 : $warehouseCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getSku();
        return "StockItemDto(sku=" + var10000 + ", quantity=" + this.getQuantity() + ", warehouseCode=" + this.getWarehouseCode() + ")";
    }

    @Generated
    public StockItemDto() {
    }

    @Generated
    public StockItemDto(final String sku, final int quantity, final String warehouseCode) {
        this.sku = sku;
        this.quantity = quantity;
        this.warehouseCode = warehouseCode;
    }
}
