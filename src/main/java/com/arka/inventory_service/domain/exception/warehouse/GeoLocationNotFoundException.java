//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.exception.warehouse;

public class GeoLocationNotFoundException extends RuntimeException {
    public GeoLocationNotFoundException(String location) {
        super(String.format("No se pudo encontrar la ubicación para: %s", location));
    }
}
