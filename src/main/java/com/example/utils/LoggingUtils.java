package com.example.utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LoggingUtils provides logging functionality.
 */
public class LoggingUtils {

    private static final String LOG_FILE = "application.log";
    private static final String ERROR_LOG_FILE = "error.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logInfo(String tag, String message) {
        log("INFO", tag, message, LOG_FILE);
    }

    public static void logError(String tag, String message) {
        log("ERROR", tag, message, ERROR_LOG_FILE);
    }

    private static void log(String level, String tag, String message, String fileName) {
        String logEntry = String.format("[%s] [%s] %s: %s", LocalDateTime.now().format(FORMATTER), level, tag, message);

        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(logEntry + "\n");
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}
