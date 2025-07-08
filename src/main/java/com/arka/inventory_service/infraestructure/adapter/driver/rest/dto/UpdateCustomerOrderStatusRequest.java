//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Generated;

public class UpdateCustomerOrderStatusRequest {
    private @NotBlank(
            message = "Status must not be blank"
    ) String status;

    @Generated
    public static UpdateCustomerOrderStatusRequestBuilder builder() {
        return new UpdateCustomerOrderStatusRequestBuilder();
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public UpdateCustomerOrderStatusRequest(final String status) {
        this.status = status;
    }

    @Generated
    public UpdateCustomerOrderStatusRequest() {
    }

    @Generated
    public static class UpdateCustomerOrderStatusRequestBuilder {
        @Generated
        private String status;

        @Generated
        UpdateCustomerOrderStatusRequestBuilder() {
        }

        @Generated
        public UpdateCustomerOrderStatusRequestBuilder status(final String status) {
            this.status = status;
            return this;
        }

        @Generated
        public UpdateCustomerOrderStatusRequest build() {
            return new UpdateCustomerOrderStatusRequest(this.status);
        }

        @Generated
        public String toString() {
            return "UpdateCustomerOrderStatusRequest.UpdateCustomerOrderStatusRequestBuilder(status=" + this.status + ")";
        }
    }
}
