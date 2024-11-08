package Lab2.Taks4.CoffeeShop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Barista {

    private final Scanner scanner;

    public Barista() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        boolean continueOrdering = true;
        ArrayList<Coffee> orderList = new ArrayList<>();

        while (continueOrdering) {
            System.out.println("---- Menu ----");
            System.out.println("1. Americano");
            System.out.println("2. Cappuccino");
            System.out.println("3. Syrup Cappuccino");
            System.out.println("4. Pumpkin Spice Latte");
            System.out.println("5. Exit");
            System.out.print("What would you like to drink?\n");

            int choice = getValidChoice(1, 5);

            switch (choice) {
                case 1:
                    Americano americano = createAmericano();
                    orderList.add(americano);
                    break;

                case 2:
                    Cappuccino cappuccino = createCappuccino();
                    orderList.add(cappuccino);
                    break;

                case 3:
                    SyrupCappuccino syrupCappuccino = createSyrupCappuccino();
                    orderList.add(syrupCappuccino);
                    break;

                case 4:
                    PumpkinSpiceLatte pumpkinSpiceLatte = createPumpkinSpiceLatte();
                    orderList.add(pumpkinSpiceLatte);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    continueOrdering = false;
                    break;
            }
        }

        printOrderList(orderList);
    }
    private Americano createAmericano() {
        System.out.println("You ordered an Americano. How many ml of water?");
        int mlOfWater = getValidPositiveInt("ml of water");
        System.out.println("Select Intensity: 1. Light 2. Normal 3. Strong");
        Coffee.Intensity intensity = getValidIntensity();
        return Americano.makeAmericano(mlOfWater, intensity);
    }

    private Cappuccino createCappuccino() {
        System.out.println("You ordered a Cappuccino. How many ml of milk?");
        int mlOfMilk = getValidPositiveInt("ml of milk");
        System.out.println("Select Intensity: 1. Light 2. Normal 3. Strong");
        Coffee.Intensity intensity = getValidIntensity();
        return Cappuccino.makeCappuccino(mlOfMilk, intensity);
    }

    private SyrupCappuccino createSyrupCappuccino() {
        System.out.println("You ordered a Syrup Cappuccino.");
        System.out.println("Please choose a syrup flavor:");
        SyrupCappuccino.SyrupType[] syrupTypes = SyrupCappuccino.SyrupType.values();
        for (int i = 0; i < syrupTypes.length; i++) {
            System.out.println((i + 1) + ". " + syrupTypes[i]);
        }
        int syrupChoice = getValidChoice(1, syrupTypes.length);
        SyrupCappuccino.SyrupType selectedSyrup = syrupTypes[syrupChoice - 1];

        System.out.println("How many ml of milk?");
        int mlOfMilk = getValidPositiveInt( " ml of milk");
        System.out.println("Select Intensity: 1. Light 2. Normal 3. Strong");
        Coffee.Intensity intensity = getValidIntensity();
        return SyrupCappuccino.makeSyrupCappuccino(selectedSyrup, mlOfMilk, intensity);
    }

    private PumpkinSpiceLatte createPumpkinSpiceLatte() {
        System.out.println("You ordered a Pumpkin Spice Latte.");
        System.out.println("How many mg of Pumpkin Spice?");
        int mgOfPumpkinSpice = getValidPositiveInt(" mg of Pumpkin Spice");
        System.out.println("How many ml of milk?");
        int mlOfMilk = getValidPositiveInt(" ml of milk");
        System.out.println("Select Intensity: 1. Light 2. Normal 3. Strong");
        Coffee.Intensity intensity = getValidIntensity();
        return PumpkinSpiceLatte.makePumpkinSpiceLatte(mgOfPumpkinSpice, mlOfMilk, intensity);
    }


    private void printOrderList(ArrayList<Coffee> orderList) {
        System.out.println("\nYour order list:");
        for (Coffee coffee : orderList) {
            coffee.printCoffeeDetails();
        }
    }


    private int getValidChoice(int min, int max) {
        int choice = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid choice, please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a valid number.");
                scanner.next();
            }
        }
        return choice;
    }
    private int getValidPositiveInt(String valueName) {
        int value = -1;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Enter " + valueName + ": ");
                String input = scanner.next();
                value = Integer.parseInt(input);
                if (value > 0) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input, please enter a positive integer for " + valueName + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a valid positive integer for " + valueName + ".");
            }
        }
        return value;
    }


    private Coffee.Intensity getValidIntensity() {
        Coffee.Intensity intensity = null;
        boolean isValid = false;
        while (!isValid) {
            int intensityChoice = getValidChoice(1, 3);
            switch (intensityChoice) {
                case 1:
                    intensity = Coffee.Intensity.Light;
                    isValid = true;
                    break;
                case 2:
                    intensity = Coffee.Intensity.Normal;
                    isValid = true;
                    break;
                case 3:
                    intensity = Coffee.Intensity.Strong;
                    isValid = true;
                    break;
            }
        }
        return intensity;
    }
}
