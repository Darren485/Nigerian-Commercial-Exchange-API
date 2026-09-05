package com.example.niceapi.dto.request;

import com.example.niceapi.model.AssetStatus;
import com.example.niceapi.model.AssetType;
import com.example.niceapi.model.Company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AssetRequestDTO {
    @NotNull(message = "Asset ID is required")
    private Long id;

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

    @NotNull(message = "Unit is required")
    private Double unit;

    @NotNull(message = "Asset status is required")
    private AssetStatus assetStatus;

    @NotNull(message = "Company ID is required")
    private Long companyId;

    public Long getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public Double getCurrentValueNGN() {
        return currentValueNGN;
    }

    public Double getCurrentValueUSD() {
        return currentValueUSD;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getUnit() {
        return unit;
    }

    public AssetStatus getAssetStatus() {
        return assetStatus;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
