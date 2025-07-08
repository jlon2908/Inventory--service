package com.arka.inventory_service.domain.service;

import com.arka.inventory_service.domain.util.enums.CustomerOrderStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderStatusValidationService {
    public CustomerOrderStatusValidationService() {
    }

    public boolean isValid(String status) {
        return status != null && CustomerOrderStatus.isValid(status);
    }
}