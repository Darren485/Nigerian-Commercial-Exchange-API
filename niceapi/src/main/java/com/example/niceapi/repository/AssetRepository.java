package com.example.niceapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.niceapi.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {

}
