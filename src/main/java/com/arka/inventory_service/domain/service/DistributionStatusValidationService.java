package com.arka.inventory_service.domain.service;

import com.arka.inventory_service.domain.util.enums.DistributionStatus;
import org.springframework.stereotype.Service;

@Service
public class DistributionStatusValidationService {
    public DistributionStatusValidationService() {
    }

    public boolean isValid(String status) {
        return status != null && DistributionStatus.isValid(status);
    }
}

