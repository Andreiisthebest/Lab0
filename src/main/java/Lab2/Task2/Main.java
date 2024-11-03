package Lab2.Task2;

public class Main {

    public static void main(String[] args) {
        Coffee americano = new Americano(50);
        Coffee cappuccino = new Cappuccino(100);
        Coffee syrupCappuccino = new SyrupCappuccino(SyrupCappuccino.SyrupType.CARAMEL, 50);
        Coffee pumpkin = new PumpkinSpiceLatte(5, 50);
        americano.printCoffeeDetails();
        cappuccino.printCoffeeDetails();
        syrupCappuccino.printCoffeeDetails();
        pumpkin.printCoffeeDetails();

    }




}
