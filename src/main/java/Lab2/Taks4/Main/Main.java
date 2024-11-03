    package Lab2.Taks4.Main;

    import Lab2.Taks4.CoffeeShop.Barista;

    public class    Main {

        public static void main(String[] args) {
    //        Coffee americano = new Americano(50);
    //        Coffee cappuccino = new Cappuccino(100);
    //        Coffee syrupCappuccino = new SyrupCappuccino(SyrupCappuccino.SyrupType.CARAMEL, 50);
    //        Coffee pumpkin = new PumpkinSpiceLatte(5, 50);
    //        americano.printCoffeeDetails();
    //        cappuccino.printCoffeeDetails();
    //        syrupCappuccino.printCoffeeDetails();
    //        pumpkin.printCoffeeDetails();
    //        Coffee coffee =  Americano.makeAmericano(50, Coffee.Intensity.Strong);
    //        Coffee coffee1 =  Cappuccino.makeCappuccino(150, Coffee.Intensity.Light);
    //        Coffee coffee2 =  SyrupCappuccino.makeSyrupCappuccino(SyrupCappuccino.SyrupType.CARAMEL, 20, Coffee.Intensity.Strong);
    //        Coffee coffee3 = PumpkinSpiceLatte.makePumpkinSpiceLatte(50, 200, Coffee.Intensity.Normal);
            Barista menu = new Barista();
            menu.displayMenu();

        }




    }
