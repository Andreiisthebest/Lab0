package org.example.Lab3.Task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class DistributionTest {
    private Distribution distribution;
    private final Random random = new Random();

    @BeforeEach
    void setUp() {
        distribution = new Distribution();
    }

    @Test
    void testRandomDistribution() {
        // Number of vehicles to test
        final int numberOfVehicles = 20000;

        // Possible car types
        final String[] carTypes = {"gas", "electric", "other"};

        // Possible person types
        final String[] personTypes = {"person", "robot"};

        System.out.println("Starting Random Distribution Test");
        System.out.println("Total vehicles to process: " + numberOfVehicles);

        // Stress test with vehicles
        for (int vehicleIndex = 0; vehicleIndex < numberOfVehicles ; vehicleIndex++) {
            // Final variables for use in lambda
            final int carId = vehicleIndex;
            final String carType = carTypes[random.nextInt(carTypes.length)];
            final String personType = personTypes[random.nextInt(personTypes.length)];
            final boolean isDining = random.nextBoolean();

            // Print detailed information about each vehicle
            System.out.printf("Processing Vehicle #%d: Type=%s, Person=%s, Dining=%b%n",
                    carId, carType, personType, isDining);

            try {
                // Perform distribution
                distribution.distribution(carId, carType, personType, isDining);

                // Confirm successful processing
                System.out.printf("Vehicle #%d processed successfully%n", carId);
            } catch (Exception e) {
                // Fail the test if any exception occurs
                fail("Distribution failed for vehicle ID " + carId +
                        ". Error: " + e.getMessage());
            }

            // Optional: Add a small delay to make output more readable
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Random Distribution Test Completed");
    }

    @Test
    void testSpecificScenarios() {
        System.out.println("Starting Specific Scenarios Test");

        // Test scenarios
        final Object[][] testScenarios = {
                {1001, "gas", "person", true},     // gas, person, dining
                {1002, "electric", "robot", false}, // electric, robot, not dining
                {1003, "other", "person", true}     // other type, person, dining
        };

        for (Object[] scenario : testScenarios) {
            final int carId = (Integer) scenario[0];
            final String carType = (String) scenario[1];
            final String personType = (String) scenario[2];
            final boolean isDining = (Boolean) scenario[3];

            System.out.printf("Testing Scenario - Vehicle #%d: Type=%s, Person=%s, Dining=%b%n",
                    carId, carType, personType, isDining);

            try {
                distribution.distribution(carId, carType, personType, isDining);
                System.out.printf("Scenario for Vehicle #%d processed successfully%n", carId);
            } catch (Exception e) {
                fail("Distribution failed for vehicle ID " + carId +
                        ". Error: " + e.getMessage());
            }
        }

        System.out.println("Specific Scenarios Test Completed");
    }

    @Test
    void testEdgeCases() {
        System.out.println("Starting Edge Cases Test");

        // Edge case scenarios
        final Object[][] edgeCases = {
                {2000, null, null, false},
                {2001, "", "", true},
                {2002, "unknown", "unknown", true}
        };

        for (Object[] edgeCase : edgeCases) {
            final int carId = (int) edgeCase[0];
            final String carType = (String) edgeCase[1];
            final String personType = (String) edgeCase[2];
            final boolean isDining = (boolean) edgeCase[3];

            System.out.printf("Testing Edge Case - Vehicle #%d: Type=%s, Person=%s, Dining=%b%n",
                    carId, carType, personType, isDining);

            try {
                distribution.distribution(carId, carType, personType, isDining);
                System.out.printf("Edge case for Vehicle #%d processed successfully%n", carId);
            } catch (Exception e) {
                fail("Distribution failed for vehicle ID " + carId +
                        ". Error: " + e.getMessage());
            }
        }

        System.out.println("Edge Cases Test Completed");
    }
}