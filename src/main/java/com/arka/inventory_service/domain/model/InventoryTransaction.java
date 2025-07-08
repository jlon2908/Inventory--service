//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class InventoryTransaction {
    private UUID id;
    private String sku;
    private UUID warehouseId;
    private int quantityChange;
    private String type;
    private LocalDateTime occurredAt;

    @Generated
    public static InventoryTransactionBuilder builder() {
        return new InventoryTransactionBuilder();
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
    public int getQuantityChange() {
        return this.quantityChange;
    }

    @Generated
    public String getType() {
        return this.type;
    }

    @Generated
    public LocalDateTime getOccurredAt() {
        return this.occurredAt;
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
    public void setQuantityChange(final int quantityChange) {
        this.quantityChange = quantityChange;
    }

    @Generated
    public void setType(final String type) {
        this.type = type;
    }

    @Generated
    public void setOccurredAt(final LocalDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    @Generated
    public InventoryTransaction(final UUID id, final String sku, final UUID warehouseId, final int quantityChange, final String type, final LocalDateTime occurredAt) {
        this.id = id;
        this.sku = sku;
        this.warehouseId = warehouseId;
        this.quantityChange = quantityChange;
        this.type = type;
        this.occurredAt = occurredAt;
    }

    @Generated
    public InventoryTransaction() {
    }

    @Generated
    public static class InventoryTransactionBuilder {
        @Generated
        private UUID id;
        @Generated
        private String sku;
        @Generated
        private UUID warehouseId;
        @Generated
        private int quantityChange;
        @Generated
        private String type;
        @Generated
        private LocalDateTime occurredAt;

        @Generated
        InventoryTransactionBuilder() {
        }

        @Generated
        public InventoryTransactionBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public InventoryTransactionBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public InventoryTransactionBuilder warehouseId(final UUID warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        @Generated
        public InventoryTransactionBuilder quantityChange(final int quantityChange) {
            this.quantityChange = quantityChange;
            return this;
        }

        @Generated
        public InventoryTransactionBuilder type(final String type) {
            this.type = type;
            return this;
        }

        @Generated
        public InventoryTransactionBuilder occurredAt(final LocalDateTime occurredAt) {
            this.occurredAt = occurredAt;
            return this;
        }

        @Generated
        public InventoryTransaction build() {
            return new InventoryTransaction(this.id, this.sku, this.warehouseId, this.quantityChange, this.type, this.occurredAt);
        }

        @Generated
        public String toString() {
            return "InventoryTransaction.InventoryTransactionBuilder(id=" + this.id + ", sku=" + this.sku + ", warehouseId=" + this.warehouseId + ", quantityChange=" + this.quantityChange + ", type=" + this.type + ", occurredAt=" + this.occurredAt + ")";
        }
    }
}
