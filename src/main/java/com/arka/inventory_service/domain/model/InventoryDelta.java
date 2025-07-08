//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import lombok.Generated;

public class InventoryDelta {
    private final String sku;
    private final int quantity;
    private final String warehouseCode;

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    @Generated
    public String getWarehouseCode() {
        return this.warehouseCode;
    }

    @Generated
    public InventoryDelta(final String sku, final int quantity, final String warehouseCode) {
        this.sku = sku;
        this.quantity = quantity;
        this.warehouseCode = warehouseCode;
    }
}
