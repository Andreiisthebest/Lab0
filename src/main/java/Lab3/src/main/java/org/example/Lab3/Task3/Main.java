package org.example.Lab3.Task3;


public class Main {
    public static void main(String[] args) {
        Queue<Car> queue= new CircularQueue<>();
        CarStation station = new CarStation(queue);

        station.addCar(new Car("1", "Electric", "Human", true));
        station.addCar(new Car("2", "Gas", "Robot", false));
        station.addCar(new Car("3", "Electric", "Robot", true));
        station.addCar(new Car("4", "Gas", "Human", true));

        station.serveCars();
    }
}