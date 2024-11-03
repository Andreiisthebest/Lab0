package Lab2.Taks4.CoffeeShop;

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
    public static SyrupCappuccino makeSyrupCappuccino(SyrupType syrup, int mlOfMilk, Intensity intensity) {
        SyrupCappuccino coffee = new SyrupCappuccino(SyrupType.CARAMEL, mlOfMilk, intensity);
        coffee.makeCoffee();
        System.out.println("It contains " + mlOfMilk + " ml of milk");
        System.out.println("It contains " + syrup + " syrup");
        return coffee;

    }
}
