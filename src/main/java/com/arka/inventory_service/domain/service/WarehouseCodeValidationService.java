package com.arka.inventory_service.domain.service;

import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class WarehouseCodeValidationService {
    private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Z0-9]{3,10}$");

    public WarehouseCodeValidationService() {
    }

    public boolean isValid(String code) {
        return code != null && CODE_PATTERN.matcher(code).matches();
    }
}

