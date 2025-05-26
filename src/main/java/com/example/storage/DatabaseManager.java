package com.example.storage;

import com.example.models.Activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseManager.java
 * Handles database operations for storing and retrieving environmental activities.
 */
public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:environmental_impact.db";
    private static final String TABLE_NAME = "activities";

    /**
     * Initializes the database and creates the activities table if it does not exist.
     */
    public static void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "impact_value REAL, "
                + "water_usage REAL, "
                + "cost REAL"
                + ");";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Database initialized successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
        }
    }

    /**
     * Saves a list of activities to the database.
     *
     * @param activities List of Activity objects to save.
     */
    public static void saveActivities(List<Activity> activities) {
        String insertSQL = "INSERT INTO " + TABLE_NAME + " (name, category, impact_value, water_usage, cost) "
                + "VALUES (?, ?, ?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            for (Activity activity : activities) {
                pstmt.setString(1, activity.getName());
                pstmt.setString(2, activity.getCategory());
                pstmt.setDouble(3, activity.getImpactValue());
                pstmt.setDouble(4, activity.getWaterUsage());
                pstmt.setDouble(5, activity.getCost());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            System.out.println("Activities saved to database successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to save activities: " + e.getMessage());
        }
    }

    /**
     * Loads all activities from the database.
     *
     * @return A list of Activity objects retrieved from the database.
     */
    public static List<Activity> loadActivities() {
        List<Activity> activities = new ArrayList<>();
        String selectSQL = "SELECT name, category, impact_value, water_usage, cost FROM " + TABLE_NAME + ";";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String category = rs.getString("category");
                double impactValue = rs.getDouble("impact_value");
                double waterUsage = rs.getDouble("water_usage");
                double cost = rs.getDouble("cost");

                activities.add(new Activity(name, category, impactValue, waterUsage, cost));
            }
            System.out.println("Activities loaded from database successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to load activities: " + e.getMessage());
        }

        return activities;
    }

    /**
     * Deletes all activities from the database.
     */
    public static void clearDatabase() {
        String deleteSQL = "DELETE FROM " + TABLE_NAME + ";";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(deleteSQL);
            System.out.println("All activities have been cleared from the database.");
        } catch (SQLException e) {
            System.err.println("Failed to clear database: " + e.getMessage());
        }
    }

    /**
     * Main method for testing database operations.
     */
    public static void main(String[] args) {
        // Initialize database
        initializeDatabase();

        // Example activities to test save and load
        List<Activity> activities = List.of(
                new Activity("Car Travel", "Transportation", 120.0, 0.0, 0.0),
                new Activity("Electricity Usage", "Energy", 200.0, 0.0, 50.0),
                new Activity("Water Consumption", "Water", 0.0, 60.0, 0.0),
                new Activity("Monthly Bill", "Cost", 0.0, 0.0, 150.0)
        );

        // Save activities
        saveActivities(activities);

        // Load activities
        List<Activity> loadedActivities = loadActivities();
        for (Activity activity : loadedActivities) {
            System.out.println(activity);
        }

        // Clear database (for testing)
        clearDatabase();
    }
}
