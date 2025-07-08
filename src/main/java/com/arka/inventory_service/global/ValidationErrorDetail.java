//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.global;

import lombok.Generated;

public class ValidationErrorDetail {
    private String field;
    private String message;

    @Generated
    public String getField() {
        return this.field;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public ValidationErrorDetail(final String field, final String message) {
        this.field = field;
        this.message = message;
    }
}
