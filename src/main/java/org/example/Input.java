package org.example;

import java.util.List;

public class Input {

    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private List<String> traits;

    public Input(int id, boolean isHumanoid, String planet, int age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public int getId() {
        return id;
    }

    public boolean isHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public int getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", IsHumanoid: " + isHumanoid +
                ", Planet: " + planet + ", Age: " + age +
                ", Traits: " + traits;
    }
}
