package device_management;

import Behaviours.IInput;

public class Keyboard implements IInput{

    private String make;

    public Keyboard(String make) {
        this.make = make;
    }

    public String pressKey() {
        return "Tap!";
    }

    public String inputData(String key) {
        return "pressing key: " + key;
    }


}
