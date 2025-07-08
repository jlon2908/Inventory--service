//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class ReservedInventory {
    private UUID id;
    private String warehouseCode;
    private String orderCode;
    private String sku;
    private int reservedQuantity;
    private String status;
    private LocalDateTime updatedAt;

    @Generated
    public static ReservedInventoryBuilder builder() {
        return new ReservedInventoryBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getReservedQuantity() {
        return this.reservedQuantity;
    }

    @Generated
    public String getStatus() {
        return this.status;
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
    public void setWarehouseCode(final String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    @Generated
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setReservedQuantity(final int reservedQuantity) {
        this.reservedQuantity = reservedQuantity;
    }

    @Generated
    public void setStatus(final String status) {
        this.status = status;
    }

    @Generated
    public void setUpdatedAt(final LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Generated
    public ReservedInventory(final UUID id, final String warehouseCode, final String orderCode, final String sku, final int reservedQuantity, final String status, final LocalDateTime updatedAt) {
        this.id = id;
        this.warehouseCode = warehouseCode;
        this.orderCode = orderCode;
        this.sku = sku;
        this.reservedQuantity = reservedQuantity;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    @Generated
    public ReservedInventory() {
    }

    @Generated
    public static class ReservedInventoryBuilder {
        @Generated
        private UUID id;
        @Generated
        private String warehouseCode;
        @Generated
        private String orderCode;
        @Generated
        private String sku;
        @Generated
        private int reservedQuantity;
        @Generated
        private String status;
        @Generated
        private LocalDateTime updatedAt;

        @Generated
        ReservedInventoryBuilder() {
        }

        @Generated
        public ReservedInventoryBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder warehouseCode(final String warehouseCode) {
            this.warehouseCode = warehouseCode;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder orderCode(final String orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder reservedQuantity(final int reservedQuantity) {
            this.reservedQuantity = reservedQuantity;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public ReservedInventoryBuilder updatedAt(final LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        @Generated
        public ReservedInventory build() {
            return new ReservedInventory(this.id, this.warehouseCode, this.orderCode, this.sku, this.reservedQuantity, this.status, this.updatedAt);
        }

        @Generated
        public String toString() {
            return "ReservedInventory.ReservedInventoryBuilder(id=" + this.id + ", warehouseCode=" + this.warehouseCode + ", orderCode=" + this.orderCode + ", sku=" + this.sku + ", reservedQuantity=" + this.reservedQuantity + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}
