package Lab2.Task2;

public class Coffee {
    enum Intensity {
        Light,
        Normal,
        Strong
    }

    private Intensity coffeeIntensity;
    private  String name;

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
}