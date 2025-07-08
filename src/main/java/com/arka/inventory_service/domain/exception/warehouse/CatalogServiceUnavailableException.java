package com.arka.inventory_service.domain.exception.warehouse;


public class CatalogServiceUnavailableException extends RuntimeException {
    public CatalogServiceUnavailableException(String details) {
        super(String.format("Catalog service is unavailable or unreachable: %s", details));
    }
}