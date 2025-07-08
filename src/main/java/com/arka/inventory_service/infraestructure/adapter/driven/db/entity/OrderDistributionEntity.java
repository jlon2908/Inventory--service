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

@Table("order_distribution")
public class OrderDistributionEntity {
    @Id
    private UUID id;
    @Column("customer_order_item_id")
    private UUID customerOrderItemId;
    @Column("source_warehouse_id")
    private UUID sourceWarehouseId;
    @Column("destination_warehouse_code")
    private String destinationWarehouseCode;
    private String sku;
    @Column("assigned_quantity")
    private int assignedQuantity;
    private String status;
    @Column("assigned_at")
    private LocalDateTime assignedAt;

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public UUID getCustomerOrderItemId() {
        return this.customerOrderItemId;
    }

    @Generated
    public UUID getSourceWarehouseId() {
        return this.sourceWarehouseId;
    }

    @Generated
    public String getDestinationWarehouseCode() {
        return this.destinationWarehouseCode;
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getAssignedQuantity() {
        return this.assignedQuantity;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public LocalDateTime getAssignedAt() {
        return this.assignedAt;
    }

    @Generated
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setCustomerOrderItemId(final UUID customerOrderItemId) {
        this.customerOrderItemId = customerOrderItemId;
    }

    @Generated
    public void setSourceWarehouseId(final UUID sourceWarehouseId) {
        this.sourceWarehouseId = sourceWarehouseId;
    }

    @Generated
    public void setDestinationWarehouseCode(final String destinationWarehouseCode) {
        this.destinationWarehouseCode = destinationWarehouseCode;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setAssignedQuantity(final int assignedQuantity) {
        this.assignedQuantity = assignedQuantity;
    }

    @Generated
    public void setStatus(final String status) {
        this.status = status;
    }

    @Generated
    public void setAssignedAt(final LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof OrderDistributionEntity)) {
            return false;
        } else {
            OrderDistributionEntity other = (OrderDistributionEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getAssignedQuantity() != other.getAssignedQuantity()) {
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

                Object this$customerOrderItemId = this.getCustomerOrderItemId();
                Object other$customerOrderItemId = other.getCustomerOrderItemId();
                if (this$customerOrderItemId == null) {
                    if (other$customerOrderItemId != null) {
                        return false;
                    }
                } else if (!this$customerOrderItemId.equals(other$customerOrderItemId)) {
                    return false;
                }

                Object this$sourceWarehouseId = this.getSourceWarehouseId();
                Object other$sourceWarehouseId = other.getSourceWarehouseId();
                if (this$sourceWarehouseId == null) {
                    if (other$sourceWarehouseId != null) {
                        return false;
                    }
                } else if (!this$sourceWarehouseId.equals(other$sourceWarehouseId)) {
                    return false;
                }

                Object this$destinationWarehouseCode = this.getDestinationWarehouseCode();
                Object other$destinationWarehouseCode = other.getDestinationWarehouseCode();
                if (this$destinationWarehouseCode == null) {
                    if (other$destinationWarehouseCode != null) {
                        return false;
                    }
                } else if (!this$destinationWarehouseCode.equals(other$destinationWarehouseCode)) {
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

                Object this$assignedAt = this.getAssignedAt();
                Object other$assignedAt = other.getAssignedAt();
                if (this$assignedAt == null) {
                    if (other$assignedAt != null) {
                        return false;
                    }
                } else if (!this$assignedAt.equals(other$assignedAt)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof OrderDistributionEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getAssignedQuantity();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $customerOrderItemId = this.getCustomerOrderItemId();
        result = result * 59 + ($customerOrderItemId == null ? 43 : $customerOrderItemId.hashCode());
        Object $sourceWarehouseId = this.getSourceWarehouseId();
        result = result * 59 + ($sourceWarehouseId == null ? 43 : $sourceWarehouseId.hashCode());
        Object $destinationWarehouseCode = this.getDestinationWarehouseCode();
        result = result * 59 + ($destinationWarehouseCode == null ? 43 : $destinationWarehouseCode.hashCode());
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        Object $assignedAt = this.getAssignedAt();
        result = result * 59 + ($assignedAt == null ? 43 : $assignedAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "OrderDistributionEntity(id=" + var10000 + ", customerOrderItemId=" + this.getCustomerOrderItemId() + ", sourceWarehouseId=" + this.getSourceWarehouseId() + ", destinationWarehouseCode=" + this.getDestinationWarehouseCode() + ", sku=" + this.getSku() + ", assignedQuantity=" + this.getAssignedQuantity() + ", status=" + this.getStatus() + ", assignedAt=" + this.getAssignedAt() + ")";
    }

    @Generated
    public OrderDistributionEntity() {
    }

    @Generated
    public OrderDistributionEntity(final UUID id, final UUID customerOrderItemId, final UUID sourceWarehouseId, final String destinationWarehouseCode, final String sku, final int assignedQuantity, final String status, final LocalDateTime assignedAt) {
        this.id = id;
        this.customerOrderItemId = customerOrderItemId;
        this.sourceWarehouseId = sourceWarehouseId;
        this.destinationWarehouseCode = destinationWarehouseCode;
        this.sku = sku;
        this.assignedQuantity = assignedQuantity;
        this.status = status;
        this.assignedAt = assignedAt;
    }
}
