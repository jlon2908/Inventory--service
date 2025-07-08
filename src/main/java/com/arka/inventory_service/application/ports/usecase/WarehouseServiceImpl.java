package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.input.WarehouseServicePort;
import com.arka.inventory_service.application.ports.output.GeoLocationServicePort;
import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.domain.exception.warehouse.DuplicateWarehouseCodeException;
import com.arka.inventory_service.domain.exception.warehouse.GeoLocationNotFoundException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseListEmptyException;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByCodeException;
import com.arka.inventory_service.domain.model.Warehouse;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationErrorDetail;
import com.arka.inventory_service.global.ValidationException;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WarehouseServiceImpl implements WarehouseServicePort {
    private final WarehousePersistencePort persistencePort;
    private final GeoLocationServicePort geoServicePort;
    private final WarehouseCodeValidationService warehouseCodeValidationService;

    public Mono<Warehouse> createWarehouse(Warehouse warehouse) {
        if (warehouse.getId() == null) {
            warehouse.setId(UUID.randomUUID());
        }

        return this.persistencePort.existsByCode(warehouse.getCode()).flatMap((exists) -> {
            if (Boolean.TRUE.equals(exists)) {
                return Mono.error(new DuplicateWarehouseCodeException(warehouse.getCode()));
            } else {
                Mono var10000 = this.geoServicePort.getCoordinates(warehouse.getCity(), warehouse.getState(), warehouse.getCountry());
                String var10003 = warehouse.getCity();
                return var10000.switchIfEmpty(Mono.error(new GeoLocationNotFoundException(var10003 + ", " + warehouse.getState() + ", " + warehouse.getCountry()))).flatMap((coords) -> {
                    com.arka.inventory_service.domain.model.GeoCoordinates geo = (com.arka.inventory_service.domain.model.GeoCoordinates) coords;
                    warehouse.setLatitude(geo.getLatitude());
                    warehouse.setLongitude(geo.getLongitude());
                    warehouse.setCreatedAt(LocalDateTime.now());
                    return this.persistencePort.save(warehouse);
                });
            }
        });
    }

    public Mono<Void> deleteWarehouseByCode(String code) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (!this.warehouseCodeValidationService.isValid(code)) {
            errors.add(new ValidationErrorDetail("code", "The warehouse code format is invalid. Use 3-10 uppercase letters or digits."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return this.persistencePort.existsByCode(code).flatMap((exists) -> {
                if (!exists) {
                    throw new WarehouseNotFoundByCodeException(code);
                } else {
                    return this.persistencePort.findByCode(code).flatMap((warehouse) -> this.persistencePort.deleteById(UUID.fromString(warehouse.getId().toString())));
                }
            });
        }
    }

    public Flux<Warehouse> getAllWarehouses() {
        return this.persistencePort.findAll().switchIfEmpty(Mono.error(new WarehouseListEmptyException()));
    }

    public Mono<WarehouseInventoryResponse> getWarehouseInventoryByCode(String code) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (!this.warehouseCodeValidationService.isValid(code)) {
            errors.add(new ValidationErrorDetail("code", "The warehouse code format is invalid. Use 3-10 uppercase letters or digits."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return this.persistencePort.existsByCode(code).flatMap((exists) -> {
                if (!exists) {
                    throw new WarehouseNotFoundByCodeException(code);
                } else {
                    return this.persistencePort.findByCode(code).flatMap((warehouse) -> this.persistencePort.findInventoryByWarehouseId(warehouse.getId()).collectList().map((inventoryItems) -> WarehouseInventoryResponse.builder().warehouse(warehouse).inventory(inventoryItems).build()));
                }
            });
        }
    }

    public Mono<Warehouse> findById(UUID id) {
        return this.persistencePort.findById(id);
    }

    @Generated
    public WarehouseServiceImpl(final WarehousePersistencePort persistencePort, final GeoLocationServicePort geoServicePort, final WarehouseCodeValidationService warehouseCodeValidationService) {
        this.persistencePort = persistencePort;
        this.geoServicePort = geoServicePort;
        this.warehouseCodeValidationService = warehouseCodeValidationService;
    }
}
