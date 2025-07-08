//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.CustomerOrderInServicePort;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.CustomerOrderItemRepository;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.CustomerOrderItemResponse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.CustomerOrderResponse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.UpdateCustomerOrderStatusRequest;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/customer-orders"})
public class CustomerOrderController {
    private final CustomerOrderInServicePort customerOrderService;
    private final CustomerOrderItemRepository customerOrderItemRepository;

    @PatchMapping({"/{orderCode}/status"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> updateOrderStatus(@PathVariable String orderCode, @RequestBody UpdateCustomerOrderStatusRequest request) {
        return this.customerOrderService.updateStatus(orderCode, request.getStatus());
    }

    @GetMapping({"/filter"})
    public Flux<CustomerOrderResponse> filterOrders(@RequestParam(required = false) String orderCode, @RequestParam(required = false) String warehousePickupCode, @RequestParam(required = false) String status, @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime from, @RequestParam(required = false) @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime to) {
        return this.customerOrderService.filterOrders(orderCode, warehousePickupCode, status, from, to).flatMap((order) -> this.customerOrderItemRepository.findByCustomerOrderId(order.getId()).map((item) -> new CustomerOrderItemResponse(item.getSku(), item.getQuantity())).collectList().map((items) -> new CustomerOrderResponse(order.getId(), order.getOrderCode(), order.getStatus(), order.getWarehousePickupCode(), order.getCreatedAt(), items)));
    }

    @PatchMapping({"/{orderCode}/cancel"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> cancelOrderByCustomer(@PathVariable String orderCode, @RequestHeader("X-Client-UUID") String clientUuidStr) {
        UUID clientUuid;
        try {
            clientUuid = UUID.fromString(clientUuidStr);
        } catch (IllegalArgumentException var5) {
            return Mono.error(new IllegalArgumentException("UUID inválido"));
        }

        return this.customerOrderService.cancelOrderByCustomer(orderCode, clientUuid);
    }

    @Generated
    public CustomerOrderController(final CustomerOrderInServicePort customerOrderService, final CustomerOrderItemRepository customerOrderItemRepository) {
        this.customerOrderService = customerOrderService;
        this.customerOrderItemRepository = customerOrderItemRepository;
    }
}
