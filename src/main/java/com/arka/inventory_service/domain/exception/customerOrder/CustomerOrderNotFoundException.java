//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.customerOrder;

public class CustomerOrderNotFoundException extends RuntimeException {
    public CustomerOrderNotFoundException(String orderCode) {
        super(String.format("No customer order found with code: %s", orderCode));
    }
}
