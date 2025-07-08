package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.output.OrderDistributionPersistencePort;
import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByCodeException;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.domain.service.DistributionStatusValidationService;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class DistributedOrderServiceImplTest {

    @MockBean
    private OrderDistributionPersistencePort persistencePort;
    @MockBean
    private WarehouseCodeValidationService codeValidationService;
    @MockBean
    private DistributionStatusValidationService statusValidationService;
    @MockBean
    private WarehousePersistencePort warehousePersistencePort;

    private DistributedOrderServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new DistributedOrderServiceImpl(persistencePort, codeValidationService, statusValidationService, warehousePersistencePort);
    }

    @Test
    void getGroupedDistributionsByOrder_success() {
        when(codeValidationService.isValid("WH1")).thenReturn(true);
        when(statusValidationService.isValid("PENDING")).thenReturn(true);
        when(warehousePersistencePort.existsByCode("WH1")).thenReturn(Mono.just(true));
        GroupedDistributionsByOrder group = new GroupedDistributionsByOrder("ORDER1", Collections.emptyList());
        when(persistencePort.findGroupedByOrderCodeFromSource("WH1", "PENDING")).thenReturn(Flux.just(group));

        StepVerifier.create(service.getGroupedDistributionsByOrder("WH1", "PENDING"))
                .expectNext(group)
                .verifyComplete();
    }

    @Test
    void getGroupedDistributionsByOrder_warehouseNotFound() {
        when(codeValidationService.isValid("NOTFOUND")).thenReturn(true);
        when(statusValidationService.isValid("PENDING")).thenReturn(true);
        when(warehousePersistencePort.existsByCode("NOTFOUND")).thenReturn(Mono.just(false));

        StepVerifier.create(service.getGroupedDistributionsByOrder("NOTFOUND", "PENDING"))
                .expectError(WarehouseNotFoundByCodeException.class)
                .verify();
    }

    @Test
    void getGroupedDistributionsByOrder_invalidCode() {
        when(codeValidationService.isValid("bad_code")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.getGroupedDistributionsByOrder("bad_code", "PENDING"));
    }

    @Test
    void updateDistributionsStatus_success() {
        when(codeValidationService.isValid("WH1")).thenReturn(true);
        when(statusValidationService.isValid("DELIVERED")).thenReturn(true);
        when(warehousePersistencePort.existsByCode("WH1")).thenReturn(Mono.just(true));
        when(persistencePort.updateStatusByOrderCodeAndSourceWarehouse("ORDER1", "WH1", "DELIVERED")).thenReturn(Mono.just(2));

        StepVerifier.create(service.updateDistributionsStatus("ORDER1", "WH1", "DELIVERED"))
                .expectNext(2)
                .verifyComplete();
    }

    @Test
    void updateDistributionsStatus_invalidStatus() {
        when(codeValidationService.isValid("WH1")).thenReturn(true);
        when(statusValidationService.isValid("BAD")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.updateDistributionsStatus("ORDER1", "WH1", "BAD"));
    }

    @Test
    void updateDistributionsStatus_warehouseNotFound() {
        when(codeValidationService.isValid("WH1")).thenReturn(true);
        when(statusValidationService.isValid("DELIVERED")).thenReturn(true);
        when(warehousePersistencePort.existsByCode("WH1")).thenReturn(Mono.just(false));

        StepVerifier.create(service.updateDistributionsStatus("ORDER1", "WH1", "DELIVERED"))
                .expectError(WarehouseNotFoundByCodeException.class)
                .verify();
    }
}

