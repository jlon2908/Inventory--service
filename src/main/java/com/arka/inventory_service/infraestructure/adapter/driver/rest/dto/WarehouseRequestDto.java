//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import lombok.Generated;

public class WarehouseRequestDto {
    private String name;
    private String country;
    private String state;
    private String city;
    private String address;
    private String code;

    @Generated
    public static WarehouseRequestDtoBuilder builder() {
        return new WarehouseRequestDtoBuilder();
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
    public WarehouseRequestDto(final String name, final String country, final String state, final String city, final String address, final String code) {
        this.name = name;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.code = code;
    }

    @Generated
    public WarehouseRequestDto() {
    }

    @Generated
    public static class WarehouseRequestDtoBuilder {
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
        WarehouseRequestDtoBuilder() {
        }

        @Generated
        public WarehouseRequestDtoBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @Generated
        public WarehouseRequestDtoBuilder country(final String country) {
            this.country = country;
            return this;
        }

        @Generated
        public WarehouseRequestDtoBuilder state(final String state) {
            this.state = state;
            return this;
        }

        @Generated
        public WarehouseRequestDtoBuilder city(final String city) {
            this.city = city;
            return this;
        }

        @Generated
        public WarehouseRequestDtoBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @Generated
        public WarehouseRequestDtoBuilder code(final String code) {
            this.code = code;
            return this;
        }

        @Generated
        public WarehouseRequestDto build() {
            return new WarehouseRequestDto(this.name, this.country, this.state, this.city, this.address, this.code);
        }

        @Generated
        public String toString() {
            return "WarehouseRequestDto.WarehouseRequestDtoBuilder(name=" + this.name + ", country=" + this.country + ", state=" + this.state + ", city=" + this.city + ", address=" + this.address + ", code=" + this.code + ")";
        }
    }
}
