//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.listener;

import com.arka.inventory_service.application.ports.input.InventoryServicePort;
import com.arka.inventory_service.domain.model.InventoryDelta;
import com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto.StockReceivedEventDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class StockReceivedEventListener {
    private final InventoryServicePort inventoryServicePort;

    @RabbitListener(
            queues = {"stock.received"}
    )
    public void handleStockReceivedEvent(@Payload StockReceivedEventDto message) {
        System.out.println(">>> RECEIVED EVENT in INVENTORY SERVICE:");
        message.getItems().forEach((item) -> System.out.printf(" - SKU: %s | Qty: %d | WarehouseCode: %s%n", item.getSku(), item.getQuantity(), item.getWarehouseCode()));
        List<InventoryDelta> deltas = (List)message.getItems().stream().map((dto) -> new InventoryDelta(dto.getSku(), dto.getQuantity(), dto.getWarehouseCode())).collect(Collectors.toList());
        this.inventoryServicePort.increaseStockByEvent(deltas).subscribe();
    }

    @Generated
    public StockReceivedEventListener(final InventoryServicePort inventoryServicePort) {
        this.inventoryServicePort = inventoryServicePort;
    }
}
