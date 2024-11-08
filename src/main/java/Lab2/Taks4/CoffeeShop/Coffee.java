package Lab2.Taks4.CoffeeShop;

public class Coffee {
    enum Intensity {
        Light,
        Normal,
        Strong
    }

    private Intensity coffeeIntensity;
    private final String name;  // Use final to ensure the name is set only once

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    void printCoffeeDetails() {
        System.out.println("You ordered " + name);
        System.out.println("Coffee Intensity: " + coffeeIntensity);
    }

    public void makeCoffee() {
        System.out.println("Making " + name);
        System.out.println("Coffee Intensity: " + coffeeIntensity);
    }
}
