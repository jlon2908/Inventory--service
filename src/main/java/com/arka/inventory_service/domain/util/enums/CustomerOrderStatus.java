package com.arka.inventory_service.domain.util.enums;

public class CustomerOrderStatus {
    public static final String ASSIGNED = "ASSIGNED";
    public static final String READY_FOR_DELIVERY = "READY_FOR_DELIVERY";
    public static final String DELIVERED = "DELIVERED";
    public static final String CANCELLED = "CANCELLED";

    private CustomerOrderStatus() {
    }

    public static boolean isValid(String status) {
        return "ASSIGNED".equals(status) || "READY_FOR_DELIVERY".equals(status) || "DELIVERED".equals(status) || "CANCELLED".equals(status);
    }
}

