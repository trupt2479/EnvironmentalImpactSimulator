package com.example.utils;

import java.io.File;

public class ValidationUtils {

    public static boolean isNotNullOrEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidFilePath(String path) {
        return path != null && new File(path).isFile();
    }

    public static boolean isNumeric(String input) {
        return input.matches("\\d+(\\.\\d+)?");
    }
}
