package com.arka.inventory_service.application.ports.output;

import com.arka.inventory_service.domain.model.GeoCoordinates;
import reactor.core.publisher.Mono;

public interface GeoLocationServicePort {
    Mono<GeoCoordinates> getCoordinates(String city, String state, String country);
}

