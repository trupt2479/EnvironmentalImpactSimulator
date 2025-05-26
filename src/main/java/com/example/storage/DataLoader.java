package com.example.storage;

import com.example.models.Activity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DataLoader.java
 * Handles file-based storage for environmental activity data.
 */
public class DataLoader {

    private static final String DEFAULT_FILE_PATH = "environmental_impact_data.ser";

    /**
     * Saves a list of activities to a file.
     *
     * @param activities The list of Activity objects to save.
     */
    public static void saveToFile(List<Activity> activities) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DEFAULT_FILE_PATH))) {
            oos.writeObject(activities);
            System.out.println("Activities saved successfully to file: " + DEFAULT_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Failed to save activities to file: " + e.getMessage());
        }
    }

    /**
     * Loads activities from a file.
     *
     * @return A list of Activity objects retrieved from the file.
     */
    @SuppressWarnings("unchecked")
    public static List<Activity> loadFromFile() {
        List<Activity> activities = new ArrayList<>();

        File file = new File(DEFAULT_FILE_PATH);
        if (!file.exists()) {
            System.out.println("No existing file found. Returning an empty list.");
            return activities; // Return empty list if file does not exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEFAULT_FILE_PATH))) {
            activities = (List<Activity>) ois.readObject();
            System.out.println("Activities loaded successfully from file: " + DEFAULT_FILE_PATH);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load activities from file: " + e.getMessage());
        }

        return activities;
    }

    /**
     * Test method for saving and loading activities.
     */
    public static void main(String[] args) {
        // Example activities to save
        List<Activity> activitiesToSave = List.of(
                new Activity("Car Travel", "Transportation", 120.0, 0.0, 0.0),
                new Activity("Electricity Usage", "Energy", 200.0, 0.0, 50.0),
                new Activity("Water Consumption", "Water", 0.0, 60.0, 0.0),
                new Activity("Monthly Bill", "Cost", 0.0, 0.0, 150.0)
        );

        // Save activities to file
        saveToFile(activitiesToSave);

        // Load activities from file
        List<Activity> loadedActivities = loadFromFile();

        // Display loaded activities
        for (Activity activity : loadedActivities) {
            System.out.println(activity);
        }
    }
}
