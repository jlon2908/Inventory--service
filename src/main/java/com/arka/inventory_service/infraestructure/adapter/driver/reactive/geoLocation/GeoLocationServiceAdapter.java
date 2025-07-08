//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.reactive.geoLocation;

import com.arka.inventory_service.application.ports.output.GeoLocationServicePort;
import com.arka.inventory_service.domain.model.GeoCoordinates;
import lombok.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GeoLocationServiceAdapter implements GeoLocationServicePort {
    private final WebClient webClient = WebClient.create("https://nominatim.openstreetmap.org");

    public Mono<GeoCoordinates> getCoordinates(String city, String state, String country) {
        String query = String.format("%s, %s, %s", city, state, country);
        return this.webClient.get().uri((uriBuilder) -> uriBuilder.path("/search").queryParam("q", new Object[]{query}).queryParam("format", new Object[]{"json"}).queryParam("limit", new Object[]{1}).build(new Object[0])).header("User-Agent", new String[]{"ArkaInventoryService/1.0 (jonathanlon.66@gmail.com)"}).retrieve().bodyToMono(NominatimResponse[].class).filter((responseArray) -> responseArray.length > 0).map((responseArray) -> {
            NominatimResponse result = responseArray[0];
            return new GeoCoordinates(Double.parseDouble(result.lat()), Double.parseDouble(result.lon()));
        });
    }

    @Generated
    public GeoLocationServiceAdapter() {
    }

    private static record NominatimResponse(String lat, String lon) {
        private NominatimResponse(String lat, String lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public String lat() {
            return this.lat;
        }

        public String lon() {
            return this.lon;
        }
    }
}
