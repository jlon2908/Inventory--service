//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.reactive.catalog;

import com.arka.inventory_service.application.ports.input.SkuExistenceValidationService;
import com.arka.inventory_service.domain.exception.warehouse.CatalogServiceUnavailableException;
import lombok.Generated;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class SkuExistenceValidationServiceImpl implements SkuExistenceValidationService {
    private final WebClient catalogWebClient;

    public Mono<Boolean> skuExists(String sku) {
        return this.catalogWebClient.get().uri((uriBuilder) -> uriBuilder.path("/api/products/filter/sku").queryParam("sku", new Object[]{sku}).build(new Object[0])).retrieve().toBodilessEntity().map((response) -> {
            System.out.println("\ud83d\udd35 SKU verificado con status: " + response.getStatusCode());
            return true;
        }).onErrorResume(WebClientResponseException.NotFound.class, (ex) -> {
            System.out.println("\ud83d\udfe0 SKU no encontrado");
            return Mono.just(false);
        }).onErrorResume((ex) -> {
            System.out.println("\ud83d\udd34 Error contactando al catálogo: " + ex.getMessage());
            return Mono.error(new CatalogServiceUnavailableException(ex.getMessage()));
        });
    }

    @Generated
    public SkuExistenceValidationServiceImpl(final WebClient catalogWebClient) {
        this.catalogWebClient = catalogWebClient;
    }
}
