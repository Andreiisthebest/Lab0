package org.example.Lab3.Task2;

public class PeopleDinner implements Dineable{
    private static int count;
  @Override
    public void dine(int carId){
        System.out.println("Serving dinner to people in " + carId + ".");
        count++;
      System.out.println(count);
    }
}
