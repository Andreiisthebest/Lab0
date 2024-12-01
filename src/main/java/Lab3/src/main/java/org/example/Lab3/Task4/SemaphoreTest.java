package org.example.Lab3.Task4;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SemaphoreTest {
    private ElectricStation electricStation;
    private GasStation gasStation;
    private Semaphore semaphore;

    @BeforeEach
    void setUp() {
        electricStation = new ElectricStation();
        gasStation = new GasStation();
        semaphore = new Semaphore(electricStation, gasStation);
    }

    @Test
    void testParseCarFromJsonString() {
        String mockJson1 = "{\"id\": 1, \"type\": \"ELECTRIC\", \"passengers\": \"PEOPLE\", \"isDining\": true}";
        String mockJson2 = "{\"id\": 2, \"type\": \"GAS\", \"passengers\": \"ROBOTS\", \"isDining\": false}";
        String mockJson3 = "{\"id\": 3, \"type\": \"ELECTRIC\", \"passengers\": \"UNKNOWN\", \"isDining\": true}";

        Car car1 = parseCarFromJsonString(mockJson1);
        Car car2 = parseCarFromJsonString(mockJson2);
        Car car3 = parseCarFromJsonString(mockJson3);

        assertNotNull(car1);
        assertEquals("CAR1", car1.getCarId());
        assertEquals("ELECTRIC", car1.getCarType());
        assertEquals("PEOPLE", car1.getPerson());
        assertTrue(car1.isDining());

        assertNotNull(car2);
        assertEquals("CAR2", car2.getCarId());
        assertEquals("GAS", car2.getCarType());
        assertEquals("ROBOTS", car2.getPerson());
        assertFalse(car2.isDining());

        assertNotNull(car3);
        assertEquals("CAR3", car3.getCarId());
        assertEquals("ELECTRIC", car3.getCarType());
        assertEquals("UNKNOWN", car3.getPerson());
        assertTrue(car3.isDining());
    }

    @Test
    void testGuideCarsToStations() {
        Car car1 = new Car("CAR1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("CAR2", "GAS", "ROBOTS", false);
        Car car3 = new Car("CAR3", "ELECTRIC", "ROBOTS", true);

        List<Car> cars = List.of(car1, car2, car3);

        semaphore.guideCars(cars);

        assertDoesNotThrow(electricStation::processCars);
        assertDoesNotThrow(gasStation::processCars);
    }

    @Test
    void testAllCarsProcessedByCorrectStations() {
        Car car1 = new Car("CAR1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("CAR2", "GAS", "ROBOTS", true);

        List<Car> cars = List.of(car1, car2);

        semaphore.guideCars(cars);

        assertDoesNotThrow(electricStation::processCars);
        assertDoesNotThrow(gasStation::processCars);
    }

    @Test
    void testEmptyCarList() {
        List<Car> cars = new ArrayList<>();
        semaphore.guideCars(cars);
        assertDoesNotThrow(electricStation::processCars);
        assertDoesNotThrow(gasStation::processCars);
    }

    @Test
    void testInvalidCarType() {
        String mockJson = "{\"id\": 4, \"type\": \"UNKNOWN\", \"passengers\": \"PEOPLE\", \"isDining\": true}";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            parseCarFromJsonString(mockJson);
        });

        assertEquals("Invalid car type: UNKNOWN", exception.getMessage());
    }

    @Test
    void testGuideLargeNumberOfCars() {
        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {
            String type = (i % 2 == 0) ? "ELECTRIC" : "GAS";
            String person = (i % 3 == 0) ? "ROBOTS" : "PEOPLE";
            cars.add(new Car("CAR" + i, type, person, i % 2 == 0));
        }

        semaphore.guideCars(cars);

        assertDoesNotThrow(electricStation::processCars);
        assertDoesNotThrow(gasStation::processCars);
    }

    private Car parseCarFromJsonString(String jsonString) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonCar = (JSONObject) parser.parse(jsonString);

            int id = Integer.parseInt(jsonCar.get("id").toString());
            String type = jsonCar.get("type").toString();
            String passengers = jsonCar.get("passengers").toString();
            boolean isDining = Boolean.parseBoolean(jsonCar.get("isDining").toString());

            if (!type.equalsIgnoreCase("ELECTRIC") && !type.equalsIgnoreCase("GAS")) {
                throw new IllegalArgumentException("Invalid car type: " + type);
            }

            return new Car("CAR" + id, type, passengers, isDining);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + jsonString, e);
        }
    }
}
