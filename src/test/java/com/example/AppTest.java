package com.example;

import static org.junit.jupiter.api.Assertions.*;

import com.example.models.Activity;
import com.example.models.ImpactCalculator;
import com.example.utils.ValidationUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the Environmental Impact Simulator application.
 */
public class AppTest {

    /**
     * Test to verify that ValidationUtils correctly identifies non-empty strings.
     */
    @Test
    public void testIsNotNullOrEmpty() {
        assertTrue(ValidationUtils.isNotNullOrEmpty("Hello World"), "String should not be null or empty");
        assertFalse(ValidationUtils.isNotNullOrEmpty(""), "Empty string should return false");
        assertFalse(ValidationUtils.isNotNullOrEmpty(null), "Null input should return false");
    }

    /**
     * Test to verify that ValidationUtils validates email format correctly.
     */
    @Test
    public void testIsValidEmail() {
        assertTrue(ValidationUtils.isValidEmail("user@example.com"), "Valid email should return true");
        assertFalse(ValidationUtils.isValidEmail("userexample.com"), "Invalid email format should return false");
        assertFalse(ValidationUtils.isValidEmail(""), "Empty email should return false");
    }

    /**
     * Test to verify that ValidationUtils checks numeric inputs.
     */
    @Test
    public void testIsNumeric() {
        assertTrue(ValidationUtils.isNumeric("123"), "Integer input should be numeric");
        assertTrue(ValidationUtils.isNumeric("123.45"), "Decimal input should be numeric");
        assertFalse(ValidationUtils.isNumeric("ABC123"), "Alphanumeric input should not be numeric");
    }

    /**
     * Test for Activity class constructor and getters.
     */
    @Test
    public void testActivityCreation() {
        Activity activity = new Activity("Driving", 100.0, 50.0, 200.0, 300.0);
        assertEquals("Driving", activity.getName(), "Activity name should match input");
        assertEquals(100.0, activity.getEnergyUsage(), "Energy usage should match input");
        assertEquals(50.0, activity.getCarbonEmission(), "Carbon emission should match input");
        assertEquals(200.0, activity.getWaterUsage(), "Water usage should match input");
        assertEquals(300.0, activity.getCost(), "Cost should match input");
    }

    /**
     * Test to verify ImpactCalculator calculates total environmental impact correctly.
     */
    @Test
    public void testImpactCalculator() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Driving", 100.0, 50.0, 200.0, 300.0));
        activities.add(new Activity("Laundry", 50.0, 20.0, 250.0, 100.0));
        activities.add(new Activity("Cooking", 30.0, 15.0, 100.0, 50.0));

        double totalEnergyUsage = ImpactCalculator.calculateTotalEnergyUsage(activities);
        double totalCarbonEmissions = ImpactCalculator.calculateTotalCarbonEmissions(activities);
        double totalWaterUsage = ImpactCalculator.calculateTotalWaterUsage(activities);
        double totalCost = ImpactCalculator.calculateTotalCost(activities);

        assertEquals(180.0, totalEnergyUsage, "Total energy usage should be the sum of individual activities");
        assertEquals(85.0, totalCarbonEmissions, "Total carbon emissions should be the sum of individual activities");
        assertEquals(550.0, totalWaterUsage, "Total water usage should be the sum of individual activities");
        assertEquals(450.0, totalCost, "Total cost should be the sum of individual activities");
    }

    /**
     * Test to ensure ValidationUtils identifies alphanumeric strings.
     */
    @Test
    public void testIsAlphaNumeric() {
        assertTrue(ValidationUtils.isAlphaNumeric("Activity123"), "Alphanumeric string should return true");
        assertFalse(ValidationUtils.isAlphaNumeric("Activity@123"), "String with special characters should return false");
    }
}
