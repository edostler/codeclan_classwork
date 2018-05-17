package Enums;

public enum ItemList {

    AMPLIFIER("Amplifier", 30.00),
    DRUMSTICK("Drum Stick", 2.50),
    INSTRUMENTCASE("Instrument Case", 10.00),
    INSTRUMENTSTAND("Instrument Stand", 10.00),
    MUSICBOOK("Music Book", 8.00),
    PLECTRUM("Plectrum", 0.50);

    private String itemName;
    private double itemBuyingPrice;

    ItemList(String itemName, double itemBuyingPrice) {
        this.itemName = itemName;
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

}
