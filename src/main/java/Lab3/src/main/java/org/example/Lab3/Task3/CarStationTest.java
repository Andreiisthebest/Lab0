package org.example.Lab3.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarStationTest {

    private CarStation carStation;
    private CircularQueue<Car> carQueue;

    @BeforeEach
    void setUp() {
        carQueue = new CircularQueue<>();
        carStation = new CarStation(carQueue);
    }

    @Test
    void testAddCarToQueue() {
        Car car1 = new Car("C1", "Electric", "Human", true);
        carStation.addCar(car1);

        assertFalse(carQueue.isEmpty(), "Queue should not be empty after adding a car");
    }

    @Test
    void testAddCarToFullQueue() {
        for (int i = 1; i <= 5; i++) {
            carStation.addCar(new Car("C" + i, "Gas", "Human", false));
        }
        assertTrue(carQueue.isFull(), "Queue should be full after adding 5 cars");

        carStation.addCar(new Car("C6", "Electric", "Robot", true));
        assertTrue(carQueue.isFull(), "Queue should remain full after attempting to add more cars");
    }

    @Test
    void testServeCars() {
        carStation.addCar(new Car("C1", "Electric", "Human", true));
        carStation.addCar(new Car("C2", "Gas", "Robot", false));

        carStation.serveCars();

        assertEquals(1, carStation.electricStationCustomers, "Electric station customer count should be 1");
        assertEquals(1, carStation.gasStationCustomers, "Gas station customer count should be 1");
        assertEquals(1, carStation.humanCustomersServed, "Human customer count should be 1");
        assertEquals(1, carStation.robotCustomersServed, "Robot customer count should be 1");
        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }

    @Test
    void testServeCarsWithoutDining() {
        carStation.addCar(new Car("C1", "Gas", "Robot", false));
        carStation.serveCars();

        assertEquals(1, carStation.gasStationCustomers, "Gas station customer count should be 1");
        assertEquals(1, carStation.robotCustomersServed, "Robot customer count should be 1");
        assertEquals(0, carStation.humanCustomersServed, "Human customer count should be 0");
        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving the car");
    }

    @Test
    void testServeMixedCars() {
        carStation.addCar(new Car("C1", "Electric", "Human", true));
        carStation.addCar(new Car("C2", "Gas", "Robot", false));
        carStation.addCar(new Car("C3", "Gas", "Human", true));

        carStation.serveCars();

        assertEquals(1, carStation.electricStationCustomers, "Electric station customer count should be 1");
        assertEquals(2, carStation.gasStationCustomers, "Gas station customer count should be 2");
        assertEquals(2, carStation.humanCustomersServed, "Human customer count should be 2");
        assertEquals(1, carStation.robotCustomersServed, "Robot customer count should be 1");
        assertTrue(carQueue.isEmpty(), "Queue should be empty after serving all cars");
    }
}
