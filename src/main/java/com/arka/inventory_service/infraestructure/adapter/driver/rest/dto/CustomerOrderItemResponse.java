//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import lombok.Generated;

public class CustomerOrderItemResponse {
    private String sku;
    private int quantity;

    @Generated
    public static CustomerOrderItemResponseBuilder builder() {
        return new CustomerOrderItemResponseBuilder();
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
    public CustomerOrderItemResponse(final String sku, final int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    @Generated
    public CustomerOrderItemResponse() {
    }

    @Generated
    public static class CustomerOrderItemResponseBuilder {
        @Generated
        private String sku;
        @Generated
        private int quantity;

        @Generated
        CustomerOrderItemResponseBuilder() {
        }

        @Generated
        public CustomerOrderItemResponseBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public CustomerOrderItemResponseBuilder quantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Generated
        public CustomerOrderItemResponse build() {
            return new CustomerOrderItemResponse(this.sku, this.quantity);
        }

        @Generated
        public String toString() {
            return "CustomerOrderItemResponse.CustomerOrderItemResponseBuilder(sku=" + this.sku + ", quantity=" + this.quantity + ")";
        }
    }
}
