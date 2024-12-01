package org.example.Lab3.Task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        String resourcesFolderPath = "C:\\Users\\andre\\Desktop\\Labs OOP\\Lab0\\src\\main\\java\\Lab3\\src\\main\\resources\\JSON";
        List<Car> cars = semaphore.parseCarsFromJson(resourcesFolderPath);

        semaphore.guideCars(cars);

        System.out.println("\n🔋 === Electric Station Processing Begins ===");
        electricStation.processCars();

        System.out.println("\n⛽ === Gas Station Processing Begins ===");
        gasStation.processCars();

        System.out.println("\n🎉 === All Cars Successfully Processed ===");
    }
}
