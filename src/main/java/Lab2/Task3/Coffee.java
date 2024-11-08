package Lab2.Task3;

public class Coffee {
    enum Intensity {
        Light,
        Normal,
        Strong
    }

    private Intensity coffeeIntensity;
    private static String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void getName(String name) {
        this.name = name;
    }

    void printCoffeeDetails() {
        System.out.println("You ordered " + name );
        System.out.println("Coffee Intensity: " + coffeeIntensity);

    }
    public void makeCoffee(){
        System.out.println("Making " + name);
        System.out.println("Coffee Intensity: " + coffeeIntensity);

    }
}
