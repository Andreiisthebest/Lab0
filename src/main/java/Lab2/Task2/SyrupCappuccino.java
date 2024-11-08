package Lab2.Task2;

public class SyrupCappuccino extends Cappuccino {

    private SyrupType syrup;

    enum SyrupType {
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }
public SyrupCappuccino(SyrupType syrup, int mlOfMilk, Intensity intensity) {
    super("Syrup Cappuccino",mlOfMilk, intensity);
    this.syrup = syrup;

}
@Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup: " + syrup);

    }

}
