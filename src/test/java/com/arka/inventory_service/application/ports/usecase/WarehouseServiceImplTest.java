package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.output.GeoLocationServicePort;
import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.domain.exception.warehouse.DuplicateWarehouseCodeException;
import com.arka.inventory_service.domain.exception.warehouse.GeoLocationNotFoundException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseListEmptyException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByCodeException;
import com.arka.inventory_service.domain.model.GeoCoordinates;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationException;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class WarehouseServiceImplTest {

    @MockBean
    private WarehousePersistencePort persistencePort;
    @MockBean
    private GeoLocationServicePort geoServicePort;
    @MockBean
    private WarehouseCodeValidationService codeValidationService;

    private WarehouseServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new WarehouseServiceImpl(persistencePort, geoServicePort, codeValidationService);
    }

    @Test
    void createWarehouse_success() {
        Warehouse warehouse = Warehouse.builder()
                .name("Bodega Norte")
                .city("Bogota")
                .state("Cundinamarca")
                .country("Colombia")
                .code("ABC123")
                .build();
        when(persistencePort.existsByCode("ABC123")).thenReturn(Mono.just(false));
        when(geoServicePort.getCoordinates("Bogota", "Cundinamarca", "Colombia"))
                .thenReturn(Mono.just(new GeoCoordinates(4.7, -74.1)));
        when(persistencePort.save(any(Warehouse.class)))
                .thenAnswer(inv -> Mono.just(inv.getArgument(0)));

        StepVerifier.create(service.createWarehouse(warehouse))
                .expectNextMatches(w -> w.getCode().equals("ABC123") && w.getLatitude() == 4.7)
                .verifyComplete();
    }

    @Test
    void createWarehouse_duplicateCode() {
        Warehouse warehouse = Warehouse.builder().code("DUPL").build();
        when(persistencePort.existsByCode("DUPL")).thenReturn(Mono.just(true));

        StepVerifier.create(service.createWarehouse(warehouse))
                .expectError(DuplicateWarehouseCodeException.class)
                .verify();
    }

    @Test
    void createWarehouse_geoLocationNotFound() {
        Warehouse warehouse = Warehouse.builder().city("X").state("Y").country("Z").code("GEO1").build();
        when(persistencePort.existsByCode("GEO1")).thenReturn(Mono.just(false));
        when(geoServicePort.getCoordinates("X", "Y", "Z")).thenReturn(Mono.empty());

        StepVerifier.create(service.createWarehouse(warehouse))
                .expectError(GeoLocationNotFoundException.class)
                .verify();
    }

    @Test
    void deleteWarehouseByCode_success() {
        when(codeValidationService.isValid("ABC123")).thenReturn(true);
        when(persistencePort.existsByCode("ABC123")).thenReturn(Mono.just(true));
        Warehouse wh = Warehouse.builder().id(UUID.randomUUID()).code("ABC123").build();
        when(persistencePort.findByCode("ABC123")).thenReturn(Mono.just(wh));
        when(persistencePort.deleteById(any(UUID.class))).thenReturn(Mono.empty());

        StepVerifier.create(service.deleteWarehouseByCode("ABC123"))
                .verifyComplete();
    }

    @Test
    void deleteWarehouseByCode_invalidCode() {
        when(codeValidationService.isValid("bad_code")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.deleteWarehouseByCode("bad_code"));
    }

    @Test
    void getAllWarehouses_empty() {
        when(persistencePort.findAll()).thenReturn(Flux.empty());
        StepVerifier.create(service.getAllWarehouses())
                .expectError(WarehouseListEmptyException.class)
                .verify();
    }

    @Test
    void getWarehouseInventoryByCode_success() {
        when(codeValidationService.isValid("ABC123")).thenReturn(true);
        when(persistencePort.existsByCode("ABC123")).thenReturn(Mono.just(true));
        Warehouse wh = Warehouse.builder().id(UUID.randomUUID()).code("ABC123").build();
        when(persistencePort.findByCode("ABC123")).thenReturn(Mono.just(wh));
        when(persistencePort.findInventoryByWarehouseId(wh.getId())).thenReturn(Flux.empty());

        StepVerifier.create(service.getWarehouseInventoryByCode("ABC123"))
                .expectNextMatches(resp -> resp.getWarehouse().getCode().equals("ABC123"))
                .verifyComplete();
    }

    @Test
    void getWarehouseInventoryByCode_invalidCode() {
        when(codeValidationService.isValid("bad_code")).thenReturn(false);
        assertThrows(ValidationException.class, () -> service.getWarehouseInventoryByCode("bad_code"));
    }

    @Test
    void getWarehouseInventoryByCode_notFound() {
        when(codeValidationService.isValid("NOTFOUND")).thenReturn(true);
        when(persistencePort.existsByCode("NOTFOUND")).thenReturn(Mono.just(false));
        StepVerifier.create(service.getWarehouseInventoryByCode("NOTFOUND"))
                .expectError(WarehouseNotFoundByCodeException.class)
                .verify();
    }
}
