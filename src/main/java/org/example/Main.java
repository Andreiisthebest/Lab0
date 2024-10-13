package org.example;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.json";
        InputContainer inputContainer = ReadFile.parseForeignersFromJson(filePath);

        System.out.println("All Input IDs:");
        inputContainer.printIds(inputContainer.getInputs());

        System.out.println("Even ID Inputs:");
        inputContainer.printIds(inputContainer.filterByEvenId());

        System.out.println("Odd ID Inputs:");
        inputContainer.printIds(inputContainer.filterByOddId());

        System.out.println("Ages of All Inputs:");
        inputContainer.printAges(inputContainer.getInputs());

        System.out.println("Planets of Odd ID Inputs:");
        inputContainer.printPlanets(inputContainer.filterByOddId());
    }
}
