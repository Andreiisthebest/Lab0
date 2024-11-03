package Lab2.Taks4.CoffeeShop;

public class Cappuccino extends Coffee {

    private int mlOfMilk;

    public Cappuccino(String name, int mlOfMilk, Intensity intensity) {
        super(intensity, name);
        this.mlOfMilk = mlOfMilk;

    }


    public Cappuccino(int mlOfMilk, Intensity intensity) {
        super(intensity, "Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }


    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("It contains " + mlOfMilk + " ml of milk");
    }

    public static Cappuccino makeCappuccino(int mlOfMilk, Intensity intensity) {
        Cappuccino coffee = new Cappuccino(mlOfMilk, intensity);
        coffee.makeCoffee();
        System.out.println("It contains " + coffee.mlOfMilk + " ml of milk");
        return coffee;

    }
}