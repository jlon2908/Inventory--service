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

@Table("customer_order")
public class CustomerOrderEntity {
    @Id
    private UUID id;
    @Column("order_code")
    private String orderCode;
    @Column("user_id")
    private UUID userId;
    @Column("warehouse_pickup_code")
    private String warehousePickupCode;
    @Column("created_at")
    private LocalDateTime createdAt;
    private String status;

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getOrderCode() {
        return this.orderCode;
    }

    @Generated
    public UUID getUserId() {
        return this.userId;
    }

    @Generated
    public String getWarehousePickupCode() {
        return this.warehousePickupCode;
    }

    @Generated
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    @Generated
    public void setUserId(final UUID userId) {
        this.userId = userId;
    }

    @Generated
    public void setWarehousePickupCode(final String warehousePickupCode) {
        this.warehousePickupCode = warehousePickupCode;
    }

    @Generated
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Generated
    public void setStatus(final String status) {
        this.status = status;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomerOrderEntity)) {
            return false;
        } else {
            CustomerOrderEntity other = (CustomerOrderEntity)o;
            if (!other.canEqual(this)) {
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

                Object this$orderCode = this.getOrderCode();
                Object other$orderCode = other.getOrderCode();
                if (this$orderCode == null) {
                    if (other$orderCode != null) {
                        return false;
                    }
                } else if (!this$orderCode.equals(other$orderCode)) {
                    return false;
                }

                Object this$userId = this.getUserId();
                Object other$userId = other.getUserId();
                if (this$userId == null) {
                    if (other$userId != null) {
                        return false;
                    }
                } else if (!this$userId.equals(other$userId)) {
                    return false;
                }

                Object this$warehousePickupCode = this.getWarehousePickupCode();
                Object other$warehousePickupCode = other.getWarehousePickupCode();
                if (this$warehousePickupCode == null) {
                    if (other$warehousePickupCode != null) {
                        return false;
                    }
                } else if (!this$warehousePickupCode.equals(other$warehousePickupCode)) {
                    return false;
                }

                Object this$createdAt = this.getCreatedAt();
                Object other$createdAt = other.getCreatedAt();
                if (this$createdAt == null) {
                    if (other$createdAt != null) {
                        return false;
                    }
                } else if (!this$createdAt.equals(other$createdAt)) {
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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof CustomerOrderEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $orderCode = this.getOrderCode();
        result = result * 59 + ($orderCode == null ? 43 : $orderCode.hashCode());
        Object $userId = this.getUserId();
        result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
        Object $warehousePickupCode = this.getWarehousePickupCode();
        result = result * 59 + ($warehousePickupCode == null ? 43 : $warehousePickupCode.hashCode());
        Object $createdAt = this.getCreatedAt();
        result = result * 59 + ($createdAt == null ? 43 : $createdAt.hashCode());
        Object $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "CustomerOrderEntity(id=" + var10000 + ", orderCode=" + this.getOrderCode() + ", userId=" + this.getUserId() + ", warehousePickupCode=" + this.getWarehousePickupCode() + ", createdAt=" + this.getCreatedAt() + ", status=" + this.getStatus() + ")";
    }

    @Generated
    public CustomerOrderEntity() {
    }

    @Generated
    public CustomerOrderEntity(final UUID id, final String orderCode, final UUID userId, final String warehousePickupCode, final LocalDateTime createdAt, final String status) {
        this.id = id;
        this.orderCode = orderCode;
        this.userId = userId;
        this.warehousePickupCode = warehousePickupCode;
        this.createdAt = createdAt;
        this.status = status;
    }
}
