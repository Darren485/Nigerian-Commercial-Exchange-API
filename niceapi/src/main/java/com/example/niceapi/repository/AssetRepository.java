package com.example.niceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.niceapi.model.Asset;
import com.example.niceapi.model.AssetType;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    List<Asset> findByAssetType(AssetType assetType);

}
