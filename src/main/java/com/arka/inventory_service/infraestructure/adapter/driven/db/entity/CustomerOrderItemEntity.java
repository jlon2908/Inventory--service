//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.entity;

import java.util.UUID;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer_order_item")
public class CustomerOrderItemEntity {
    @Id
    private UUID id;
    @Column("customer_order_id")
    private UUID customerOrderId;
    private String sku;
    private int quantity;

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public UUID getCustomerOrderId() {
        return this.customerOrderId;
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
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setCustomerOrderId(final UUID customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Generated
    public void setSku(final String sku) {
        this.sku = sku;
    }

    @Generated
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomerOrderItemEntity)) {
            return false;
        } else {
            CustomerOrderItemEntity other = (CustomerOrderItemEntity)o;
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

                Object this$customerOrderId = this.getCustomerOrderId();
                Object other$customerOrderId = other.getCustomerOrderId();
                if (this$customerOrderId == null) {
                    if (other$customerOrderId != null) {
                        return false;
                    }
                } else if (!this$customerOrderId.equals(other$customerOrderId)) {
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

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof CustomerOrderItemEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getQuantity();
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $customerOrderId = this.getCustomerOrderId();
        result = result * 59 + ($customerOrderId == null ? 43 : $customerOrderId.hashCode());
        Object $sku = this.getSku();
        result = result * 59 + ($sku == null ? 43 : $sku.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "CustomerOrderItemEntity(id=" + var10000 + ", customerOrderId=" + this.getCustomerOrderId() + ", sku=" + this.getSku() + ", quantity=" + this.getQuantity() + ")";
    }

    @Generated
    public CustomerOrderItemEntity() {
    }

    @Generated
    public CustomerOrderItemEntity(final UUID id, final UUID customerOrderId, final String sku, final int quantity) {
        this.id = id;
        this.customerOrderId = customerOrderId;
        this.sku = sku;
        this.quantity = quantity;
    }
}
