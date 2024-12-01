package org.example.Lab3.Task5;

public class CarStation {
    private Queue<Car> queue;

    public CarStation(Queue<Car> queue) {
        this.queue = queue;
    }

    public void addCar(Car car) {
        if (!queue.isFull()) {
            queue.enqueue(car);
            System.out.println("🚗 Car [" + car.getCarId() + "] added to the station queue.");
        } else {
            System.out.println("⚠️ Station queue is full. Car [" + car.getCarId() + "] cannot be added.");
        }
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = (Car) queue.dequeue();

            Dineable diningService;
            if ("Human".equalsIgnoreCase(car.getPerson())) {
                diningService = new PeopleDinner();
                System.out.println("🍴 Directing Human from Car [" + car.getCarId() + "] to People Dinner.");
            } else if ("Robot".equalsIgnoreCase(car.getPerson())) {
                diningService = new RobotDinner();
                System.out.println("🤖 Directing Robot from Car [" + car.getCarId() + "] to Robot Dinner.");
            } else {
                System.out.println("❓ Unknown person type for Car [" + car.getCarId() + "]. Skipping.");
                continue;
            }

            if (car.isDining()) {
                diningService.serveDinner(car.getCarId());
            } else {
                System.out.println("🚗 Car [" + car.getCarId() + "] does not require dining service.");
            }
        }
    }
}
