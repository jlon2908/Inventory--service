//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("inventory")
public class InventoryEntity {
    @Id
    private UUID id;
    private String sku;
    private UUID warehouseId;
    private int quantity;
    private LocalDateTime updatedAt;

    @Generated
    public InventoryEntity() {
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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof InventoryEntity)) {
            return false;
        } else {
            InventoryEntity other = (InventoryEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getQuantity() != other.getQuantity()) {
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

                Object this$sku = this.getSku();
                Object other$sku = other.getSku();
                if (this$sku == null) {
                    if (other$sku != null) {
                        return false;
                    }
                } else if (!this$sku.equals(other$sku)) {
                    return false;
                }

                Object this$warehouseId = this.getWarehouseId();
                Object other$warehouseId = other.getWarehouseId();
                if (this$warehouseId == null) {
                    if (other$warehouseId != null) {
                        return false;
                    }
                } else if (!this$warehouseId.equals(other$warehouseId)) {
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
        return other instanceof InventoryEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantity();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $warehouseId = this.getWarehouseId();
        result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        Object $updatedAt = this.getUpdatedAt();
        result = result * 59 + ($updatedAt == null ? 43 : $updatedAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "InventoryEntity(id=" + var10000 + ", sku=" + this.getSku() + ", warehouseId=" + this.getWarehouseId() + ", quantity=" + this.getQuantity() + ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
