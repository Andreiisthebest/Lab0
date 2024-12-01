package org.example.Lab3.Task4;

public class Car {
    public String getCarId() {
        return carId;
    }

    public String getCarType() {
        return carType;
    }

    public String getPerson() {
        return person;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumption;
    }

    private String carId;
    private String carType;
    private String person;
    private boolean isDining;
    private int consumption;

    public Car(String carId, String carType, String person, boolean isDining) {
        this.carId = carId;
        this.carType = carType;
        this.person = person;
        this.isDining = isDining;
    }
    @Override
    public String toString() {
        return carId;
    }
}
