package com.example.models;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RecommendationEngine.java
 * Provides recommendations based on environmental impact activities and categories.
 */
public class RecommendationEngine {

    /**
     * Generates recommendations for reducing environmental impact.
     *
     * @param activities List of Activity objects.
     * @return A list of recommendation strings.
     */
    public static List<String> generateRecommendations(List<Activity> activities) {
        return activities.stream()
                .map(activity -> {
                    String category = activity.getCategory();
                    double impactValue = activity.getImpactValue();
                    double waterUsage = activity.getWaterUsage();
                    double cost = activity.getCost();
                    return createRecommendation(category, impactValue, waterUsage, cost);
                })
                .filter(recommendation -> !recommendation.isEmpty()) // Exclude empty recommendations
                .collect(Collectors.toList());
    }

    /**
     * Creates a specific recommendation based on the activity category, impact, water usage, and cost.
     *
     * @param category    The category of the activity (e.g., Energy, Transportation, Diet, Water).
     * @param impactValue The impact value of the activity (e.g., Carbon Emissions).
     * @param waterUsage  The water usage of the activity.
     * @param cost        The cost associated with the activity.
     * @return A recommendation string.
     */
    private static String createRecommendation(String category, double impactValue, double waterUsage, double cost) {
        switch (category.toLowerCase()) {
            case "energy":
                if (impactValue > 150) {
                    return "For 'Energy': Use energy-efficient appliances or switch to renewable energy sources to lower energy consumption.";
                }
                break;

            case "transportation":
                if (impactValue > 100) {
                    return "For 'Transportation': Try carpooling, using public transport, biking, or walking to reduce your emissions.";
                }
                break;

            case "diet":
                if (impactValue > 50) {
                    return "For 'Diet': Opt for plant-based meals occasionally to reduce your dietary carbon footprint.";
                }
                break;

            case "water":
                if (waterUsage > 50) {
                    return "For 'Water Usage': Reduce water consumption by fixing leaks, taking shorter showers, or using efficient fixtures.";
                }
                break;

            case "cost":
                if (cost > 100) {
                    return "For 'Cost': Look for ways to reduce expenses, like cutting down on unnecessary energy or water usage.";
                }
                break;

            default:
                return ""; // No recommendation for unknown categories
        }
        return ""; // No recommendation if thresholds are not met
    }

    /**
     * Displays the generated recommendations in the console.
     *
     * @param activities List of Activity objects.
     */
    public static void displayRecommendations(List<Activity> activities) {
        System.out.println("Recommendations for Reducing Environmental Impact:");
        System.out.println("-------------------------------------------------");

        List<String> recommendations = generateRecommendations(activities);

        if (recommendations.isEmpty()) {
            System.out.println("Great job! Your environmental impact is already minimal.");
        } else {
            recommendations.forEach(System.out::println);
        }

        System.out.println("-------------------------------------------------");
    }

    /**
     * Main method for testing the RecommendationEngine.
     */
    public static void main(String[] args) {
        // Example activities
        List<Activity> activities = List.of(
                new Activity("Car Travel", "Transportation", 120.0, 0.0, 0.0),
                new Activity("Electricity Usage", "Energy", 200.0, 0.0, 0.0),
                new Activity("Water Consumption", "Water", 0.0, 60.0, 0.0),
                new Activity("Monthly Bill", "Cost", 0.0, 0.0, 150.0),
                new Activity("Dietary Choice", "Diet", 55.0, 0.0, 0.0)
        );

        // Display recommendations based on activities
        displayRecommendations(activities);
    }
}
