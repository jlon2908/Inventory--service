//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.global;

import java.util.List;

public class ValidationException extends RuntimeException {
    private final List<ValidationErrorDetail> errors;

    public ValidationException(List<ValidationErrorDetail> errors) {
        super("Validation failed");
        this.errors = errors;
    }

    public List<ValidationErrorDetail> getErrors() {
        return this.errors;
    }
}
