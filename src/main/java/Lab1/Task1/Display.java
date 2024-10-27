package Lab1.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }


    public void compareSize(Display m) {
        String s = (this.width * this.height) > (m.getWidth() * m.getHeight())
                ? this.model + " is bigger \n"
                : (this.width * this.height) == (m.getWidth() * m.getHeight())
                ? "Displays are equal \n"
                : m.getModel() + " is bigger \n";
        System.out.print(s);

    }

    public void compareSharpness(Display m) {
        String s = (this.ppi) > (m.getPpi())
                ? this.model + " is sharper \n"
                : (this.ppi ) == m.getPpi()
                ? "Displays are equally sharp \n"
                : m.getModel() + "is sharper \n";
        System.out.print(s);
    }

    public void compareWithMonitor(Display m) {
        System.out.println("Comparing " + this.model + " with " + m.getModel());
        compareSize(m);
        compareSharpness(m);

//        if (this.width * this.height > m.getWidth() * m.getHeight() && this.ppi > m.getPpi()) {
//            System.out.println("The " + this.model + " monitor is bigger and sharper");
//        } else if (this.width * this.height < m.getWidth() * m.getHeight() && this.ppi < m.getPpi()) {
//            System.out.println("The " + m.getModel() + " monitor is bigger and sharper");
//        } else if (this.width * this.height > m.getWidth() * m.getHeight() && this.ppi < m.getPpi()) {
//            System.out.println("The " + this.model + " monitor is bigger but the " + m.getModel() + " is sharper");
//        } else if (this.width * this.height < m.getWidth() * m.getHeight() && this.ppi > m.getPpi()) {
//            System.out.println("The " + m.getModel() + " monitor is bigger but the " + this.model + " is sharper");
//        } else if (this.width * this.height == m.getWidth() * m.getHeight() && this.ppi > m.getPpi()) {
//            System.out.println("Display sizes are equal but the " + this.model + " is sharper");
//        } else if (this.width * this.height == m.getWidth() * m.getHeight() && this.ppi < m.getPpi()) {
//            System.out.println("Display sizes are equal but the " + m.getModel() + " is sharper");
//        } else if (this.width * this.height > m.getWidth() * m.getHeight() && this.ppi == m.getPpi()) {
//            System.out.println("The " + this.model + " monitor is bigger but they are equally sharp");
//        } else if (this.width * this.height < m.getWidth() * m.getHeight() && this.ppi == m.getPpi()) {
//            System.out.println("The " + m.getModel() + " monitor is bigger but they are equally sharp");
//        } else {
//            System.out.println("Display sizes are equal and are equally sharp");
//        }
    }
}
