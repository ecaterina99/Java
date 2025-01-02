/*
Create a class Ghost
Ghost objects are instantiated without any arguments.
Ghost objects are given a random color attribute of
"white" or "yellow" or "purple" or "red" when instantiated
 */

import java.util.Random;

public class GhostOOP {
    String color = "";
    public String getColor() {
        return this.color;
    }

    public GhostOOP() {
        switch (new Random().nextInt(4)) {
            case 0:
                this.color = "white";
                break;
            case 1:
                this.color = "yellow";
                break;
            case 2:
                this.color = "purple";
                break;
            case 3:
                this.color = "red";
                break;

        }
    }
}