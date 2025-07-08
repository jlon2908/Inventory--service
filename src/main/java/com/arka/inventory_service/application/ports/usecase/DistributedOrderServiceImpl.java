package com.arka.inventory_service.application.ports.usecase;


import com.arka.inventory_service.application.ports.input.DistributedOrderServicePort;
import com.arka.inventory_service.application.ports.output.OrderDistributionPersistencePort;
import com.arka.inventory_service.application.ports.output.WarehousePersistencePort;
import com.arka.inventory_service.domain.exception.warehouse.WarehouseNotFoundByCodeException;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.domain.service.DistributionStatusValidationService;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationErrorDetail;
import com.arka.inventory_service.global.ValidationException;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DistributedOrderServiceImpl implements DistributedOrderServicePort {
    private final OrderDistributionPersistencePort persistencePort;
    private final WarehouseCodeValidationService warehouseCodeValidationService;
    private final DistributionStatusValidationService distributionStatusValidationService;
    private final WarehousePersistencePort warehousePersistencePort;

    public Flux<GroupedDistributionsByOrder> getGroupedDistributionsByOrder(String sourceWarehouseCode, String status) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (!this.warehouseCodeValidationService.isValid(sourceWarehouseCode)) {
            errors.add(new ValidationErrorDetail("sourceWarehouseCode", "The warehouse code format is invalid. Use 3-10 uppercase letters or digits."));
        }

        if (status != null && !this.distributionStatusValidationService.isValid(status)) {
            errors.add(new ValidationErrorDetail("status", "Invalid distribution status."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return this.warehousePersistencePort.existsByCode(sourceWarehouseCode).flatMapMany((exists) -> {
                if (!exists) {
                    System.out.println("❌ Warehouse no existe: " + sourceWarehouseCode);
                    throw new WarehouseNotFoundByCodeException(sourceWarehouseCode);
                } else {
                    return this.persistencePort.findGroupedByOrderCodeFromSource(sourceWarehouseCode, status);
                }
            });
        }
    }

    public Mono<Integer> updateDistributionsStatus(String orderCode, String sourceWarehouseCode, String newStatus) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (orderCode == null || orderCode.isBlank()) {
            errors.add(new ValidationErrorDetail("orderCode", "Order code is required."));
        }

        if (sourceWarehouseCode == null || !this.warehouseCodeValidationService.isValid(sourceWarehouseCode)) {
            errors.add(new ValidationErrorDetail("sourceWarehouseCode", "The warehouse code format is invalid. Use 3-10 uppercase letters or digits."));
        }

        if (newStatus == null || !this.distributionStatusValidationService.isValid(newStatus)) {
            errors.add(new ValidationErrorDetail("newStatus", "Invalid distribution status."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return this.warehousePersistencePort.existsByCode(sourceWarehouseCode).flatMap((exists) -> {
                if (!exists) {
                    throw new WarehouseNotFoundByCodeException(sourceWarehouseCode);
                } else {
                    return this.persistencePort.updateStatusByOrderCodeAndSourceWarehouse(orderCode, sourceWarehouseCode, newStatus);
                }
            });
        }
    }

    @Generated
    public DistributedOrderServiceImpl(final OrderDistributionPersistencePort persistencePort, final WarehouseCodeValidationService warehouseCodeValidationService, final DistributionStatusValidationService distributionStatusValidationService, final WarehousePersistencePort warehousePersistencePort) {
        this.persistencePort = persistencePort;
        this.warehouseCodeValidationService = warehouseCodeValidationService;
        this.distributionStatusValidationService = distributionStatusValidationService;
        this.warehousePersistencePort = warehousePersistencePort;
    }
}

