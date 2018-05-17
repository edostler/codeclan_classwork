package device_management;

import Behaviours.IInput;

public class Mouse implements IInput{

    private String make;
    private int buttons;

    public Mouse(String make, int buttons) {
        this. make = make;
        this.buttons = buttons;
    }

    public String clickButton() {
        return "Click!";
    }

    public String inputData(String button) {
        return "clicking button: " + button;
    }
}
