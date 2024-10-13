package org.example;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.json";
        InputContainer inputContainer = ReadFile.parseForeignersFromJson(filePath);

        System.out.println("Details:");
        inputContainer.printDetails();

        System.out.println("Universe Groupings:");
        inputContainer.printUniverseGroups();
    }
}
