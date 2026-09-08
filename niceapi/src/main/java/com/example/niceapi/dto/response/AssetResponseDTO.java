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
    private String name;
    private AssetType assetType;
    private Integer quantity;
    private Double purchasePrice;
    private Double currentValue;
    private String description;
    private AssetStatus status;
}
