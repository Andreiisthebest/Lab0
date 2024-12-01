package org.example.Lab3.Task5;

public class ElectricStation implements Refuelable {
    private final CircularQueue<Car> carQueue = new CircularQueue<>(8);
    private final CircularQueue<Car> waitingCars = new CircularQueue<>(20);
    private int servedCount = 0;

    private final PeopleDinner peopleDinner = new PeopleDinner();
    private final RobotDinner robotDinner = new RobotDinner();

    public void addCarToQueue(Car car) {
        if (!carQueue.isFull()) {
            carQueue.enqueue(car);
            System.out.println("🔋 Car [" + car.getCarId() + "] added to the charging queue.");
        } else {
            waitingCars.enqueue(car);
            System.out.println("⚠️ Queue full! Car [" + car.getCarId() + "] added to the waiting list.");
        }
    }

    public void processCars() {
        while (!carQueue.isEmpty() || !waitingCars.isEmpty()) {
            if (!carQueue.isEmpty()) {
                Car car = carQueue.dequeue();
                System.out.println("🔌 Charging Car [" + car.getCarId() + "]...");
                refuel(car.getCarId());
                servedCount++;
                System.out.println("✅ Charging complete! Total cars charged: " + servedCount);

                if (car.isDining()) {
                    if ("PEOPLE".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("🍴 Directing Car [" + car.getCarId() + "] to People Dinner.");
                        peopleDinner.serveDinner(car.getCarId());
                    } else if ("ROBOTS".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("🤖 Directing Car [" + car.getCarId() + "] to Robot Dinner.");
                        robotDinner.serveDinner(car.getCarId());
                    }
                } else {
                    System.out.println("🚗 Car [" + car.getCarId() + "] does not require dining services.\n");
                }
            }

            if (!carQueue.isFull() && !waitingCars.isEmpty()) {
                Car waitingCar = waitingCars.dequeue();
                carQueue.enqueue(waitingCar);
                System.out.println("📥 Moved Car [" + waitingCar.getCarId() + "] from the waiting list to the active queue.");
            }
        }
    }

    @Override
    public void refuel(String carId) {
        System.out.println("🔋 Car [" + carId + "] has been fully recharged.");
    }
}
