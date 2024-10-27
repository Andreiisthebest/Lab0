package Lab1.Task3;

import Lab1.Task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String name) {
        this.assistantName = name;
        this.assignedDisplays = new ArrayList<>();
    }


    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }


    public void assist() {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            Display currentDisplay = assignedDisplays.get(i);
            if (i + 1 < assignedDisplays.size()) {
                Display nextDisplay = assignedDisplays.get(i + 1);

                System.out.println("Comparing " + currentDisplay + " with " + nextDisplay);
            }else if(i!=1 && i!=0){
                Display nextDisplay = assignedDisplays.get(0);
                System.out.println("Comparing " + currentDisplay + " with " + nextDisplay);

            }
        }
    }


    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("\nRemoved " + d.getModel());
            return d;
        } else {
            System.out.println("Display not found.");
            return null;
        }
    }
}