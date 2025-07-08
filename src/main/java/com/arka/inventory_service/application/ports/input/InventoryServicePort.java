package com.arka.inventory_service.application.ports.input;

import com.arka.inventory_service.domain.model.Inventory;
import com.arka.inventory_service.domain.model.InventoryDelta;
import com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto.OrderPlacedEventDto;
import java.util.List;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryServicePort {
    Mono<Void> increaseStockByEvent(List<InventoryDelta> deltas);

    Mono<Void> increaseStockManually(String sku, int quantity, UUID warehouseId);

    Mono<Integer> getStockBySku(String sku);

    Flux<Inventory> filterByMinQuantity(int minQuantity);

    Mono<Void> processPlacedOrder(OrderPlacedEventDto event);

    Flux<Inventory> getStockBySkuAcrossWarehouses(String sku);
}
