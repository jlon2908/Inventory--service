//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.warehouse;

public class DuplicateWarehouseCodeException extends RuntimeException {
    public DuplicateWarehouseCodeException(String code) {
        super(String.format("Ya existe una bodega con elcódigo:%s", code));
    }
}
