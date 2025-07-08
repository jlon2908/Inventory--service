package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.output.CustomerOrderPersistencePort;
import com.arka.inventory_service.domain.exception.customerOrder.CustomerOrderNotFoundException;
import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.domain.service.CustomerOrderStatusValidationService;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationErrorDetail;
import com.arka.inventory_service.global.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerOrderServiceImplTest {

    @MockBean
    private CustomerOrderPersistencePort persistencePort;
    @MockBean
    private CustomerOrderStatusValidationService statusValidationService;
    @MockBean
    private WarehouseCodeValidationService warehouseCodeValidationService;

    private CustomerOrderServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new CustomerOrderServiceImpl(persistencePort, statusValidationService, warehouseCodeValidationService);
    }

    @Test
    void updateStatus_success() {
        when(statusValidationService.isValid("DELIVERED")).thenReturn(true);
        CustomerOrder order = new CustomerOrder();
        when(persistencePort.findByOrderCode("ORDER1")).thenReturn(Mono.just(order));
        when(persistencePort.update(any(CustomerOrder.class))).thenReturn(Mono.empty());

        StepVerifier.create(service.updateStatus("ORDER1", "DELIVERED"))
                .verifyComplete();
    }

    @Test
    void updateStatus_invalidStatus() {
        when(statusValidationService.isValid("BAD")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.updateStatus("ORDER1", "BAD"));
    }

    @Test
    void updateStatus_orderNotFound() {
        when(statusValidationService.isValid("DELIVERED")).thenReturn(true);
        when(persistencePort.findByOrderCode("NOTFOUND")).thenReturn(Mono.empty());

        StepVerifier.create(service.updateStatus("NOTFOUND", "DELIVERED"))
                .expectError(CustomerOrderNotFoundException.class)
                .verify();
    }

    @Test
    void filterOrders_success() {
        when(statusValidationService.isValid("ASSIGNED")).thenReturn(true);
        when(warehouseCodeValidationService.isValid("WH1")).thenReturn(true);
        // Mock para evitar NullPointerException
        when(persistencePort.findByOrderCode("ORDER1")).thenReturn(Mono.just(new CustomerOrder()));
        when(persistencePort.filterOrders(any(), any(), any(), any(), any())).thenReturn(Flux.empty());

        StepVerifier.create(service.filterOrders("ORDER1", "WH1", "ASSIGNED", LocalDateTime.now().minusDays(1), LocalDateTime.now()))
                .verifyComplete();
    }

    @Test
    void filterOrders_invalidStatus() {
        when(statusValidationService.isValid("BAD")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.filterOrders(null, null, "BAD", null, null));
    }

    @Test
    void filterOrders_invalidWarehouseCode() {
        when(statusValidationService.isValid(null)).thenReturn(true);
        when(warehouseCodeValidationService.isValid("bad_code")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.filterOrders(null, "bad_code", null, null, null));
    }

    @Test
    void filterOrders_invalidDateRange() {
        when(statusValidationService.isValid(null)).thenReturn(true);
        when(warehouseCodeValidationService.isValid(null)).thenReturn(true);
        LocalDateTime from = LocalDateTime.now();
        LocalDateTime to = from.minusDays(1);
        assertThrows(ValidationException.class, () -> service.filterOrders(null, null, null, from, to));
    }

    @Test
    void cancelOrderByCustomer_success() {
        UUID customerId = UUID.randomUUID();
        CustomerOrder order = new CustomerOrder();
        order.setUserId(customerId);
        order.setStatus("ASSIGNED");
        when(persistencePort.findByOrderCode("ORDER1")).thenReturn(Mono.just(order));
        when(persistencePort.update(any(CustomerOrder.class))).thenReturn(Mono.empty());

        StepVerifier.create(service.cancelOrderByCustomer("ORDER1", customerId))
                .verifyComplete();
    }

    @Test
    void cancelOrderByCustomer_notFound() {
        UUID customerId = UUID.randomUUID();
        when(persistencePort.findByOrderCode("NOTFOUND")).thenReturn(Mono.empty());

        StepVerifier.create(service.cancelOrderByCustomer("NOTFOUND", customerId))
                .expectError(CustomerOrderNotFoundException.class)
                .verify();
    }

    @Test
    void cancelOrderByCustomer_noPermission() {
        UUID customerId = UUID.randomUUID();
        CustomerOrder order = new CustomerOrder();
        order.setUserId(UUID.randomUUID());
        order.setStatus("ASSIGNED");
        when(persistencePort.findByOrderCode("ORDER1")).thenReturn(Mono.just(order));

        StepVerifier.create(service.cancelOrderByCustomer("ORDER1", customerId))
                .expectError(ValidationException.class)
                .verify();
    }

    @Test
    void cancelOrderByCustomer_alreadyCancelled() {
        UUID customerId = UUID.randomUUID();
        CustomerOrder order = new CustomerOrder();
        order.setUserId(customerId);
        order.setStatus("CANCELLED");
        when(persistencePort.findByOrderCode("ORDER1")).thenReturn(Mono.just(order));

        StepVerifier.create(service.cancelOrderByCustomer("ORDER1", customerId))
                .verifyComplete();
    }
}
