//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;

public class Warehouse {
    private UUID id;
    private String name;
    private String country;
    private String state;
    private String city;
    private String address;
    private String code;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;

    @Generated
    public static WarehouseBuilder builder() {
        return new WarehouseBuilder();
    }

    @Generated
    public UUID getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getCountry() {
        return this.country;
    }

    @Generated
    public String getState() {
        return this.state;
    }

    @Generated
    public String getCity() {
        return this.city;
    }

    @Generated
    public String getAddress() {
        return this.address;
    }

    @Generated
    public String getCode() {
        return this.code;
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
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Generated
    public void setId(final UUID id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setCountry(final String country) {
        this.country = country;
    }

    @Generated
    public void setState(final String state) {
        this.state = state;
    }

    @Generated
    public void setCity(final String city) {
        this.city = city;
    }

    @Generated
    public void setAddress(final String address) {
        this.address = address;
    }

    @Generated
    public void setCode(final String code) {
        this.code = code;
    }

    @Generated
    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }

    @Generated
    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    @Generated
    public void setCreatedAt(final LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Generated
    public Warehouse(final UUID id, final String name, final String country, final String state, final String city, final String address, final String code, final Double latitude, final Double longitude, final LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = createdAt;
    }

    @Generated
    public Warehouse() {
    }

    @Generated
    public static class WarehouseBuilder {
        @Generated
        private UUID id;
        @Generated
        private String name;
        @Generated
        private String country;
        @Generated
        private String state;
        @Generated
        private String city;
        @Generated
        private String address;
        @Generated
        private String code;
        @Generated
        private Double latitude;
        @Generated
        private Double longitude;
        @Generated
        private LocalDateTime createdAt;

        @Generated
        WarehouseBuilder() {
        }

        @Generated
        public WarehouseBuilder id(final UUID id) {
            this.id = id;
            return this;
        }

        @Generated
        public WarehouseBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @Generated
        public WarehouseBuilder country(final String country) {
            this.country = country;
            return this;
        }

        @Generated
        public WarehouseBuilder state(final String state) {
            this.state = state;
            return this;
        }

        @Generated
        public WarehouseBuilder city(final String city) {
            this.city = city;
            return this;
        }

        @Generated
        public WarehouseBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @Generated
        public WarehouseBuilder code(final String code) {
            this.code = code;
            return this;
        }

        @Generated
        public WarehouseBuilder latitude(final Double latitude) {
            this.latitude = latitude;
            return this;
        }

        @Generated
        public WarehouseBuilder longitude(final Double longitude) {
            this.longitude = longitude;
            return this;
        }

        @Generated
        public WarehouseBuilder createdAt(final LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        @Generated
        public Warehouse build() {
            return new Warehouse(this.id, this.name, this.country, this.state, this.city, this.address, this.code, this.latitude, this.longitude, this.createdAt);
        }

        @Generated
        public String toString() {
            return "Warehouse.WarehouseBuilder(id=" + this.id + ", name=" + this.name + ", country=" + this.country + ", state=" + this.state + ", city=" + this.city + ", address=" + this.address + ", code=" + this.code + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", createdAt=" + this.createdAt + ")";
        }
    }
}
