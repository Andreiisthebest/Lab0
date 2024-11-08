package Lab2.Task2;

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


}