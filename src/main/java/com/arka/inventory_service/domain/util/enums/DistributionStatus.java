package com.arka.inventory_service.domain.util.enums;


public class DistributionStatus {
    public static final String PENDING = "PENDING";
    public static final String IN_TRANSIT = "IN_TRANSIT";
    public static final String RECEIVED = "RECEIVED";
    public static final String READY_FOR_PICKUP = "READY_FOR_PICKUP";

    private DistributionStatus() {
    }

    public static boolean isValid(String status) {
        return "PENDING".equals(status) || "IN_TRANSIT".equals(status) || "RECEIVED".equals(status) || "READY_FOR_PICKUP".equals(status);
    }
}

