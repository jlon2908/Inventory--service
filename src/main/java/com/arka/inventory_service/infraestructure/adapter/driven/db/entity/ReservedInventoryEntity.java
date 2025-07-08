//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("reserved_inventory")
public class ReservedInventoryEntity {
    @Id
    private UUID id;
    @Column("warehouse_code")
    private String warehouseCode;
    @Column("order_code")
    private String orderCode;
    private String sku;
    @Column("reserved_quantity")
    private int reservedQuantity;
    private String status;
    @Column("updated_at")
    private LocalDateTime updatedAt;

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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReservedInventoryEntity)) {
            return false;
        } else {
            ReservedInventoryEntity other = (ReservedInventoryEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getReservedQuantity() != other.getReservedQuantity()) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$warehouseCode = this.getWarehouseCode();
                Object other$warehouseCode = other.getWarehouseCode();
                if (this$warehouseCode == null) {
                    if (other$warehouseCode != null) {
                        return false;
                    }
                } else if (!this$warehouseCode.equals(other$warehouseCode)) {
                    return false;
                }

                Object this$orderCode = this.getOrderCode();
                Object other$orderCode = other.getOrderCode();
                if (this$orderCode == null) {
                    if (other$orderCode != null) {
                        return false;
                    }
                } else if (!this$orderCode.equals(other$orderCode)) {
                    return false;
                }

                Object this$sku = this.getSku();
                Object other$sku = other.getSku();
                if (this$sku == null) {
                    if (other$sku != null) {
                        return false;
                    }
                } else if (!this$sku.equals(other$sku)) {
                    return false;
                }

                Object this$status = this.getStatus();
                Object other$status = other.getStatus();
                if (this$status == null) {
                    if (other$status != null) {
                        return false;
                    }
                } else if (!this$status.equals(other$status)) {
                    return false;
                }

                Object this$updatedAt = this.getUpdatedAt();
                Object other$updatedAt = other.getUpdatedAt();
                if (this$updatedAt == null) {
                    if (other$updatedAt != null) {
                        return false;
                    }
                } else if (!this$updatedAt.equals(other$updatedAt)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof ReservedInventoryEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getReservedQuantity();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $warehouseCode = this.getWarehouseCode();
        result = result * 59 + ($warehouseCode == null ? 43 : $warehouseCode.hashCode());
        Object $orderCode = this.getOrderCode();
        result = result * 59 + ($orderCode == null ? 43 : $orderCode.hashCode());
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $updatedAt = this.getUpdatedAt();
        result = result * 59 + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "ReservedInventoryEntity(id=" + var10000 + ", warehouseCode=" + this.getWarehouseCode() + ", orderCode=" + this.getOrderCode() + ", sku=" + this.getSku() + ", reservedQuantity=" + this.getReservedQuantity() + ", status=" + this.getStatus() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }

    @Generated
    public ReservedInventoryEntity() {
    }

    @Generated
    public ReservedInventoryEntity(final UUID id, final String warehouseCode, final String orderCode, final String sku, final int reservedQuantity, final String status, final LocalDateTime updatedAt) {
        this.id = id;
        this.warehouseCode = warehouseCode;
        this.orderCode = orderCode;
        this.sku = sku;
        this.reservedQuantity = reservedQuantity;
        this.status = status;
        this.updatedAt = updatedAt;
    }
}
