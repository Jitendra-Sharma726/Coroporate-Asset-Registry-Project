package com.example.demo.service;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository repository;

    // Constructor Injection for the Repository
    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    // 1. CREATE: Save a new asset
    public Asset addAsset(Asset asset) {
        return repository.save(asset);
    }

    // 2. READ: Get all assets
    public List<Asset> getAllAssets() {
        return repository.findAll();
    }

    // 3. READ: Get a single asset by ID
    public Asset getAssetById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 4. READ: Get assets by Category (Using Derived Query)
    public List<Asset> getAssetsByCategory(String category) {
        return repository.findByCategory(category);
    }

    // 5. UPDATE: Modify an existing asset
    public Asset updateAsset(Long id, Asset assetDetails) {
        // Find the existing asset
        Asset existingAsset = repository.findById(id).orElse(null);

        if (existingAsset != null) {
            // Update the fields with new data
            existingAsset.setAssetName(assetDetails.getAssetName());
            existingAsset.setCategory(assetDetails.getCategory());
            existingAsset.setPurchaseValue(assetDetails.getPurchaseValue());
            existingAsset.setAssignedTo(assetDetails.getAssignedTo());

            // Save the updated entity back to the database
            return repository.save(existingAsset);
        }

        // Handle error (e.g., Asset not found)
        return null;
    }

    // 6. DELETE: Remove an asset
    public String deleteAsset(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Asset with ID " + id + " has been successfully deleted.";
        } else {
            return "Asset with ID " + id + " not found.";
        }
    }
}


