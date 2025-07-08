package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.CustomerOrderInServicePort;
import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.CustomerOrderItemRepository;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.CustomerOrderItemResponse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.CustomerOrderResponse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.UpdateCustomerOrderStatusRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@WebFluxTest(CustomerOrderController.class)
class CustomerOrderControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CustomerOrderInServicePort customerOrderService;
    @MockBean
    private CustomerOrderItemRepository customerOrderItemRepository;

    @Test
    void updateOrderStatus_returnsNoContent() {
        UpdateCustomerOrderStatusRequest request = UpdateCustomerOrderStatusRequest.builder()
                .status("DELIVERED")
                .build();
        when(customerOrderService.updateStatus(anyString(), anyString())).thenReturn(Mono.empty());

        webTestClient.patch().uri("/api/customer-orders/ORDER1/status")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    void filterOrders_returnsList() {
        UUID orderId = UUID.randomUUID();
        CustomerOrder order = CustomerOrder.builder()
                .id(orderId)
                .orderCode("ORDER1")
                .status("ASSIGNED")
                .warehousePickupCode("WH1")
                .createdAt(LocalDateTime.now())
                .build();
        // Usar CustomerOrderItemEntity en el mock
        com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderItemEntity itemEntity = new com.arka.inventory_service.infraestructure.adapter.driven.db.entity.CustomerOrderItemEntity();
        itemEntity.setSku("SKU1");
        itemEntity.setQuantity(2);
        when(customerOrderService.filterOrders(any(), any(), any(), any(), any())).thenReturn(Flux.just(order));
        when(customerOrderItemRepository.findByCustomerOrderId(orderId)).thenReturn(Flux.just(itemEntity));

        webTestClient.get().uri(uriBuilder -> uriBuilder.path("/api/customer-orders/filter").queryParam("orderCode", "ORDER1").build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(CustomerOrderResponse.class)
                .hasSize(1);
    }

    @Test
    void cancelOrderByCustomer_returnsNoContent() {
        when(customerOrderService.cancelOrderByCustomer(anyString(), any(UUID.class))).thenReturn(Mono.empty());
        String clientUuid = UUID.randomUUID().toString();
        webTestClient.patch().uri("/api/customer-orders/ORDER1/cancel")
                .header("X-Client-UUID", clientUuid)
                .exchange()
                .expectStatus().isNoContent();
    }
}
