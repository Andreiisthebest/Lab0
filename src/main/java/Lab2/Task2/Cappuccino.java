package Lab2.Task2;

public class Cappuccino extends Coffee {

    private int mlOfMilk;
    public Cappuccino(int mlOfMilk) {
        super(Intensity.Strong, "Cappuccino");
    this.mlOfMilk = mlOfMilk;
    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("It contains " + mlOfMilk + " ml of milk");
    }
}
