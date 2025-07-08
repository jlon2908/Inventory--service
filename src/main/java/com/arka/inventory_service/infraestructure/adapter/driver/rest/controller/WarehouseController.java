//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.WarehouseServicePort;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseInventoryResponse;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseRequestDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.WarehouseResponseDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.mapper.WarehouseRestMapper;
import lombok.Generated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/warehouses"})
public class WarehouseController {
    private final WarehouseServicePort servicePort;

    @PostMapping
    public Mono<WarehouseResponseDto> create(@RequestBody WarehouseRequestDto request) {
        return this.servicePort.createWarehouse(WarehouseRestMapper.toDomain(request)).map(WarehouseRestMapper::toResponseDto);
    }

    @DeleteMapping({"/{code}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable String code) {
        return this.servicePort.deleteWarehouseByCode(code);
    }

    @GetMapping
    public Flux<WarehouseResponseDto> getAll() {
        return this.servicePort.getAllWarehouses().map(WarehouseRestMapper::toResponseDto);
    }

    @GetMapping({"/{code}/inventory"})
    public Mono<WarehouseInventoryResponse> getInventoryByWarehouseCode(@PathVariable String code) {
        return this.servicePort.getWarehouseInventoryByCode(code);
    }

    @Generated
    public WarehouseController(final WarehouseServicePort servicePort) {
        this.servicePort = servicePort;
    }
}
