package org.example.Lab3.Task4;

public class RobotDinner implements Dineable{
    private static int count = 0;
    public void serveDinner(String carId){
        System.out.println("carId: " + carId+ " RobotDinner: Dinner is being server. Thank you!");
        count++;
        System.out.println("RobotDinner Count: "+ count + "\n");
    }
}

