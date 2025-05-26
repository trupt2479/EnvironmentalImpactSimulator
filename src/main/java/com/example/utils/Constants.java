package com.example.utils;

/**
 * Constants class holds all the static final values used in the project.
 * This ensures a single source of truth for configuration values and keys.
 */
public class Constants {

    // Application Configuration
    public static final String APP_NAME = "Environmental Impact Simulator";
    public static final String APP_VERSION = "1.0.0";

    // File Storage
    public static final String DATA_FILE_NAME = "data.ser";
    public static final String LOG_FILE_NAME = "application.log";

    // Database Configuration
    public static final String DATABASE_URL = "jdbc:sqlite:environmental_impact.db";
    public static final String DATABASE_DRIVER = "org.sqlite.JDBC";

    // User Interface Strings
    public static final String WELCOME_MESSAGE = "Welcome to the Environmental Impact Simulator!";
    public static final String INPUT_PROMPT = "Please enter activity details:";
    public static final String SAVE_SUCCESS = "Data saved successfully!";
    public static final String LOAD_SUCCESS = "Data loaded successfully!";
    public static final String ERROR_LOADING_FILE = "Error: Unable to load the file.";
    public static final String ERROR_SAVING_FILE = "Error: Unable to save the file.";
    public static final String INVALID_INPUT = "Invalid input. Please try again.";

    // Environmental Metrics Defaults
    public static final double DEFAULT_ENERGY_USAGE = 0.0;
    public static final double DEFAULT_CARBON_EMISSION = 0.0;
    public static final double DEFAULT_WATER_USAGE = 0.0;
    public static final double DEFAULT_COST = 0.0;

    // Error Messages
    public static final String DATABASE_CONNECTION_ERROR = "Error: Could not establish database connection.";
    public static final String INVALID_ACTIVITY = "Invalid activity data provided.";
    public static final String UNEXPECTED_ERROR = "An unexpected error occurred.";

    // Log Tags
    public static final String LOG_TAG_DATABASE = "[DATABASE]";
    public static final String LOG_TAG_FILE = "[FILE]";
    public static final String LOG_TAG_UI = "[UI]";
    public static final String LOG_TAG_SYSTEM = "[SYSTEM]";

    /**
     * Private constructor to prevent instantiation of the Constants class.
     */
    private Constants() {
        // Prevent instantiation
    }
}
