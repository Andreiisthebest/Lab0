package org.example.Lab3.Task2;

public class Main {
    public static void main(String[] args) {

Distribution dist = new Distribution();
        dist.distribution(2, "gas", "people", true);
        dist.distribution(3, "electric", "robot", true);
        dist.distribution(4, "electric", "people", false);
        dist.distribution(5, "gas", "robot", true);

    }
}
