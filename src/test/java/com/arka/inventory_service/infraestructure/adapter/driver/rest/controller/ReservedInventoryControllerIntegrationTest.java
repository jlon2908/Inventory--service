package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.ReservedInventoryServicePort;
import com.arka.inventory_service.domain.model.ReservedInventory;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.ReservedInventoryPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.ReservedInventoryResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebFluxTest(ReservedInventoryController.class)
class ReservedInventoryControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ReservedInventoryServicePort reservedInventoryServicePort;
    @MockBean
    private ReservedInventoryPersistenceMapper reservedInventoryPersistenceMapper;

    @Test
    void getByOrderCode_returnsList() {
        ReservedInventory reserved = new ReservedInventory(UUID.randomUUID(), "WH1", "ORDER1", "SKU1", 5, "WAITING_PICKUP", LocalDateTime.now());
        ReservedInventoryResponseDto responseDto = ReservedInventoryResponseDto.builder()
                .warehouseCode("WH1")
                .orderCode("ORDER1")
                .sku("SKU1")
                .reservedQuantity(5)
                .status("WAITING_PICKUP")
                .updatedAt(LocalDateTime.now())
                .build();
        when(reservedInventoryServicePort.getByOrderCode("ORDER1")).thenReturn(Flux.just(reserved));
        when(reservedInventoryPersistenceMapper.toResponse(reserved)).thenReturn(responseDto);

        webTestClient.get().uri("/api/reserved-inventory/order/ORDER1")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ReservedInventoryResponseDto.class)
                .hasSize(1);
    }
}

