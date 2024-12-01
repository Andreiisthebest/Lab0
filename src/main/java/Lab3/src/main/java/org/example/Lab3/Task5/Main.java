package org.example.Lab3.Task5;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String queueFolderPath = "C:\\Users\\andre\\Desktop\\Labs OOP\\Lab0\\src\\main\\java\\Lab3\\src\\main\\java\\org\\example\\Lab3\\Queue";

        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();
        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        HashSet<String> processedFiles = new HashSet<>();

        Timer semaphoreTimer = new Timer();
        semaphoreTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                File queueFolder = new File(queueFolderPath);
                if (!queueFolder.exists() || !queueFolder.isDirectory()) {
                    System.err.println("[Main] Invalid queue folder: " + queueFolderPath);
                    return;
                }

                File[] files = queueFolder.listFiles((dir, name) -> name.endsWith(".json"));
                if (files != null && files.length > 0) {
                    List<Car> cars = new ArrayList<>();
                    for (File file : files) {
                        if (!processedFiles.contains(file.getName())) {
                            try {
                                String content = new String(Files.readAllBytes(file.toPath()));
                                System.out.println("[Main] Processing file: " + file.getName());
                                Car car = parseCarFromJsonString(content);
                                cars.add(car);
                                processedFiles.add(file.getName());
                            } catch (IOException e) {
                                System.err.println("[Main] File read error: " + file.getName());
                            } catch (Exception e) {
                                System.err.println("[Main] Error processing car data in file: " + file.getName());
                            }
                        }
                    }
                    if (!cars.isEmpty()) {
                        semaphore.guideCars(cars);
                    }
                } else {
                    System.out.println("[Main] No new files in the queue folder.");
                }
            }
        }, 0, 5000);

        Timer servingTimer = new Timer();
        servingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\n[Scheduler] Processing cars at stations...");
                electricStation.processCars();
                gasStation.processCars();
            }
        }, 2000, 7000);

        Thread userInputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[Main] Type 'q' to exit the program...");
            while (true) {
                if ("q".equalsIgnoreCase(scanner.nextLine().trim())) {
                    System.out.println("[Main] Terminating program...");
                    semaphoreTimer.cancel();
                    servingTimer.cancel();
                    System.exit(0);
                }
            }
        });
        userInputThread.setDaemon(true);
        userInputThread.start();
    }

    private static Car parseCarFromJsonString(String jsonString) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            JSONObject jsonCar = (JSONObject) parser.parse(jsonString);

            int id = Integer.parseInt(jsonCar.get("id").toString());
            String type = jsonCar.get("type").toString();
            String passengers = jsonCar.get("passengers").toString();
            boolean isDining = Boolean.parseBoolean(jsonCar.get("isDining").toString());

            if (!type.equalsIgnoreCase("ELECTRIC") && !type.equalsIgnoreCase("GAS")) {
                throw new IllegalArgumentException("Invalid car type: " + type);
            }
            return new Car("CAR" + id, type, passengers, isDining);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + jsonString, e);
        }
    }
}
