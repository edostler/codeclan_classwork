package ParentClasses;

import Components.*;

import java.util.ArrayList;

public abstract class Instrument extends Product {

    private String instrumentType;
    private ArrayList<Component> components;
    private String colour;

    public Instrument(String productName, double buyingPrice, String instrumentType, String colour) {
        super(productName, buyingPrice);
        this.instrumentType = instrumentType;
        this.colour = colour;
        this.components = new ArrayList<>();
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public String getColour() {
        return colour;
    }

    public int getNumberOfComponents() {
        return this.components.size();
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

//    THIS METHOD IS CONCISE BUT RELIES ON ENUMS FOR THE SOUNDS RATHER THAN INTERFACE
//    INSTEAD OF ENUM COULD USE DATABASE OR CREATE A NEW COMPONENT INSTANCE VARIABLE FOR SOUND
//    public String playInstrument() {
//        String sounds = "";
//        for (Component component : components) {
//            sounds += (component.getSound() + " ");
//        }
//        return sounds.trim();
//    }

//    THIS METHOD USES THE INTERFACE FOR PLAY, BUT REQUIRES A NASTY IF ELSE STATEMENT TO CHECK THE CORRECT CASTING COMPONENT TYPE
    public String playInstrument() {
        String sounds = "";
        for (Component component : components) {
            if (component.getProductName() == "Bass Drum") {
                BassDrum bassDrum = (BassDrum) component;
                sounds += (bassDrum.play() + " ");
            }
            else if (component.getProductName() == "Cymbal") {
                Cymbal cymbal = (Cymbal) component;
                sounds += (cymbal.play() + " ");
            }
            else if (component.getProductName() == "Guitar String") {
                GuitarString guitarString = (GuitarString) component;
                sounds += (guitarString.play() + " ");
            }
            else if (component.getProductName() == "Hi-Hat") {
                HiHat hiHat = (HiHat) component;
                sounds += (hiHat.play() + " ");
            }
            else if (component.getProductName() == "Snare Drum") {
                SnareDrum snareDrum = (SnareDrum) component;
                sounds += (snareDrum.play() + " ");
            }
            else if (component.getProductName() == "Tom-Tom") {
                TomTom tomTom = (TomTom) component;
                sounds += (tomTom.play() + " ");
            }
            else if (component.getProductName() == "Valve") {
                Valve valve = (Valve) component;
                sounds += (valve.play() + " ");
            }
            else {
                sounds += ("UNKNOWN_COMPONENT:" + component.getProductName() + ":EOM" + " ");
            }
        }
        return sounds.trim();
    }

}
