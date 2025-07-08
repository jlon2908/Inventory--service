//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.InventoryServicePort;
import com.arka.inventory_service.application.ports.input.WarehouseServicePort;
import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.IncreaseStockRequestDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.InventoryStockResponseDto;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/inventory"})
public class InventoryController {
    private final InventoryServicePort inventoryServicePort;
    private final WarehouseServicePort warehouseServicePort;

    @PostMapping({"/increase"})
    public Mono<Void> increaseStockManually(@RequestBody IncreaseStockRequestDto request) {
        return this.inventoryServicePort.increaseStockManually(request.getSku(), request.getQuantity(), request.getWarehouseId());
    }

    @GetMapping({"/{sku}/stock"})
    public Flux<InventoryStockResponseDto> getStockBySkuAcrossWarehouses(@PathVariable String sku) {
        return this.inventoryServicePort.getStockBySkuAcrossWarehouses(sku).flatMap((inventory) -> this.warehouseServicePort.findById(inventory.getWarehouseId()).map((warehouse) -> InventoryStockResponseDto.builder().sku(inventory.getSku()).warehouseCode(warehouse.getCode()).quantity(inventory.getQuantity()).lastUpdated(inventory.getUpdatedAt()).build()));
    }

    @GetMapping({"/filter"})
    public Flux<Inventory> filterByMinQuantity(@RequestParam int minQuantity) {
        return this.inventoryServicePort.filterByMinQuantity(minQuantity);
    }

    @Generated
    public InventoryController(final InventoryServicePort inventoryServicePort, final WarehouseServicePort warehouseServicePort) {
        this.inventoryServicePort = inventoryServicePort;
        this.warehouseServicePort = warehouseServicePort;
    }
}
