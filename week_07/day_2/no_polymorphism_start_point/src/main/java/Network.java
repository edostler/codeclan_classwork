import java.util.*;

public class Network {

//    private String name;
//    private ArrayList<Desktop> devicesDesktop;
//    private ArrayList<Printer> devicesPrinter;
//
//    public Network(String name) {
//        this.devicesDesktop = new ArrayList<Desktop>();
//        this.devicesPrinter = new ArrayList<Printer>();
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int deviceCount() {
//        return devicesDesktop.size() + devicesPrinter.size();
//    }
//
//    public void connect(Desktop desktop) {
//        devicesDesktop.add(desktop);
//    }
//    //this is an example of Overloading, where a second function with the same name takes in different arguments.
//    public void connect(Printer printer) {
//        devicesPrinter.add(printer);
//    }
//
//    public void disconnectAll() {
//        devicesDesktop.clear();
//        devicesPrinter.clear();
//    }

    private String name;
    private ArrayList<IConnect> devices;
    private int capacity;

    public Network(String name, int capacity) {
        this.devices = new ArrayList<IConnect>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int deviceCount() {
        return devices.size();
    }
    //this function will now take in either a Desktop or a Printer, as they are both implementing IConnect.
    public void connect(IConnect device) {
        if (countFreeSlots() > 0) {
            devices.add(device);
        }
    }
    //In the same way I could have a function that thinks its returning an IConnect, inside of it I can return a Desktop or Printer.

    public void disconnectAll() {
        devices.clear();
    }

    public int countFreeSlots() {
        return getCapacity() - deviceCount();
    }
}