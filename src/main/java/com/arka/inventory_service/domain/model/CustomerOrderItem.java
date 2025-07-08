//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.util.UUID;
import lombok.Generated;

public class CustomerOrderItem {
    private UUID id;
    private UUID customerOrderId;
    private String sku;
    private int quantity;

    @Generated
    public static CustomerOrderItemBuilder builder() {
        return new CustomerOrderItemBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public UUID getCustomerOrderId() {
        return this.customerOrderId;
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
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setCustomerOrderId(final UUID customerOrderId) {
        this.customerOrderId = customerOrderId;
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
    public CustomerOrderItem(final UUID id, final UUID customerOrderId, final String sku, final int quantity) {
        this.id = id;
        this.customerOrderId = customerOrderId;
        this.sku = sku;
        this.quantity = quantity;
    }

    @Generated
    public CustomerOrderItem() {
    }

    @Generated
    public static class CustomerOrderItemBuilder {
        @Generated
        private UUID id;
        @Generated
        private UUID customerOrderId;
        @Generated
        private String sku;
        @Generated
        private int quantity;

        @Generated
        CustomerOrderItemBuilder() {
        }

        @Generated
        public CustomerOrderItemBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public CustomerOrderItemBuilder customerOrderId(final UUID customerOrderId) {
            this.customerOrderId = customerOrderId;
            return this;
        }

        @Generated
        public CustomerOrderItemBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public CustomerOrderItemBuilder quantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Generated
        public CustomerOrderItem build() {
            return new CustomerOrderItem(this.id, this.customerOrderId, this.sku, this.quantity);
        }

        @Generated
        public String toString() {
            return "CustomerOrderItem.CustomerOrderItemBuilder(id=" + this.id + ", customerOrderId=" + this.customerOrderId + ", sku=" + this.sku + ", quantity=" + this.quantity + ")";
        }
    }
}
