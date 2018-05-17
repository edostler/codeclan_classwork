package Enums;

public enum InstrumentList {

    ACOUSTICGUITAR("Acoustic Guitar", "String", 120.00),
    DRUMKIT("Drum Kit", "Percussion", 10.00),
    ELECTRICGUITAR("Electric Guitar", "String", 150.00),
    PIANO("Piano", "Keyboard", 300.00),
    TRUMPET("Trumpet", "Brass", 100.00);

    private String instrumentName;
    private String instrumentType;
    private double instrumentBuyingPrice;

    InstrumentList(String instrumentName, String instrumentType, double instrumentBuyingPrice) {
        this.instrumentName = instrumentName;
        this.instrumentType = instrumentType;
        this.instrumentBuyingPrice = instrumentBuyingPrice;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public double getInstrumentBuyingPrice() {
        return instrumentBuyingPrice;
    }
}
