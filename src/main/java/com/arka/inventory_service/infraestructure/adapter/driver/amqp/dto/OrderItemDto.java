//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto;

import java.util.List;
import lombok.Generated;

public class OrderItemDto {
    private String sku;
    private List<ItemDistributionDto> assignedDistributions;

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public List<ItemDistributionDto> getAssignedDistributions() {
        return this.assignedDistributions;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setAssignedDistributions(final List<ItemDistributionDto> assignedDistributions) {
        this.assignedDistributions = assignedDistributions;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderItemDto)) {
            return false;
        } else {
            OrderItemDto other = (OrderItemDto)o;
            if (!other.canEqual(this)) {
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

                Object this$assignedDistributions = this.getAssignedDistributions();
                Object other$assignedDistributions = other.getAssignedDistributions();
                if (this$assignedDistributions == null) {
                    if (other$assignedDistributions != null) {
                        return false;
                    }
                } else if (!this$assignedDistributions.equals(other$assignedDistributions)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof OrderItemDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $assignedDistributions = this.getAssignedDistributions();
        result = result * 59 + ($assignedDistributions == null ? 43 : $assignedDistributions.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getSku();
        return "OrderItemDto(sku=" + var10000 + ", assignedDistributions=" + this.getAssignedDistributions() + ")";
    }

    @Generated
    public OrderItemDto() {
    }

    @Generated
    public OrderItemDto(final String sku, final List<ItemDistributionDto> assignedDistributions) {
        this.sku = sku;
        this.assignedDistributions = assignedDistributions;
    }
}
