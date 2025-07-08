//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.ReservedInventoryServicePort;
import com.arka.inventory_service.infraestructure.adapter.driven.db.mapper.ReservedInventoryPersistenceMapper;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.ReservedInventoryResponseDto;
import java.util.Objects;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping({"/api/reserved-inventory"})
public class ReservedInventoryController {
    private final ReservedInventoryServicePort servicePort;
    private final ReservedInventoryPersistenceMapper responseMapper;

    @GetMapping({"/order/{orderCode}"})
    public Flux<ReservedInventoryResponseDto> getByOrderCode(@PathVariable String orderCode) {
        Flux<com.arka.inventory_service.domain.model.ReservedInventory> reservedFlux = this.servicePort.getByOrderCode(orderCode);
        ReservedInventoryPersistenceMapper var10001 = this.responseMapper;
        java.util.Objects.requireNonNull(var10001);
        return reservedFlux.map(var10001::toResponse);
    }

    @Generated
    public ReservedInventoryController(final ReservedInventoryServicePort servicePort, final ReservedInventoryPersistenceMapper responseMapper) {
        this.servicePort = servicePort;
        this.responseMapper = responseMapper;
    }
}
