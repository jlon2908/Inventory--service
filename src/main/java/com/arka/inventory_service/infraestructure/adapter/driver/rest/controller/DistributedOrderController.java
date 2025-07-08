//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.controller;

import com.arka.inventory_service.application.ports.input.DistributedOrderServicePort;
import com.arka.inventory_service.domain.model.GroupedDistributionsByOrder;
import com.arka.inventory_service.infraestructure.adapter.driven.db.repository.WarehouseRepository;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.DistributedItemDto;
import com.arka.inventory_service.infraestructure.adapter.driver.rest.dto.OrderDistributionBySourceWarehouseResponseDto;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping({"/api/distributed-orders"})
public class DistributedOrderController {
    private final DistributedOrderServicePort servicePort;
    private final WarehouseRepository warehouseRepository;

    @GetMapping
    public Flux<OrderDistributionBySourceWarehouseResponseDto> getDistributedOrdersBySourceWarehouse(@RequestParam String sourceWarehouseCode, @RequestParam(required = false) String status) {
        return this.servicePort.getGroupedDistributionsByOrder(sourceWarehouseCode, status).collectList().flatMapMany((groups) -> {
            List<UUID> warehouseIds = groups.stream().flatMap((g) -> g.getItems().stream()).map((item) -> item.getSourceWarehouseId()).distinct().toList();
            return Flux.fromIterable(warehouseIds).flatMap((id) -> this.warehouseRepository.findById(id).map((wh) -> Map.entry(id, wh.getCode()))).collectMap(Map.Entry::getKey, Map.Entry::getValue).flatMapMany((idToCodeMap) -> Flux.fromIterable(groups).map((group) -> this.toResponseDto(group, idToCodeMap)));
        });
    }

    private OrderDistributionBySourceWarehouseResponseDto toResponseDto(GroupedDistributionsByOrder group, Map<UUID, String> idToCodeMap) {
        List<DistributedItemDto> itemDtos = group.getItems().stream().map((item) -> DistributedItemDto.builder().sku(item.getSku()).assignedQuantity(item.getAssignedQuantity()).distributionStatus(item.getStatus()).sourceWarehouseCode((String)idToCodeMap.getOrDefault(item.getSourceWarehouseId(), item.getSourceWarehouseId().toString())).destinationWarehouseCode(item.getDestinationWarehouseCode()).build()).toList();
        return OrderDistributionBySourceWarehouseResponseDto.builder().orderCode(group.getOrderCode()).items(itemDtos).build();
    }

    @PutMapping({"/status"})
    public Mono<Integer> updateDistributionsStatus(@RequestParam String orderCode, @RequestParam String sourceWarehouseCode, @RequestParam String newStatus) {
        return this.servicePort.updateDistributionsStatus(orderCode, sourceWarehouseCode, newStatus);
    }

    @Generated
    public DistributedOrderController(final DistributedOrderServicePort servicePort, final WarehouseRepository warehouseRepository) {
        this.servicePort = servicePort;
        this.warehouseRepository = warehouseRepository;
    }
}
