//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.warehouse;

public class WarehouseListEmptyException extends RuntimeException {
    public WarehouseListEmptyException() {
        super(String.format("No warehouses found in the system."));
    }
}
