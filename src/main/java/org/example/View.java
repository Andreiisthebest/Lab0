package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class View {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static void writeToFile(String filename, List<Input> inputs) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), inputs);
            System.out.println("Written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filename);
            e.printStackTrace();
        }
    }


    public static void generateUniverseJsonFiles(Map<String, List<Input>> universeGroups) {
        universeGroups.forEach((universe, inputs) -> {
            String filename = universe.toLowerCase() + ".json";
            writeToFile(filename, inputs);
            System.out.println(universe + ": " + inputs);
        });
    }
}
