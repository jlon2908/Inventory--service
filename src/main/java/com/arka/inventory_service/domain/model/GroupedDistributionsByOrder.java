//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.util.List;
import lombok.Generated;

public class GroupedDistributionsByOrder {
    private String orderCode;
    private List<OrderDistribution> items;

    @Generated
    public static GroupedDistributionsByOrderBuilder builder() {
        return new GroupedDistributionsByOrderBuilder();
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public List<OrderDistribution> getItems() {
        return this.items;
    }

    @Generated
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    @Generated
    public void setItems(final List<OrderDistribution> items) {
        this.items = items;
    }

    @Generated
    public GroupedDistributionsByOrder(final String orderCode, final List<OrderDistribution> items) {
        this.orderCode = orderCode;
        this.items = items;
    }

    @Generated
    public static class GroupedDistributionsByOrderBuilder {
        @Generated
        private String orderCode;
        @Generated
        private List<OrderDistribution> items;

        @Generated
        GroupedDistributionsByOrderBuilder() {
        }

        @Generated
        public GroupedDistributionsByOrderBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public GroupedDistributionsByOrderBuilder items(final List<OrderDistribution> items) {
            this.items = items;
            return this;
        }

        @Generated
        public GroupedDistributionsByOrder build() {
            return new GroupedDistributionsByOrder(this.orderCode, this.items);
        }

        @Generated
        public String toString() {
            return "GroupedDistributionsByOrder.GroupedDistributionsByOrderBuilder(orderCode=" + this.orderCode + ", items=" + this.items + ")";
        }
    }
}
