package org.example;

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
        int age = input.getAge();
        List<String> traits = input.getTraits();

        if (!isHumanoid && planet.equals("Kashyyyk") && traits.contains("HAIRY") && traits.contains("TALL")) {
            return "Star Wars Universe (Wookie)";
        }
        if (!isHumanoid && planet.equals("Endor") && traits.contains("SHORT") && traits.contains("HAIRY")) {
            return "Star Wars Universe (Ewok)";
        }
        if (isHumanoid && planet.equals("Asgard") && traits.contains("BLONDE") && traits.contains("TALL")) {
            return "Marvel Universe (Asgardian)";
        }
        if (isHumanoid && planet.equals("Betelgeuse") && traits.contains("EXTRA_ARMS") && traits.contains("EXTRA_HEAD")) {
            return "Hitchhiker's Universe (Betelgeusian)";
        }
        if (!isHumanoid && planet.equals("Vogsphere") && traits.contains("GREEN") && traits.contains("BULKY")) {
            return "Hitchhiker's Universe (Vogons)";
        }
        if (isHumanoid && planet.equals("Earth") && traits.contains("BLONDE") && traits.contains("POINTY_EARS")) {
            return "Lord of the Rings Universe (Elf)";
        }
        if (isHumanoid && planet.equals("Earth") && traits.contains("SHORT") && traits.contains("BULKY")) {
            return "Lord of the Rings Universe (Dwarf)";
        }


        if (traits.contains("HAIRY")) return "Star Wars Universe (Wookie)";
        if (traits.contains("BLONDE") || traits.contains("TALL")) return "Marvel Universe (Asgardian)";
        if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) return "Hitchhiker's Universe (Betelgeusian)";
        if (traits.contains("GREEN") || traits.contains("BULKY")) return "Hitchhiker's Universe (Vogons)";

        return "Lord of the Rings Universe (Elf)";
    }

    public void printDetails() {
        for (Input input : inputs) {
            String classification = classify(input);
            System.out.printf(
                    "ID: %d, IsHumanoid: %s, Planet: %s, Age: %s, Traits: %s\n" +
                            "Classification: %s\n\n",
                    input.getId(),
                    input.isHumanoid() ? "True" : "",
                    input.getPlanet().isEmpty() ? "" : input.getPlanet(),
                    input.getAge() > 0 ? input.getAge() : "",
                    String.join(", ", input.getTraits()),
                    classification
            );
        }
    }

    public void printUniverseGroups() {
        Map<String, List<Integer>> universeMap = new HashMap<>();

        for (Input input : inputs) {
            String universe = classify(input);
            universeMap.putIfAbsent(universe, new ArrayList<>());
            universeMap.get(universe).add(input.getId());
        }

        universeMap.forEach((universe, ids) -> {
            System.out.print(universe + ": ");
            ids.forEach(id -> System.out.print("ID" + id + " "));
            System.out.println();
        });
    }
}
