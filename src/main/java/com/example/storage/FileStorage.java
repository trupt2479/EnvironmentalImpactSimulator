package com.example.storage;

import com.example.models.Activity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FileStorage.java
 * Handles saving and loading activities to/from a file.
 */
public class FileStorage {

    private static final String DEFAULT_FILE = "activities.dat";

    /**
     * Saves the list of activities to the default file.
     *
     * @param activities List of Activity objects to save.
     */
    public static void saveToDefaultFile(List<Activity> activities) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DEFAULT_FILE))) {
            oos.writeObject(activities);
            System.out.println("Activities saved successfully to " + DEFAULT_FILE);
        } catch (IOException e) {
            System.err.println("Error saving activities: " + e.getMessage());
        }
    }

    /**
     * Loads the list of activities from the default file.
     *
     * @return A list of Activity objects loaded from the file.
     */
    @SuppressWarnings("unchecked")
    public static List<Activity> loadFromDefaultFile() {
        File file = new File(DEFAULT_FILE);
        if (!file.exists()) {
            System.out.println("No saved activities found. Returning an empty list.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEFAULT_FILE))) {
            List<Activity> activities = (List<Activity>) ois.readObject();
            System.out.println("Activities loaded successfully from " + DEFAULT_FILE);
            return activities;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading activities: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
