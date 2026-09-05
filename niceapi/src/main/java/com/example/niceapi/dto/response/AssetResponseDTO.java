package com.example.niceapi.dto.response;

import com.example.niceapi.model.AssetStatus;
import com.example.niceapi.model.AssetType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetResponseDTO {
    private Long id;
    private String assetName;
    private AssetType assetType;
    private Integer quantity;
    private Double currentValueNGN;
    private Double currentValueUSD;
    private Double unit;
    private AssetStatus status;
}
