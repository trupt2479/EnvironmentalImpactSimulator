package com.example.main;

import com.example.gui.ChartView;
import com.example.gui.InputForm;
import com.example.gui.ResultsView;
import com.example.models.Activity;
import com.example.models.ImpactCalculator;
import com.example.models.RecommendationEngine;

import javax.swing.*;
import java.util.List;

/**
 * Main.java
 * Entry point for the Environmental Impact Simulator.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null,
                    "Welcome to the Environmental Impact Simulator!",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE);

            // Start input form
            new InputForm(Main::processInputData);
        });
    }

    /**
     * Processes the input data and visualizes results.
     *
     * @param activities List of user-provided activities.
     */
    private static void processInputData(List<Activity> activities) {
        // Calculate total values
        double totalEnergy = ImpactCalculator.calculateTotalEnergyUsage(activities);
        double totalCarbon = ImpactCalculator.calculateTotalCarbonEmissions(activities);
        double totalWater = ImpactCalculator.calculateTotalWaterUsage(activities);
        double totalCost = ImpactCalculator.calculateTotalCost(activities);

        // Display totals in terminal
        System.out.println("=== Environmental Impact Totals ===");
        System.out.printf("Total Energy Usage: %.2f%n", totalEnergy);
        System.out.printf("Total Carbon Emissions: %.2f%n", totalCarbon);
        System.out.printf("Total Water Usage: %.2f%n", totalWater);
        System.out.printf("Total Cost: %.2f%n", totalCost);

        // Prepare data for ResultsView
        String[] columnNames = {"Activity", "Category", "Impact Value", "Water Usage", "Cost"};
        Object[][] tableData = new Object[activities.size()][5];
        for (int i = 0; i < activities.size(); i++) {
            Activity a = activities.get(i);
            tableData[i] = new Object[]{a.getName(), a.getCategory(), a.getImpactValue(), a.getWaterUsage(), a.getCost()};
        }

        // Show results table
        new ResultsView(columnNames, tableData, RecommendationEngine.generateRecommendations(activities));

        // Prepare data for ChartView
        List<Double> chartData = List.of(totalEnergy, totalCarbon, totalWater, totalCost);
        List<String> chartLabels = List.of("Energy", "Carbon", "Water", "Cost");

        // Show visual chart
        new ChartView("Environmental Impact Chart", chartData, chartLabels);
    }
}
