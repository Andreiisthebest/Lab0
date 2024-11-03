package Lab2.Taks4.CoffeeShop;

public class PumpkinSpiceLatte extends Cappuccino {

    private int mgOfPumpkinSpice;
    public PumpkinSpiceLatte(int mgOfPumpkinSpice, int mlOfMilk, Intensity intensity) {
        super("Pumpkin Spice Latte",mlOfMilk, intensity);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;

    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
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
