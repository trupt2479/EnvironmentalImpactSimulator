package com.example.gui;

import com.example.models.Activity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * InputForm.java
 * Allows users to input environmental impact data via a form.
 */
public class InputForm extends JFrame {

    private JComboBox<String> categoryDropdown;
    private JTextField impactField;
    private JTextField waterField;
    private JTextField costField;

    private final Consumer<List<Activity>> onSubmit;

    // Predefined categories and names
    private static final String[] CATEGORIES = {"Transportation", "Energy", "Water Usage", "Diet"};
    private static final String[] NAMES = {"Car Travel", "Electricity Usage", "Water Consumption", "Meat-Based Meals"};

    private List<Activity> activities = new ArrayList<>();

    public InputForm(Consumer<List<Activity>> onSubmit) {
        this.onSubmit = onSubmit;

        setTitle("Environmental Impact Input Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Labels and components
        add(new JLabel("Select Category:"));
        categoryDropdown = new JComboBox<>(CATEGORIES);
        add(categoryDropdown);

        add(new JLabel("Impact Value (e.g., energy/carbon):"));
        impactField = new JTextField();
        add(impactField);

        add(new JLabel("Water Usage:"));
        waterField = new JTextField();
        add(waterField);

        add(new JLabel("Cost:"));
        costField = new JTextField();
        add(costField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this::handleSubmit);
        add(submitButton);

        JButton saveButton = new JButton("Save Activity");
        saveButton.addActionListener(this::handleSave);
        add(saveButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Handles the submit button click.
     */
    private void handleSubmit(ActionEvent e) {
        if (!activities.isEmpty()) {
            onSubmit.accept(activities);
            JOptionPane.showMessageDialog(this, "Activities submitted successfully!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No activities to submit. Please save first.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Handles saving an activity based on form input.
     */
    private void handleSave(ActionEvent e) {
        try {
            String category = (String) categoryDropdown.getSelectedItem();
            String name = getActivityNameForCategory(category);
            double impact = Double.parseDouble(impactField.getText());
            double water = Double.parseDouble(waterField.getText());
            double cost = Double.parseDouble(costField.getText());

            activities.add(new Activity(name, category, impact, water, cost));
            JOptionPane.showMessageDialog(this, "Activity saved: " + name);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numerical values for impact, water usage, and cost.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Clears input fields after saving an activity.
     */
    private void clearFields() {
        impactField.setText("");
        waterField.setText("");
        costField.setText("");
    }

    /**
     * Returns the activity name corresponding to the selected category.
     */
    private String getActivityNameForCategory(String category) {
        switch (category) {
            case "Transportation": return NAMES[0];
            case "Energy": return NAMES[1];
            case "Water Usage": return NAMES[2];
            case "Diet": return NAMES[3];
            default: return "Unknown Activity";
        }
    }
}
