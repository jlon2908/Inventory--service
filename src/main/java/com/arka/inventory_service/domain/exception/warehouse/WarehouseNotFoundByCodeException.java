//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.warehouse;

public class WarehouseNotFoundByCodeException extends RuntimeException {
    public WarehouseNotFoundByCodeException(String code) {
        super(String.format("No warehouse found with code: %s", code));
    }
}
