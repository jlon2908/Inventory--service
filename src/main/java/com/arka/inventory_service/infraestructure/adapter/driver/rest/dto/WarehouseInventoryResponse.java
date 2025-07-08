//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import com.arka.inventory_service.domain.model.Warehouse;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

public class WarehouseInventoryResponse {
    private Warehouse warehouse;
    private List<InventoryItem> inventory;

    @Generated
    public static WarehouseInventoryResponseBuilder builder() {
        return new WarehouseInventoryResponseBuilder();
    }

    @Generated
    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    @Generated
    public List<InventoryItem> getInventory() {
        return this.inventory;
    }

    @Generated
    public WarehouseInventoryResponse(final Warehouse warehouse, final List<InventoryItem> inventory) {
        this.warehouse = warehouse;
        this.inventory = inventory;
    }

    @Generated
    public WarehouseInventoryResponse() {
    }

    @Generated
    public static class WarehouseInventoryResponseBuilder {
        @Generated
        private Warehouse warehouse;
        @Generated
        private List<InventoryItem> inventory;

        @Generated
        WarehouseInventoryResponseBuilder() {
        }

        @Generated
        public WarehouseInventoryResponseBuilder warehouse(final Warehouse warehouse) {
            this.warehouse = warehouse;
            return this;
        }

        @Generated
        public WarehouseInventoryResponseBuilder inventory(final List<InventoryItem> inventory) {
            this.inventory = inventory;
            return this;
        }

        @Generated
        public WarehouseInventoryResponse build() {
            return new WarehouseInventoryResponse(this.warehouse, this.inventory);
        }

        @Generated
        public String toString() {
            return "WarehouseInventoryResponse.WarehouseInventoryResponseBuilder(warehouse=" + this.warehouse + ", inventory=" + this.inventory + ")";
        }
    }

    public static class InventoryItem {
        private String sku;
        private int quantity;
        private LocalDateTime updatedAt;

        @Generated
        public static InventoryItemBuilder builder() {
            return new InventoryItemBuilder();
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
        public LocalDateTime getUpdatedAt() {
            return this.updatedAt;
        }

        @Generated
        public InventoryItem(final String sku, final int quantity, final LocalDateTime updatedAt) {
            this.sku = sku;
            this.quantity = quantity;
            this.updatedAt = updatedAt;
        }

        @Generated
        public InventoryItem() {
        }

        @Generated
        public static class InventoryItemBuilder {
            @Generated
            private String sku;
            @Generated
            private int quantity;
            @Generated
            private LocalDateTime updatedAt;

            @Generated
            InventoryItemBuilder() {
            }

            @Generated
            public InventoryItemBuilder sku(final String sku) {
                this.sku = sku;
                return this;
            }

            @Generated
            public InventoryItemBuilder quantity(final int quantity) {
                this.quantity = quantity;
                return this;
            }

            @Generated
            public InventoryItemBuilder updatedAt(final LocalDateTime updatedAt) {
                this.updatedAt = updatedAt;
                return this;
            }

            @Generated
            public InventoryItem build() {
                return new InventoryItem(this.sku, this.quantity, this.updatedAt);
            }

            @Generated
            public String toString() {
                return "WarehouseInventoryResponse.InventoryItem.InventoryItemBuilder(sku=" + this.sku + ", quantity=" + this.quantity + ", updatedAt=" + this.updatedAt + ")";
            }
        }
    }
}
