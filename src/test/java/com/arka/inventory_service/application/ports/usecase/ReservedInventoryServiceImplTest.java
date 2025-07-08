package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.output.ReservedInventoryPersistencePort;
import com.arka.inventory_service.domain.exception.customerOrder.CustomerOrderNotFoundException;
import com.arka.inventory_service.domain.model.ReservedInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@SpringBootTest
class ReservedInventoryServiceImplTest {

    @MockBean
    private ReservedInventoryPersistencePort persistencePort;

    private ReservedInventoryServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new ReservedInventoryServiceImpl(persistencePort);
    }

    @Test
    void getByOrderCode_success() {
        ReservedInventory reserved = new ReservedInventory();
        when(persistencePort.findByOrderCode("ORDER123")).thenReturn(Flux.just(reserved));

        StepVerifier.create(service.getByOrderCode("ORDER123"))
                .expectNext(reserved)
                .verifyComplete();
    }

    @Test
    void getByOrderCode_notFound() {
        when(persistencePort.findByOrderCode("NOTFOUND")).thenReturn(Flux.empty());

        StepVerifier.create(service.getByOrderCode("NOTFOUND"))
                .expectError(CustomerOrderNotFoundException.class)
                .verify();
    }
}

