package org.example.Lab3.Task3;

import java.util.Objects;

public class CarStation {
    private Queue<Car> queue;

    // Tracking counts
    int electricStationCustomers = 0;
    int gasStationCustomers = 0;
    int humanCustomersServed = 0;
    int robotCustomersServed = 0;

    public CarStation(Queue<Car> queue) {
        this.queue = queue;
    }

    public void addCar(Car car) {
        if (!queue.isFull()) {
            queue.enqueue(car);
        } else {
            System.out.println("Queue is full.");
        }
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = (Car) queue.dequeue();

            Refuelable refuelingService;
            if (Objects.equals(car.getCarType(), "Electric")) {
                refuelingService = new ElectricStation();
                electricStationCustomers++;
            } else {
                refuelingService = new GasStation();
                gasStationCustomers++;
            }

            Dineable diningService;
            if (Objects.equals(car.getPerson(), "Human")) {
                diningService = new PeopleDinner();
                humanCustomersServed++;
            } else {
                diningService = new RobotDinner();
                robotCustomersServed++;
            }

            if (car.isDining()) {
                diningService.serveDinner(car.getCarId());
            } else System.out.println("Does not want to dine.");


            refuelingService.refuel(car.getCarId());

        }
    }

}
