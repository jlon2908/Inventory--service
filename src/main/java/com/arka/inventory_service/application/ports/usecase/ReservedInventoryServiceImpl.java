package com.arka.inventory_service.application.ports.usecase;


import com.arka.inventory_service.application.ports.input.ReservedInventoryServicePort;
import com.arka.inventory_service.application.ports.output.ReservedInventoryPersistencePort;
import com.arka.inventory_service.domain.exception.customerOrder.CustomerOrderNotFoundException;
import com.arka.inventory_service.domain.model.ReservedInventory;
import lombok.Generated;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ReservedInventoryServiceImpl implements ReservedInventoryServicePort {
    private final ReservedInventoryPersistencePort persistencePort;

    public Flux<ReservedInventory> getByOrderCode(String orderCode) {
        return this.persistencePort.findByOrderCode(orderCode).switchIfEmpty(Flux.error(new CustomerOrderNotFoundException(orderCode)));
    }

    @Generated
    public ReservedInventoryServiceImpl(final ReservedInventoryPersistencePort persistencePort) {
        this.persistencePort = persistencePort;
    }
}
