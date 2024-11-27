package org.example.Lab3.Task2;

public class GasStation implements Refuelable {
    private static int count;

    @Override
    public void refuel(int cardId) {
        System.out.println("Refueling gas car " + cardId + ".");


        count++;
        System.out.println(count);
    }
}

