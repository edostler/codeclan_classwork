package models;

import behaviours.IPlay;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrument extends StockItem implements IPlay {

    private String colour;
    private InstrumentType type;

    public Instrument() {
    }

    public Instrument(String colour, InstrumentType type, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.colour = colour;
        this.type = type;
    }

    @Column(name="colour")
    public String getColour() {
        return this.colour;
    }

    @Column(name="type")
    public InstrumentType getType() {
        return this.type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(InstrumentType type) {
        this.type = type;
    }
}
