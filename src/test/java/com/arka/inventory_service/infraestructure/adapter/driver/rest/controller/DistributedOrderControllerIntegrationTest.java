package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.DistributedOrderServicePort;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.domain.model.OrderDistribution;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.WarehouseRepository;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.DistributedItemDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.OrderDistributionBySourceWarehouseResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebFluxTest(DistributedOrderController.class)
class DistributedOrderControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private DistributedOrderServicePort distributedOrderServicePort;
    @MockBean
    private WarehouseRepository warehouseRepository;

    @Test
    void getDistributedOrdersBySourceWarehouse_returnsList() {
        UUID warehouseId = UUID.randomUUID();
        String warehouseCode = "WH1";
        OrderDistribution distribution = OrderDistribution.builder()
                .id(UUID.randomUUID())
                .sku("SKU1")
                .assignedQuantity(5)
                .status("PENDING")
                .sourceWarehouseId(warehouseId)
                .destinationWarehouseCode("DEST1")
                .assignedAt(LocalDateTime.now())
                .build();
        GroupedDistributionsByOrder group = new GroupedDistributionsByOrder("ORDER1", List.of(distribution));
        when(distributedOrderServicePort.getGroupedDistributionsByOrder(warehouseCode, "PENDING")).thenReturn(Flux.just(group));
        when(warehouseRepository.findById(warehouseId)).thenReturn(Mono.just(
                new com.arka.inventory_service.infraestructure.adapter.driven.db.entity.WarehouseEntity() {{
                    setId(warehouseId);
                    setCode(warehouseCode);
                }}
        ));

        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/distributed-orders").queryParam("sourceWarehouseCode", warehouseCode).queryParam("status", "PENDING").build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(OrderDistributionBySourceWarehouseResponseDto.class)
                .hasSize(1);
    }

    @Test
    void updateDistributionsStatus_returnsCount() {
        when(distributedOrderServicePort.updateDistributionsStatus(anyString(), anyString(), anyString())).thenReturn(Mono.just(2));
        webTestClient.put().uri(uriBuilder -> uriBuilder.path("/api/distributed-orders/status")
                        .queryParam("orderCode", "ORDER1")
                        .queryParam("sourceWarehouseCode", "WH1")
                        .queryParam("newStatus", "DELIVERED").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Integer.class)
                .isEqualTo(2);
    }
}
