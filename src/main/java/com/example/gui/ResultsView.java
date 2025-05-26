package com.example.gui;

import javax.swing.*;
import java.awt.*;

/**
 * ResultsView.java
 * Displays environmental impact results and recommendations in a tabular format.
 */
public class ResultsView extends JFrame {

    /**
     * Constructor to display results in a table.
     *
     * @param columnNames Array of column headers for the table.
     * @param data        2D Object array containing table data.
     * @param recommendations List of recommendations to display.
     */
    public ResultsView(String[] columnNames, Object[][] data, java.util.List<String> recommendations) {
        setTitle("Environmental Impact Results");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        GUIUtils.centerFrame(this);

        // Table for results
        JTable resultsTable = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(resultsTable);
        resultsTable.setFillsViewportHeight(true);

        // Recommendations panel
        JPanel recommendationsPanel = new JPanel();
        recommendationsPanel.setLayout(new BoxLayout(recommendationsPanel, BoxLayout.Y_AXIS));
        JLabel headerLabel = GUIUtils.createLabel("Recommendations", 16);
        recommendationsPanel.add(headerLabel);

        // Add each recommendation as a label
        if (recommendations.isEmpty()) {
            recommendationsPanel.add(GUIUtils.createLabel("Great job! Your environmental impact is minimal.", 14));
        } else {
            for (String rec : recommendations) {
                JLabel recommendationLabel = GUIUtils.createLabel("• " + rec, 14);
                recommendationsPanel.add(recommendationLabel);
            }
        }

        // Add components to the frame
        add(GUIUtils.createHeaderLabel("Environmental Impact Breakdown"), BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
        add(recommendationsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Main method for testing the ResultsView.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] columnNames = {"Activity", "Category", "Impact Value (kg CO₂)"};
            Object[][] data = {
                {"Car Miles Driven", "Transportation", 20.0},
                {"Electricity Usage", "Energy", 100.0},
                {"Meat-Based Meals", "Diet", 30.0}
            };

            java.util.List<String> recommendations = java.util.List.of(
                "Try carpooling or using public transport for shorter trips.",
                "Consider switching to energy-efficient appliances.",
                "Reduce meat-based meals to lower your carbon footprint."
            );

            new ResultsView(columnNames, data, recommendations);
        });
    }
}
