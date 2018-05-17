package Enums;

public enum ComponentList {

    BASSDRUM("Bass Drum", 40.00, "Dum"),
    CYMBAL("Cymbal", 25.00, "Clash"),
    GUITARSTRING("Guitar String", 5.00, "Twang"),
    HIHAT("Hi-Hat", 25.00, "Tish"),
    KEY("Key", 15.00, "Plink"),
    SNAREDRUM("Snare Drum", 35.00, "Ba"),
    TOMTOM("Tom-Tom", 20.00, "Tom-tom"),
    VALVE("Valve", 10.00, "Pah-pa-rah");

    private String componentName;
    private double componentBuyingPrice;
    private String componentSound;

    ComponentList(String componentName, double componentBuyingPrice, String componentSound) {
        this.componentName = componentName;
        this.componentBuyingPrice = componentBuyingPrice;
        this.componentSound = componentSound;
    }

    public String getComponentName() {
        return componentName;
    }

    public double getComponentBuyingPrice() {
        return componentBuyingPrice;
    }

    public String getComponentSound() {
        return componentSound;
    }
}
