package com.arka.inventory_service.domain.util;

public class ExceptionMessages {
    public static final String SKU_NOT_FOUND = "SKU not found: %s";
    public static final String GEOLOCATION_NOT_FOUND = "No se pudo encontrar la ubicación para: %s";
    public static final String DUPLICATE_WAREHOUSE_CODE = "Ya existe una bodega con elcódigo:%s";
    public static final String INVALID_CODE_FORMAT = "The warehouse code format is invalid. Use 3-10 uppercase letters or digits.";
    public static final String WAREHOUSE_NOT_FOUND_BY_CODE = "No warehouse found with code: %s";
    public static final String NULL_WAREHOUSE_CODE = "Warehouse code must not be null.";
    public static final String INVALID_DISTRIBUTION_STATUS = "Invalid distribution status.";
    public static final String CATALOG_SERVICE_UNAVAILABLE = "Catalog service is unavailable or unreachable: %s";
    public static final String WAREHOUSE_LIST_EMPTY = "No warehouses found in the system.";
    public static final String WAREHOUSE_NOT_FOUND_BY_ID = "No warehouse found with ID: %s";
    public static final String CUSTOMER_ORDER_NOT_FOUND = "No customer order found with code: %s";
    public static final String INVALID_ORDER_STATUS = "Invalid status. Must be one of: ASSIGNED, READY_FOR_DELIVERY, DELIVERED, CANCELLED.";
    public static final String ORDER_CODE_REQUIRED = "Order code is required.";

    private ExceptionMessages() {
    }
}
