package com.example.niceapi.service;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.niceapi.dto.request.AssetRequestDTO;
import com.example.niceapi.dto.response.AssetResponseDTO;
import com.example.niceapi.model.Asset;
import com.example.niceapi.repository.AssetRepository;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<AssetResponseDTO> getAllAssests() {
        return assetRepository.findAll().stream()
                .map(asset -> new AssetResponseDTO(
                        asset.getId(),
                        asset.getAssetName(),
                        asset.getAssetType(),
                        asset.getQuantity(),
                        asset.getCurrentValueNGN(),
                        asset.getCurrentValueUSD(),
                        asset.getUnit(),
                        asset.getStatus()))
                .collect(Collectors.toList());
    }

    public Optional<AssetResponseDTO> getAssestById(Long id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        return Optional.of(new AssetResponseDTO(
                asset.getId(),
                asset.getAssetName(),
                asset.getAssetType(),
                asset.getQuantity(),
                asset.getCurrentValueNGN(),
                asset.getCurrentValueUSD(),
                asset.getUnit(),
                asset.getStatus()));
    }

    public AssetResponseDTO addAsset(AssetRequestDTO requestDTO) {
        Asset asset = new Asset();
        asset.setAssetName(requestDTO.getAssetName());
        asset.setAssetType(requestDTO.getAssetType());
        asset.setQuantity(requestDTO.getQuantity());
        asset.setCurrentValueNGN(requestDTO.getCurrentValueNGN());
        asset.setCurrentValueUSD(requestDTO.getCurrentValueUSD());
        asset.setUnit(requestDTO.getUnit());
        asset.setStatus(requestDTO.getAssetStatus());
        assetRepository.save(asset);
        return new AssetResponseDTO(
                asset.getId(),
                asset.getAssetName(),
                asset.getAssetType(),
                asset.getQuantity(),
                asset.getCurrentValueNGN(),
                asset.getCurrentValueUSD(),
                asset.getUnit(),
                asset.getStatus());
    }

    public AssetResponseDTO updateAsset(Long id, AssetRequestDTO requestDTO) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        asset.setAssetName(requestDTO.getAssetName());
        asset.setAssetType(requestDTO.getAssetType());
        asset.setQuantity(requestDTO.getQuantity());
        asset.setCurrentValueNGN(requestDTO.getCurrentValueNGN());
        asset.setCurrentValueUSD(requestDTO.getCurrentValueUSD());
        asset.setUnit(requestDTO.getUnit());
        asset.setStatus(requestDTO.getAssetStatus());
        assetRepository.save(asset);
        return new AssetResponseDTO(
                asset.getId(),
                asset.getAssetName(),
                asset.getAssetType(),
                asset.getQuantity(),
                asset.getCurrentValueNGN(),
                asset.getCurrentValueUSD(),
                asset.getUnit(),
                asset.getStatus());
    }

    public void deleteAsset(Long id){
        if(!assetRepository.existsById(id)){
            throw new RuntimeException("Asset not found with id: " + id);
        }
        assetRepository.deleteById(id);
    }

    public List<AssetResponseDTO> filterByType(String query){
        List<Asset> assets = assetRepository.findByAssetType(query);
        if(assets.isEmpty()){
            throw new RuntimeException("No assets found for type: " + query);
        }
        return assets.stream()
            .map(m -> new AssetResponseDTO(
                m.getId(),
                m.getAssetName(),
                m.getAssetType(),
                m.getQuantity(),
                m.getCurrentValueNGN(),
                m.getCurrentValueUSD(),
                m.getUnit(),
                m.getStatus()))
            .collect(Collectors.toList());
    }
}
