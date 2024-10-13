package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ReadFile {
        public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("src/main/resources/input.json"));


            JSONObject jsonObject = (JSONObject) obj;


            JSONArray dataArray = (JSONArray) jsonObject.get("data");


            for (Object dataItem : dataArray) {
                JSONObject alien = (JSONObject) dataItem;


                    long id = (long) alien.get("id");
                    Boolean isHumanoid = (Boolean) alien.getOrDefault("isHumanoid", null);
                    String planet = (String) alien.getOrDefault("planet", "Unknown");
                    Long age = (Long) alien.getOrDefault("age", null);
                    JSONArray traitsArray = (JSONArray) alien.getOrDefault("traits", new JSONArray());


                System.out.println("ID: " + id);
                System.out.println("Humanoid: " + (isHumanoid != null ? isHumanoid : "N/A"));
                System.out.println("Planet: " + planet);
                System.out.println("Age: " + (age != null ? age : "N/A"));
                System.out.print("Traits: ");


                Iterator<?> iterator = traitsArray.iterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next() + " ");
                }
                System.out.println("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


