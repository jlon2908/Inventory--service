//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.rest.dto;

import lombok.Generated;

public class DistributedItemDto {
    private String sku;
    private int assignedQuantity;
    private String distributionStatus;
    private String sourceWarehouseCode;
    private String destinationWarehouseCode;

    @Generated
    public static DistributedItemDtoBuilder builder() {
        return new DistributedItemDtoBuilder();
    }

    @Generated
    public String getSku() {
        return this.sku;
    }

    @Generated
    public int getAssignedQuantity() {
        return this.assignedQuantity;
    }

    @Generated
    public String getDistributionStatus() {
        return this.distributionStatus;
    }

    @Generated
    public String getSourceWarehouseCode() {
        return this.sourceWarehouseCode;
    }

    @Generated
    public String getDestinationWarehouseCode() {
        return this.destinationWarehouseCode;
    }

    @Generated
    public DistributedItemDto(final String sku, final int assignedQuantity, final String distributionStatus, final String sourceWarehouseCode, final String destinationWarehouseCode) {
        this.sku = sku;
        this.assignedQuantity = assignedQuantity;
        this.distributionStatus = distributionStatus;
        this.sourceWarehouseCode = sourceWarehouseCode;
        this.destinationWarehouseCode = destinationWarehouseCode;
    }

    @Generated
    public DistributedItemDto() {
    }

    @Generated
    public static class DistributedItemDtoBuilder {
        @Generated
        private String sku;
        @Generated
        private int assignedQuantity;
        @Generated
        private String distributionStatus;
        @Generated
        private String sourceWarehouseCode;
        @Generated
        private String destinationWarehouseCode;

        @Generated
        DistributedItemDtoBuilder() {
        }

        @Generated
        public DistributedItemDtoBuilder sku(final String sku) {
            this.sku = sku;
            return this;
        }

        @Generated
        public DistributedItemDtoBuilder assignedQuantity(final int assignedQuantity) {
            this.assignedQuantity = assignedQuantity;
            return this;
        }

        @Generated
        public DistributedItemDtoBuilder distributionStatus(final String distributionStatus) {
            this.distributionStatus = distributionStatus;
            return this;
        }

        @Generated
        public DistributedItemDtoBuilder sourceWarehouseCode(final String sourceWarehouseCode) {
            this.sourceWarehouseCode = sourceWarehouseCode;
            return this;
        }

        @Generated
        public DistributedItemDtoBuilder destinationWarehouseCode(final String destinationWarehouseCode) {
            this.destinationWarehouseCode = destinationWarehouseCode;
            return this;
        }

        @Generated
        public DistributedItemDto build() {
            return new DistributedItemDto(this.sku, this.assignedQuantity, this.distributionStatus, this.sourceWarehouseCode, this.destinationWarehouseCode);
        }

        @Generated
        public String toString() {
            return "DistributedItemDto.DistributedItemDtoBuilder(sku=" + this.sku + ", assignedQuantity=" + this.assignedQuantity + ", distributionStatus=" + this.distributionStatus + ", sourceWarehouseCode=" + this.sourceWarehouseCode + ", destinationWarehouseCode=" + this.destinationWarehouseCode + ")";
        }
    }
}
