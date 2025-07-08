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

@Table("inventory_transaction")
public class InventoryTransactionEntity {
    @Id
    private UUID id;
    private String sku;
    private UUID warehouseId;
    private int quantityChange;
    private String type;
    private LocalDateTime occurredAt;

    @Generated
    public InventoryTransactionEntity() {
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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof InventoryTransactionEntity)) {
            return false;
        } else {
            InventoryTransactionEntity other = (InventoryTransactionEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getQuantityChange() != other.getQuantityChange()) {
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

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                Object this$occurredAt = this.getOccurredAt();
                Object other$occurredAt = other.getOccurredAt();
                if (this$occurredAt == null) {
                    if (other$occurredAt != null) {
                        return false;
                    }
                } else if (!this$occurredAt.equals(other$occurredAt)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof InventoryTransactionEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantityChange();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $warehouseId = this.getWarehouseId();
        result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        Object $occurredAt = this.getOccurredAt();
        result = result * 59 + ($occurredAt == null ? 43 : $occurredAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "InventoryTransactionEntity(id=" + var10000 + ", sku=" + this.getSku() + ", warehouseId=" + this.getWarehouseId() + ", quantityChange=" + this.getQuantityChange() + ", type=" + this.getType() + ", occurredAt=" + this.getOccurredAt() + ")";
    }
}
