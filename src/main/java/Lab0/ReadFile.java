package Lab0;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static InputContainer parseForeignersFromJson(String filePath) {

        InputContainer inputContainer = new InputContainer();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray dataArray = (JSONArray) jsonObject.get("data");

            for (Object dataItem : dataArray) {
                JSONObject alien = (JSONObject) dataItem;

                int id = ((Long) alien.get("id")).intValue();
                boolean isHumanoid = (Boolean) alien.getOrDefault("isHumanoid", false);
                String planet = (String) alien.getOrDefault("planet", "Unknown");
                int age = alien.containsKey("age") ? ((Long) alien.get("age")).intValue() : -1;

                JSONArray traitsArray = (JSONArray) alien.getOrDefault("traits", new JSONArray());
                List<String> traits = new ArrayList<>();
                for (Object trait : traitsArray) {
                    traits.add((String) trait);
                }


                Input input = new Input(id, isHumanoid, planet, age, traits);
                inputContainer.addInput(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputContainer;
    }
}
