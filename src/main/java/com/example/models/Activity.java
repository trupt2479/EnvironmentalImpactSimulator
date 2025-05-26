package com.example.models;

import java.io.Serializable;

public class Activity implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure compatibility

    private String name;
    private String category;
    private double impactValue; // Energy/Carbon impact
    private double waterUsage;  // Water usage
    private double cost;        // Cost

    public Activity(String name, String category, double impactValue, double waterUsage, double cost) {
        this.name = name;
        this.category = category;
        this.impactValue = impactValue;
        this.waterUsage = waterUsage;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getImpactValue() {
        return impactValue;
    }

    public double getWaterUsage() {
        return waterUsage;
    }

    public double getCost() {
        return cost;
    }
}
