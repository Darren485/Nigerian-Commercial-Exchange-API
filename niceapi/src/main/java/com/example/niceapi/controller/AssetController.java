package com.example.niceapi.controller;

import com.example.niceapi.dto.request.AssetRequestDTO;
import com.example.niceapi.model.AssetType;
import com.example.niceapi.service.AssetService;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/assets")
@RestController
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAssets() {
        return ResponseEntity.ok(service.getAllAssests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAssetById(@PathVariable Long id) {
        return service.getAssestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createNewAsset(@RequestBody AssetRequestDTO request) {
        return ResponseEntity.status(201).body(service.addAsset(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAsset(@PathVariable Long id, @RequestBody AssetRequestDTO request) {
        return ResponseEntity.ok(service.updateAsset(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsset(@PathVariable Long id) {
        service.deleteAsset(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchAssets(@RequestParam AssetType query) {
        return ResponseEntity.ok(service.filterByType(query));
    }
}
