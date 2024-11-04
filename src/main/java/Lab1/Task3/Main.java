package Lab1.Task3;

import Lab1.Task1.Display;

public class Main {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("Vasea");
        Display d1 = new Display(200, 50, 505, "Asus");
        Display d2 = new Display( 50, 100, 60, "Lenovo");
        Display d3 = new Display( 1100, 100, 60, "HP");
        assistant.assignDisplay(d1);
        assistant.assignDisplay(d2);
        assistant.assignDisplay(d3);
        assistant.assist();
        assistant.buyDisplay(d1);
        assistant.assist();
    }
}
