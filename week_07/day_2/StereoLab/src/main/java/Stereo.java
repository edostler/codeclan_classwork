import java.util.ArrayList;

public class Stereo {

    private String name;
    private ArrayList<Component> components;

    public Stereo(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getComponentsSize() {
        return components.size();
    }

    public void addComponent(Component component) {

    }





    //    public String tuneRadio(double frequency) {
//        for (Station station : this.stations) {
//            if (frequency == station.getFrequency()) {
//                return "You're listening to " + station.getStationName() + "!";
//            }
//        }
//        return "Unknown station.";
//    }

}
