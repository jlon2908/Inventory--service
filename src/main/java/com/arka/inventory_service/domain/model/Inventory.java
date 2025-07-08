//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class Inventory {
    private UUID id;
    private String sku;
    private UUID warehouseId;
    private int quantity;
    private LocalDateTime updatedAt;

    @Generated
    public static InventoryBuilder builder() {
        return new InventoryBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public UUID getWarehouseId() {
        return this.warehouseId;
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
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setWarehouseId(final UUID warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Generated
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Generated
    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Generated
    public Inventory(final UUID id, final String sku, final UUID warehouseId, final int quantity, final LocalDateTime updatedAt) {
        this.id = id;
        this.sku = sku;
        this.warehouseId = warehouseId;
        this.quantity = quantity;
        this.updatedAt = updatedAt;
    }

    @Generated
    public Inventory() {
    }

    @Generated
    public static class InventoryBuilder {
        @Generated
        private UUID id;
        @Generated
        private String sku;
        @Generated
        private UUID warehouseId;
        @Generated
        private int quantity;
        @Generated
        private LocalDateTime updatedAt;

        @Generated
        InventoryBuilder() {
        }

        @Generated
        public InventoryBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public InventoryBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public InventoryBuilder warehouseId(final UUID warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        @Generated
        public InventoryBuilder quantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        @Generated
        public InventoryBuilder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Generated
        public Inventory build() {
            return new Inventory(this.id, this.sku, this.warehouseId, this.quantity, this.updatedAt);
        }

        @Generated
        public String toString() {
            return "Inventory.InventoryBuilder(id=" + this.id + ", sku=" + this.sku + ", warehouseId=" + this.warehouseId + ", quantity=" + this.quantity + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}
