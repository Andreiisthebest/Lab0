package Lab2.Task2;

public class PumpkinSpiceLatte extends Cappuccino{

    private int mgOfPumpkinSpice;
    public PumpkinSpiceLatte(int mgOfPumpkinSpice, int mlOfMilk) {
        super(mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
        getName("Pumpkin Spice Latte");
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("It contains " + mgOfPumpkinSpice + " mg of Pumpkin spice");

    }
}
