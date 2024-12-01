package org.example.Lab3.Task2;

public class RobotDinner {
    private static int count;
    public void dine(int carId){
        System.out.println("Serving dinner to robots in " + carId + "." );

        count++;
        System.out.println(count);
    }
}
