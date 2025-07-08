//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.amqp.dto;

import java.util.List;
import lombok.Generated;

public class StockReceivedEventDto {
    private List<StockItemDto> items;

    @Generated
    public StockReceivedEventDto() {
    }

    @Generated
    public List<StockItemDto> getItems() {
        return this.items;
    }

    @Generated
    public void setItems(final List<StockItemDto> items) {
        this.items = items;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StockReceivedEventDto)) {
            return false;
        } else {
            StockReceivedEventDto other = (StockReceivedEventDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$items = this.getItems();
                Object other$items = other.getItems();
                if (this$items == null) {
                    if (other$items != null) {
                        return false;
                    }
                } else if (!this$items.equals(other$items)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof StockReceivedEventDto;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Object $items = this.getItems();
        result = result * 59 + ($items == null ? 43 : $items.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "StockReceivedEventDto(items=" + this.getItems() + ")";
    }
}
