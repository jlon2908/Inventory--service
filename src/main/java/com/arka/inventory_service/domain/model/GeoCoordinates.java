//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import lombok.Generated;

public class GeoCoordinates {
    private final Double latitude;
    private final Double longitude;

    @Generated
    public static GeoCoordinatesBuilder builder() {
        return new GeoCoordinatesBuilder();
    }

    @Generated
    public Double getLatitude() {
        return this.latitude;
    }

    @Generated
    public Double getLongitude() {
        return this.longitude;
    }

    @Generated
    public GeoCoordinates(final Double latitude, final Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Generated
    public static class GeoCoordinatesBuilder {
        @Generated
        private Double latitude;
        @Generated
        private Double longitude;

        @Generated
        GeoCoordinatesBuilder() {
        }

        @Generated
        public GeoCoordinatesBuilder latitude(final Double latitude) {
            this.latitude = latitude;
            return this;
        }

        @Generated
        public GeoCoordinatesBuilder longitude(final Double longitude) {
            this.longitude = longitude;
            return this;
        }

        @Generated
        public GeoCoordinates build() {
            return new GeoCoordinates(this.latitude, this.longitude);
        }

        @Generated
        public String toString() {
            return "GeoCoordinates.GeoCoordinatesBuilder(latitude=" + this.latitude + ", longitude=" + this.longitude + ")";
        }
    }
}
