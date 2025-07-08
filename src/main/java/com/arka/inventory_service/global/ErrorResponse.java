//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.global;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
    private String message;
    private String errorCode;
    private List<ValidationErrorDetail> validationErrors;

    @Generated
    ErrorResponse(final LocalDateTime timestamp, final int status, final String error, final String path, final String message, final String errorCode, final List<ValidationErrorDetail> validationErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;
        this.errorCode = errorCode;
        this.validationErrors = validationErrors;
    }

    @Generated
    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    @Generated
    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    @Generated
    public int getStatus() {
        return this.status;
    }

    @Generated
    public String getError() {
        return this.error;
    }

    @Generated
    public String getPath() {
        return this.path;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public String getErrorCode() {
        return this.errorCode;
    }

    @Generated
    public List<ValidationErrorDetail> getValidationErrors() {
        return this.validationErrors;
    }

    @Generated
    public static class ErrorResponseBuilder {
        @Generated
        private LocalDateTime timestamp;
        @Generated
        private int status;
        @Generated
        private String error;
        @Generated
        private String path;
        @Generated
        private String message;
        @Generated
        private String errorCode;
        @Generated
        private List<ValidationErrorDetail> validationErrors;

        @Generated
        ErrorResponseBuilder() {
        }

        @Generated
        public ErrorResponseBuilder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Generated
        public ErrorResponseBuilder status(final int status) {
            this.status = status;
            return this;
        }

        @Generated
        public ErrorResponseBuilder error(final String error) {
            this.error = error;
            return this;
        }

        @Generated
        public ErrorResponseBuilder path(final String path) {
            this.path = path;
            return this;
        }

        @Generated
        public ErrorResponseBuilder message(final String message) {
            this.message = message;
            return this;
        }

        @Generated
        public ErrorResponseBuilder errorCode(final String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        @Generated
        public ErrorResponseBuilder validationErrors(final List<ValidationErrorDetail> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        @Generated
        public ErrorResponse build() {
            return new ErrorResponse(this.timestamp, this.status, this.error, this.path, this.message, this.errorCode, this.validationErrors);
        }

        @Generated
        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(timestamp=" + this.timestamp + ", status=" + this.status + ", error=" + this.error + ", path=" + this.path + ", message=" + this.message + ", errorCode=" + this.errorCode + ", validationErrors=" + this.validationErrors + ")";
        }
    }
}
