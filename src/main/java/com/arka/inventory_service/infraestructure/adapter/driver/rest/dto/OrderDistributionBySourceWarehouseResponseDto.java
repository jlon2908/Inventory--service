//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import java.util.List;
import lombok.Generated;

public class OrderDistributionBySourceWarehouseResponseDto {
    private String orderCode;
    private List<DistributedItemDto> items;

    @Generated
    public static OrderDistributionBySourceWarehouseResponseDtoBuilder builder() {
        return new OrderDistributionBySourceWarehouseResponseDtoBuilder();
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public List<DistributedItemDto> getItems() {
        return this.items;
    }

    @Generated
    public OrderDistributionBySourceWarehouseResponseDto(final String orderCode, final List<DistributedItemDto> items) {
        this.orderCode = orderCode;
        this.items = items;
    }

    @Generated
    public OrderDistributionBySourceWarehouseResponseDto() {
    }

    @Generated
    public static class OrderDistributionBySourceWarehouseResponseDtoBuilder {
        @Generated
        private String orderCode;
        @Generated
        private List<DistributedItemDto> items;

        @Generated
        OrderDistributionBySourceWarehouseResponseDtoBuilder() {
        }

        @Generated
        public OrderDistributionBySourceWarehouseResponseDtoBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public OrderDistributionBySourceWarehouseResponseDtoBuilder items(final List<DistributedItemDto> items) {
            this.items = items;
            return this;
        }

        @Generated
        public OrderDistributionBySourceWarehouseResponseDto build() {
            return new OrderDistributionBySourceWarehouseResponseDto(this.orderCode, this.items);
        }

        @Generated
        public String toString() {
            return "OrderDistributionBySourceWarehouseResponseDto.OrderDistributionBySourceWarehouseResponseDtoBuilder(orderCode=" + this.orderCode + ", items=" + this.items + ")";
        }
    }
}
