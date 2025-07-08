//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.warehouse;

import java.util.UUID;

public class WarehouseNotFoundByIdException extends RuntimeException {
    public WarehouseNotFoundByIdException(UUID id) {
        super(String.format("No warehouse found with ID: %s", id));
    }
}
