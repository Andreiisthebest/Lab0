package Lab2.Task2;

public class Americano extends Coffee {
    int mlOfWater;


    public Americano(int mlOfWater, Intensity intensity) {
        super(intensity, "Americano");
        this.mlOfWater = mlOfWater;


    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("It contains " + mlOfWater + " ml of water");

    }

}
