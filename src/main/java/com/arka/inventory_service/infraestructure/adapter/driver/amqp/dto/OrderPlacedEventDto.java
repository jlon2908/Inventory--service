//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto;

import java.util.List;
import lombok.Generated;

public class OrderPlacedEventDto {
    private String orderCode;
    private String userId;
    private String warehousePickupCode;
    private List<OrderItemDto> items;

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public String getUserId() {
        return this.userId;
    }

    @Generated
    public String getWarehousePickupCode() {
        return this.warehousePickupCode;
    }

    @Generated
    public List<OrderItemDto> getItems() {
        return this.items;
    }

    @Generated
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    @Generated
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Generated
    public void setWarehousePickupCode(final String warehousePickupCode) {
        this.warehousePickupCode = warehousePickupCode;
    }

    @Generated
    public void setItems(final List<OrderItemDto> items) {
        this.items = items;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderPlacedEventDto)) {
            return false;
        } else {
            OrderPlacedEventDto other = (OrderPlacedEventDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$orderCode = this.getOrderCode();
                Object other$orderCode = other.getOrderCode();
                if (this$orderCode == null) {
                    if (other$orderCode != null) {
                        return false;
                    }
                } else if (!this$orderCode.equals(other$orderCode)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$warehousePickupCode = this.getWarehousePickupCode();
                Object other$warehousePickupCode = other.getWarehousePickupCode();
                if (this$warehousePickupCode == null) {
                    if (other$warehousePickupCode != null) {
                        return false;
                    }
                } else if (!this$warehousePickupCode.equals(other$warehousePickupCode)) {
                    return false;
                }

                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof OrderPlacedEventDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $orderCode = this.getOrderCode();
        result = result * 59 + ($orderCode == null ? 43 : $orderCode.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $warehousePickupCode = this.getWarehousePickupCode();
        result = result * 59 + ($warehousePickupCode == null ? 43 : $warehousePickupCode.hashCode());
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getOrderCode();
        return "OrderPlacedEventDto(orderCode=" + var10000 + ", userId=" + this.getUserId() + ", warehousePickupCode=" + this.getWarehousePickupCode() + ", items=" + this.getItems() + ")";
    }

    @Generated
    public OrderPlacedEventDto() {
    }

    @Generated
    public OrderPlacedEventDto(final String orderCode, final String userId, final String warehousePickupCode, final List<OrderItemDto> items) {
        this.orderCode = orderCode;
        this.userId = userId;
        this.warehousePickupCode = warehousePickupCode;
        this.items = items;
    }
}
