package com.example.models;

import java.util.List;

public class ImpactCalculator {

    /**
     * Calculate total energy usage.
     */
    public static double calculateTotalEnergyUsage(List<Activity> activities) {
        return activities.stream()
                .filter(a -> "Energy".equalsIgnoreCase(a.getCategory()))
                .mapToDouble(Activity::getImpactValue)
                .sum();
    }

    /**
     * Calculate total carbon emissions.
     */
    public static double calculateTotalCarbonEmissions(List<Activity> activities) {
        return activities.stream()
                .filter(a -> "Transportation".equalsIgnoreCase(a.getCategory()) || "Diet".equalsIgnoreCase(a.getCategory()))
                .mapToDouble(Activity::getImpactValue)
                .sum();
    }

    /**
     * Calculate total water usage.
     */
    public static double calculateTotalWaterUsage(List<Activity> activities) {
        return activities.stream()
                .mapToDouble(Activity::getWaterUsage)
                .sum();
    }

    /**
     * Calculate total cost.
     */
    public static double calculateTotalCost(List<Activity> activities) {
        return activities.stream()
                .mapToDouble(Activity::getCost)
                .sum();
    }
}
