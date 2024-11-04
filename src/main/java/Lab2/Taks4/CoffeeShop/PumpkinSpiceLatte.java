package Lab2.Taks4.CoffeeShop;

public class PumpkinSpiceLatte extends Coffee {

    private int mgOfPumpkinSpice;
    private int mlOfMilk;

    public PumpkinSpiceLatte(int mgOfPumpkinSpice, int mlOfMilk, Intensity intensity) {
        super(intensity, "Pumpkin Spice Latte");
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("It contains " + mlOfMilk + " ml of milk");
        System.out.println("It contains " + mgOfPumpkinSpice + " mg of Pumpkin spice");
    }

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(int mgOfPumpkinSpice, int mlOfMilk, Intensity intensity) {
        PumpkinSpiceLatte coffee = new PumpkinSpiceLatte(mgOfPumpkinSpice, mlOfMilk, intensity);
        coffee.makeCoffee();
        System.out.println("It contains " + mgOfPumpkinSpice + " mg of Pumpkin spice");
        System.out.println("It contains " + mlOfMilk + " ml of milk");
        return coffee;
    }
}
