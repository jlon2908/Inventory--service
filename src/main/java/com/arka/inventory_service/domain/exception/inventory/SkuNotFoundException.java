package com.arka.inventory_service.domain.exception.inventory;


public class SkuNotFoundException extends RuntimeException {
    public SkuNotFoundException(String sku) {
        super(String.format("SKU not found: %s", sku));
    }
}