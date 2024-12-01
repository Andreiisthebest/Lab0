package org.example.Lab3.Task3;

public class ElectricStation implements Refuelable{
    private static int count = 0;
    public void refuel(String carId){
        System.out.println("carId: " + carId+ " ElectricStation: Your car has been refueled. Thank you!");
        count++;
        System.out.println("ElectricStation Count: "+ count +"\n_________________________");
    }
}
