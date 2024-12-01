package org.example.Lab3.Task5;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class Semaphore {
    private final ElectricStation electricStation;
    private final GasStation gasStation;

    public Semaphore(ElectricStation electricStation, GasStation gasStation) {
        this.electricStation = electricStation;
        this.gasStation = gasStation;
    }

    public List<Car> parseCarsFromJson(String resourcesFolderPath) {
        List<Car> cars = new ArrayList<>();
        File folder = new File(resourcesFolderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files != null) {
            JSONParser parser = new JSONParser();

            for (File file : files) {
                try (FileReader reader = new FileReader(file)) {
                    JSONObject jsonCar = (JSONObject) parser.parse(reader);

                    int id = Integer.parseInt(jsonCar.get("id").toString());
                    String type = jsonCar.get("type").toString();
                    String passengers = jsonCar.get("passengers").toString();
                    boolean isDining = Boolean.parseBoolean(jsonCar.get("isDining").toString());

                    cars.add(new Car("CAR" + id, type, passengers, isDining));
                } catch (Exception e) {
                    System.out.println("Error parsing file: " + file.getName());
                    e.printStackTrace();
                }
            }

            cars.sort(Comparator.comparingInt(car -> Integer.parseInt(car.getCarId().substring(3))));
        }
        return cars;
    }

    public void guideCars(List<Car> cars) {
        System.out.println("[Semaphore] Guiding cars to their respective stations...");
        for (Car car : cars) {
            if ("ELECTRIC".equalsIgnoreCase(car.getCarType())) {
                electricStation.addCarToQueue(car);
            } else if ("GAS".equalsIgnoreCase(car.getCarType())) {
                gasStation.addCarToQueue(car);
            } else {
                System.out.println("[Semaphore] Unknown car type for: " + car.getCarId());
            }
        }
        System.out.println("[Semaphore] All cars have been guided.");
    }
}
