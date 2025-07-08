package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseRequestDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest(WarehouseController.class)
class WarehouseControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private com.arka.inventory_service.application.ports.input.WarehouseServicePort warehouseServicePort;

    @Test
    void createWarehouse_returnsCreatedWarehouse() {
        WarehouseRequestDto request = WarehouseRequestDto.builder()
                .name("Bodega Central")
                .city("Bogota")
                .state("Cundinamarca")
                .country("Colombia")
                .code("CENTRAL")
                .build();
        Warehouse warehouse = Warehouse.builder()
                .id(UUID.randomUUID())
                .name("Bodega Central")
                .city("Bogota")
                .state("Cundinamarca")
                .country("Colombia")
                .code("CENTRAL")
                .build();
        when(warehouseServicePort.createWarehouse(any())).thenReturn(Mono.just(warehouse));

        webTestClient.post().uri("/api/warehouses")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody(WarehouseResponseDto.class)
                .value(resp -> resp.getCode().equals("CENTRAL"));
    }

    @Test
    void getAllWarehouses_returnsList() {
        Warehouse warehouse = Warehouse.builder().id(UUID.randomUUID()).code("CENTRAL").build();
        when(warehouseServicePort.getAllWarehouses()).thenReturn(Flux.just(warehouse));

        webTestClient.get().uri("/api/warehouses")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(WarehouseResponseDto.class)
                .hasSize(1);
    }

    @Test
    void deleteWarehouse_returnsNoContent() {
        when(warehouseServicePort.deleteWarehouseByCode("CENTRAL")).thenReturn(Mono.empty());
        webTestClient.delete().uri("/api/warehouses/CENTRAL")
                .exchange()
                .expectStatus().isNoContent();
    }
}

