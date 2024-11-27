package org.example.Lab3.Task2;

public class ElectricStation implements Refuelable{
    private static int count;
    public void refuel(int cardId) {
        System.out.println("Refueling electric car " + cardId + ".");
        System.out.println("");

        count++;
        System.out.println(count);
    }


}
