//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto;

import lombok.Generated;

public class ItemDistributionDto {
    private String warehouseCode;
    private int quantity;

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    @Generated
    public void setWarehouseCode(final String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    @Generated
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ItemDistributionDto)) {
            return false;
        } else {
            ItemDistributionDto other = (ItemDistributionDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getQuantity() != other.getQuantity()) {
                return false;
            } else {
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
        return other instanceof ItemDistributionDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantity();
        Object $warehouseCode = this.getWarehouseCode();
        result = result * 59 + ($warehouseCode == null ? 43 : $warehouseCode.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getWarehouseCode();
        return "ItemDistributionDto(warehouseCode=" + var10000 + ", quantity=" + this.getQuantity() + ")";
    }

    @Generated
    public ItemDistributionDto() {
    }

    @Generated
    public ItemDistributionDto(final String warehouseCode, final int quantity) {
        this.warehouseCode = warehouseCode;
        this.quantity = quantity;
    }
}
