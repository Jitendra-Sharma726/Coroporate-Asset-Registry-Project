package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "corporate_assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;
    private String category;
    private Double purchaseValue;
    private String assignedTo;

    // Default Constructor (Required by JPA)
    public Asset() {
    }

    // Parameterized Constructor
    public Asset(String assetName, String category, Double purchaseValue, String assignedTo) {
        this.assetName = assetName;
        this.category = category;
        this.purchaseValue = purchaseValue;
        this.assignedTo = assignedTo;
    }

    // Getters and Setters
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getAssetName() { 
        return assetName; 
    }
    public void setAssetName(String assetName) { 
        this.assetName = assetName; 
    }

    public String getCategory() { 
        return category; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }

    public Double getPurchaseValue() { 
        return purchaseValue; 
    }
    public void setPurchaseValue(Double purchaseValue) { 
        this.purchaseValue = purchaseValue; 
    }

    public String getAssignedTo() { 
        return assignedTo; 
    }
    public void setAssignedTo(String assignedTo) { 
        this.assignedTo = assignedTo; 
    }
}


