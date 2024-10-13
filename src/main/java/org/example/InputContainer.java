package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputContainer {

    private List<Input> inputs;

    public InputContainer() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public List<Input> filterByEvenId() {
        return inputs.stream()
                .filter(input -> input.getId() % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Input> filterByOddId() {
        return inputs.stream()
                .filter(input -> input.getId() % 2 != 0)
                .collect(Collectors.toList());
    }

    public void printIds(List<Input> filteredInputs) {
        System.out.println("Filtered IDs:");
        filteredInputs.forEach(input -> System.out.print(input.getId() + " "));
        System.out.println();
    }

    public void printAges(List<Input> filteredInputs) {
        System.out.println("Ages:");
        filteredInputs.forEach(input -> System.out.print(input.getAge() + " "));
        System.out.println();
    }

    public void printPlanets(List<Input> filteredInputs) {
        System.out.println("Planets:");
        filteredInputs.forEach(input -> System.out.print(input.getPlanet() + " "));
        System.out.println();
    }
}
