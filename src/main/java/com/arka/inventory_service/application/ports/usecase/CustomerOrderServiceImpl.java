package com.arka.inventory_service.application.ports.usecase;

import com.arka.inventory_service.application.ports.input.CustomerOrderInServicePort;
import com.arka.inventory_service.application.ports.output.CustomerOrderPersistencePort;
import com.arka.inventory_service.domain.exception.customerOrder.CustomerOrderNotFoundException;
import com.arka.inventory_service.domain.model.CustomerOrder;
import com.arka.inventory_service.domain.service.CustomerOrderStatusValidationService;
import com.arka.inventory_service.domain.service.WarehouseCodeValidationService;
import com.arka.inventory_service.global.ValidationErrorDetail;
import com.arka.inventory_service.global.ValidationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Generated;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderInServicePort {
    private final CustomerOrderPersistencePort persistencePort;
    private final CustomerOrderStatusValidationService statusValidationService;
    private final WarehouseCodeValidationService warehouseCodeValidationService;

    public Mono<Void> updateStatus(String orderCode, String newStatus) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (!this.statusValidationService.isValid(newStatus)) {
            errors.add(new ValidationErrorDetail("status", "Invalid status. Must be one of: ASSIGNED, READY_FOR_DELIVERY, DELIVERED, CANCELLED."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return this.persistencePort.findByOrderCode(orderCode).switchIfEmpty(Mono.error(new CustomerOrderNotFoundException(orderCode))).flatMap((order) -> {
                order.setStatus(newStatus);
                return this.persistencePort.update(order);
            });
        }
    }

    public Flux<CustomerOrder> filterOrders(String orderCode, String warehousePickupCode, String status, LocalDateTime from, LocalDateTime to) {
        List<ValidationErrorDetail> errors = new ArrayList();
        if (status != null && !this.statusValidationService.isValid(status)) {
            errors.add(new ValidationErrorDetail("status", "Invalid status. Must be one of: ASSIGNED, READY_FOR_DELIVERY, DELIVERED, CANCELLED."));
        }

        if (warehousePickupCode != null && !this.warehouseCodeValidationService.isValid(warehousePickupCode)) {
            errors.add(new ValidationErrorDetail("warehousePickupCode", "The warehouse code format is invalid. Use 3-10 uppercase letters or digits."));
        }

        if (from != null && to != null && from.isAfter(to)) {
            errors.add(new ValidationErrorDetail("dateRange", "The start date must be before the end date."));
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        } else {
            return orderCode != null ? this.persistencePort.findByOrderCode(orderCode).switchIfEmpty(Mono.error(new CustomerOrderNotFoundException(orderCode))).flatMapMany((order) -> this.persistencePort.filterOrders(orderCode, warehousePickupCode, status, from, to)) : this.persistencePort.filterOrders((String)null, warehousePickupCode, status, from, to);
        }
    }

    public Mono<Void> cancelOrderByCustomer(String orderCode, UUID customerId) {
        return this.persistencePort.findByOrderCode(orderCode).switchIfEmpty(Mono.error(new CustomerOrderNotFoundException(orderCode))).flatMap((order) -> {
            if (!order.getUserId().equals(customerId)) {
                return Mono.error(new ValidationException(List.of(new ValidationErrorDetail("orderCode", "No tienes permiso para cancelar esta orden."))));
            } else if ("CANCELLED".equals(order.getStatus())) {
                return Mono.empty();
            } else {
                order.setStatus("CANCELLED");
                return this.persistencePort.update(order);
            }
        });
    }

    @Generated
    public CustomerOrderServiceImpl(final CustomerOrderPersistencePort persistencePort, final CustomerOrderStatusValidationService statusValidationService, final WarehouseCodeValidationService warehouseCodeValidationService) {
        this.persistencePort = persistencePort;
        this.statusValidationService = statusValidationService;
        this.warehouseCodeValidationService = warehouseCodeValidationService;
    }
}

