//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.listener;

import com.arka.inventory_service.application.ports.input.InventoryServicePort;
import com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto.OrderPlacedEventDto;
import lombok.Generated;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderPlacedEventListener {
    private final InventoryServicePort inventoryServicePort;

    @RabbitListener(
            queues = {"order.placed"}
    )
    public void handleOrderPlacedEvent(@Payload OrderPlacedEventDto event) {
        System.out.println(">>> RECEIVED ORDER.PLACED EVENT:");
        System.out.printf("OrderCode: %s | UserId: %s | Pickup: %s%n", event.getOrderCode(), event.getUserId(), event.getWarehousePickupCode());
        event.getItems().forEach((item) -> {
            System.out.printf("SKU: %s%n", item.getSku());
            item.getAssignedDistributions().forEach((d) -> System.out.printf("  - Warehouse: %s | Qty: %d%n", d.getWarehouseCode(), d.getQuantity()));
        });
        this.inventoryServicePort.processPlacedOrder(event).subscribe();
    }

    @Generated
    public OrderPlacedEventListener(final InventoryServicePort inventoryServicePort) {
        this.inventoryServicePort = inventoryServicePort;
    }
}
