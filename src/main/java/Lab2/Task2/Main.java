package Lab2.Task2;

public class    Main {

    public static void main(String[] args) {
        Coffee americano = new Americano(50, Coffee.Intensity.Strong);
        americano.printCoffeeDetails();
        Coffee cappuccino = new Cappuccino(100, Coffee.Intensity.Normal);
        cappuccino.printCoffeeDetails();
        Coffee syrupCappuccino = new SyrupCappuccino(SyrupCappuccino.SyrupType.CARAMEL, 50, Coffee.Intensity.Light);
        syrupCappuccino.printCoffeeDetails();
        Coffee pumpkin = new PumpkinSpiceLatte(5, 50, Coffee.Intensity.Strong);



        pumpkin.printCoffeeDetails();


    }
}
