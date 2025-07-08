package com.arka.inventory_service.application.ports.input;

import reactor.core.publisher.Mono;

public interface SkuExistenceValidationService {
    Mono<Boolean> skuExists(String sku);
}
