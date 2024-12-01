package org.example.Lab3.Task4;

public class GasStation implements Refuelable {
    private final CircularQueue<Car> carQueue = new CircularQueue<>(3);
    private final CircularQueue<Car> waitingCars = new CircularQueue<>(30);
    private int servedCount = 0;

    private final PeopleDinner peopleDinner = new PeopleDinner();
    private final RobotDinner robotDinner = new RobotDinner();

    public void addCarToQueue(Car car) {
        if (!carQueue.isFull()) {
            carQueue.enqueue(car);
            System.out.println("🚗 Car [" + car.getCarId() + "] added to the active refueling queue.");
        } else {
            waitingCars.enqueue(car);
            System.out.println("⚠️ Queue full! Car [" + car.getCarId() + "] added to the waiting list.");
        }
    }

    public void processCars() {
        while (!carQueue.isEmpty() || !waitingCars.isEmpty()) {
            if (!carQueue.isEmpty()) {
                Car car = (Car) carQueue.dequeue();
                System.out.println("⛽ Refueling Car [" + car.getCarId() + "]...");
                refuel(car.getCarId());
                servedCount++;
                System.out.println("✅ Refueled! Total cars served: " + servedCount);

                if (car.isDining()) {
                    if ("PEOPLE".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("🍴 Car [" + car.getCarId() + "] directed to People Dinner.");
                        peopleDinner.serveDinner(car.getCarId());
                    } else if ("ROBOTS".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("🤖 Car [" + car.getCarId() + "] directed to Robot Dinner.");
                        robotDinner.serveDinner(car.getCarId());
                    }
                } else {
                    System.out.println("🚗 Car [" + car.getCarId() + "] does not require dining service.");
                }
            }

            if (!carQueue.isFull() && !waitingCars.isEmpty()) {
                Car waitingCar = (Car) waitingCars.dequeue();
                carQueue.enqueue(waitingCar);
                System.out.println("📥 Moved Car [" + waitingCar.getCarId() + "] from waiting list to active queue.");
            }
        }
    }

    @Override
    public void refuel(String carId) {
        System.out.println("⛽ Car [" + carId + "] successfully refueled.");
    }
}
