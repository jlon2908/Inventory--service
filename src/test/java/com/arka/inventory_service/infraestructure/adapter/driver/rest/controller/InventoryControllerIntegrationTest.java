package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.InventoryServicePort;
import com.arka.inventory_service.application.ports.input.WarehouseServicePort;
import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.IncreaseStockRequestDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.InventoryStockResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(InventoryController.class)
class InventoryControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private InventoryServicePort inventoryServicePort;
    @MockBean
    private WarehouseServicePort warehouseServicePort;

    @Test
    void increaseStockManually_returnsNoContent() {
        IncreaseStockRequestDto request = IncreaseStockRequestDto.builder()
                .sku("SKU1")
                .quantity(10)
                .warehouseId(UUID.randomUUID())
                .build();
        when(inventoryServicePort.increaseStockManually(any(), any(Integer.class), any(UUID.class))).thenReturn(Mono.empty());

        webTestClient.post().uri("/api/inventory/increase")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void getStockBySkuAcrossWarehouses_returnsList() {
        String sku = "SKU1";
        UUID warehouseId = UUID.randomUUID();
        Inventory inventory = Inventory.builder()
                .sku(sku)
                .warehouseId(warehouseId)
                .quantity(20)
                .updatedAt(LocalDateTime.now())
                .build();
        Warehouse warehouse = Warehouse.builder().id(warehouseId).code("WH1").build();
        when(inventoryServicePort.getStockBySkuAcrossWarehouses(sku)).thenReturn(Flux.just(inventory));
        when(warehouseServicePort.findById(warehouseId)).thenReturn(Mono.just(warehouse));

        webTestClient.get().uri("/api/inventory/{sku}/stock", sku)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(InventoryStockResponseDto.class)
                .hasSize(1);
    }

    @Test
    void filterByMinQuantity_returnsList() {
        Inventory inventory = Inventory.builder().sku("SKU1").quantity(15).build();
        when(inventoryServicePort.filterByMinQuantity(10)).thenReturn(Flux.just(inventory));

        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/inventory/filter").queryParam("minQuantity", 10).build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Inventory.class)
                .hasSize(1);
    }
}

