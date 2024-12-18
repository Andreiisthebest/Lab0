package Lab2.Task3;

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
    public static Americano makeAmericano(int mlOfWater, Intensity intensity) {
        Americano coffee = new Americano(mlOfWater, intensity);
        coffee.makeCoffee();
        System.out.println("It contains " + coffee.mlOfWater + " ml of water");
        return coffee;

    }
}
