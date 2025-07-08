//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driven.db.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("warehouse")
public class WarehouseEntity {
    @Id
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
    public WarehouseEntity() {
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
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof WarehouseEntity)) {
            return false;
        } else {
            WarehouseEntity other = (WarehouseEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$latitude = this.getLatitude();
                Object other$latitude = other.getLatitude();
                if (this$latitude == null) {
                    if (other$latitude != null) {
                        return false;
                    }
                } else if (!this$latitude.equals(other$latitude)) {
                    return false;
                }

                Object this$longitude = this.getLongitude();
                Object other$longitude = other.getLongitude();
                if (this$longitude == null) {
                    if (other$longitude != null) {
                        return false;
                    }
                } else if (!this$longitude.equals(other$longitude)) {
                    return false;
                }

                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$country = this.getCountry();
                Object other$country = other.getCountry();
                if (this$country == null) {
                    if (other$country != null) {
                        return false;
                    }
                } else if (!this$country.equals(other$country)) {
                    return false;
                }

                Object this$state = this.getState();
                Object other$state = other.getState();
                if (this$state == null) {
                    if (other$state != null) {
                        return false;
                    }
                } else if (!this$state.equals(other$state)) {
                    return false;
                }

                Object this$city = this.getCity();
                Object other$city = other.getCity();
                if (this$city == null) {
                    if (other$city != null) {
                        return false;
                    }
                } else if (!this$city.equals(other$city)) {
                    return false;
                }

                Object this$address = this.getAddress();
                Object other$address = other.getAddress();
                if (this$address == null) {
                    if (other$address != null) {
                        return false;
                    }
                } else if (!this$address.equals(other$address)) {
                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$createdAt = this.getCreatedAt();
                Object other$createdAt = other.getCreatedAt();
                if (this$createdAt == null) {
                    if (other$createdAt != null) {
                        return false;
                    }
                } else if (!this$createdAt.equals(other$createdAt)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof WarehouseEntity;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $latitude = this.getLatitude();
        result = result * 59 + ($latitude == null ? 43 : $latitude.hashCode());
        Object $longitude = this.getLongitude();
        result = result * 59 + ($longitude == null ? 43 : $longitude.hashCode());
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $country = this.getCountry();
        result = result * 59 + ($country == null ? 43 : $country.hashCode());
        Object $state = this.getState();
        result = result * 59 + ($state == null ? 43 : $state.hashCode());
        Object $city = this.getCity();
        result = result * 59 + ($city == null ? 43 : $city.hashCode());
        Object $address = this.getAddress();
        result = result * 59 + ($address == null ? 43 : $address.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $createdAt = this.getCreatedAt();
        result = result * 59 + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        UUID var10000 = this.getId();
        return "WarehouseEntity(id=" + var10000 + ", name=" + this.getName() + ", country=" + this.getCountry() + ", state=" + this.getState() + ", city=" + this.getCity() + ", address=" + this.getAddress() + ", code=" + this.getCode() + ", latitude=" + this.getLatitude() + ", longitude=" + this.getLongitude() + ", createdAt=" + this.getCreatedAt() + ")";
    }
}
