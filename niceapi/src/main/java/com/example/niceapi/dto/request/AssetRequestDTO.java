package com.example.niceapi.dto.request;

import com.example.niceapi.model.AssetStatus;
import com.example.niceapi.model.AssetType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AssetRequestDTO {
    @NotBlank(message = "Asset name is required")
    private String assetName;

    @NotBlank(message = "Asset code is required")
    private String assetCode;

    @NotNull(message = "Asset type is required")
    private AssetType assetType;

    @NotNull(message = "Current value in NGN is required")
    private Double currentValueNGN;

    @NotNull(message = "Current value in USD is required")
    private Double currentValueUSD;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotBlank(message = "Unit is required")
    private String unit;

    @NotNull(message = "Asset status is required")
    private AssetStatus status;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Double getCurrentValueNGN() {
        return currentValueNGN;
    }

    public void setCurrentValueNGN(Double currentValueNGN) {
        this.currentValueNGN = currentValueNGN;
    }

    public Double getCurrentValueUSD() {
        return currentValueUSD;
    }

    public void setCurrentValueUSD(Double currentValueUSD) {
        this.currentValueUSD = currentValueUSD;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public AssetStatus getStatus() {
        return status;
    }

    public void setStatus(AssetStatus status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

}
