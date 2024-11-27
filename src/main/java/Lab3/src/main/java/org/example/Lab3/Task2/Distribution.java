package org.example.Lab3.Task2;

public class Distribution {
    int carId;

    public void distribution(int carId, String carType, String person, boolean isDining) {

        if (isDining) {
            System.out.println("Enjoy your meals");


        } else System.out.println("They are not dining");

        if (carType == "gas") {
            GasStation gs = new GasStation();
            gs.refuel(carId);

        } else if (carType == "electric") {
            ElectricStation es = new ElectricStation();
            es.refuel(carId);

        } else if (person == "person") {
            PeopleDinner pd = new PeopleDinner();
            pd.dine(carId);

        } else {
            RobotDinner rd = new RobotDinner();
            rd.dine(carId);
        }


    }
}