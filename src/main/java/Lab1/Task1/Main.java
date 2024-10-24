package Lab1.Task1;
public class Main {
    public static void main(String[] args) {
    Display d1 = new Display(200, 50, 505, "Asus");
    Display d2 = new Display( 50, 100, 60, "Lenovo");
    Display d3 = new Display( 1100, 100, 60, "HP");
        d1.compareWithMonitor(d2);
        d1.compareWithMonitor(d3);
        d2.compareWithMonitor(d3);
    }
}
