package com.example.demo.repository;

import com.example.demo.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    // Custom Derived Query: Find assets by their category
    // Spring automatically generates SQL like: SELECT * FROM corporate_assets WHERE category = ?
    List<Asset> findByCategory(String category);
}


