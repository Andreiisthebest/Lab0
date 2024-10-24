package Lab0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputContainer {

    private List<Input> inputs;

    public InputContainer() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(Input input) {
        this.inputs.add(input);
    }


    public String classify(Input input) {
        boolean isHumanoid = input.isHumanoid();
        String planet = input.getPlanet();
        List<String> traits = input.getTraits();

        if (!isHumanoid && planet.equals("Kashyyyk") && traits.contains("HAIRY") && traits.contains("TALL")) {
            return "StarWars";
        }
        if (!isHumanoid && planet.equals("Endor") && traits.contains("SHORT") && traits.contains("HAIRY")) {
            return "StarWars";
        }
        if (isHumanoid && planet.equals("Asgard") && traits.contains("BLONDE") && traits.contains("TALL")) {
            return "Marvel";
        }
        if (isHumanoid && planet.equals("Betelgeuse") && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
            return "Hitchhiker";
        }
        if (!isHumanoid && planet.equals("Vogsphere") && traits.contains("GREEN") && traits.contains("BULKY")) {
            return "Hitchhiker";
        }
        if (isHumanoid && planet.equals("Earth") && traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
            return "LordOfTheRings";
        }
        if (isHumanoid && planet.equals("Earth") && traits.contains("SHORT") && traits.contains("BULKY")) {
            return "LordOfTheRings";
        }


        if (traits.contains("HAIRY") || planet.equals("Kashyyyk")) return "StarWars";
        if (traits.contains("BLONDE") || traits.contains("TALL") || planet.equals("Asgard")) return "Marvel";
        if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD") || planet.equals("Betelgeuse")) return "Hitchhiker";
        if (traits.contains("BULKY") || traits.contains("GREEN") || planet.equals("Vogsphere")) return "Hitchhiker";

        return "LordOfTheRings";
    }


    public Map<String, List<Input>> groupByUniverse() {
        Map<String, List<Input>> universeGroups = new HashMap<>();

        for (Input input : inputs) {
            String universe = classify(input);
            universeGroups.putIfAbsent(universe, new ArrayList<>());
            universeGroups.get(universe).add(input);
        }

        return universeGroups;
    }
}
