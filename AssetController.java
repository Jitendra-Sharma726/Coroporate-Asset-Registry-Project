package com.example.demo.controller;

import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssetController {

    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    // POST: Add a new asset
    @PostMapping("/add")
    public Asset addAsset(@RequestBody Asset asset) {
        return service.addAsset(asset);
    }

    // GET: Retrieve all assets
    @GetMapping("/all")
    public List<Asset> getAllAssets() {
        return service.getAllAssets();
    }

    // GET: Retrieve asset by ID
    @GetMapping("/{id}")
    public Asset getAssetById(@PathVariable Long id) {
        return service.getAssetById(id);
    }

    // GET: Retrieve assets by category
    @GetMapping("/category/{category}")
    public List<Asset> getAssetsByCategory(@PathVariable String category) {
        return service.getAssetsByCategory(category);
    }

    // PUT: Update an existing asset
    @PutMapping("/update/{id}")
    public Asset updateAsset(@PathVariable Long id, @RequestBody Asset assetDetails) {
        return service.updateAsset(id, assetDetails);
    }

    // DELETE: Remove an asset
    @DeleteMapping("/delete/{id}")
    public String deleteAsset(@PathVariable Long id) {
        return service.deleteAsset(id);
    }
}


