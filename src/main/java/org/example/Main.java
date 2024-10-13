package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/input.json";
        InputContainer inputContainer = ReadFile.parseForeignersFromJson(filePath);

        Map<String, List<Input>> universeGroups = inputContainer.groupByUniverse();


        View.generateUniverseJsonFiles(universeGroups);
    }
}
