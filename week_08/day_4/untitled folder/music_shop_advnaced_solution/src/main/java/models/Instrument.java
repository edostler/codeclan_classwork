package models;

import behaviours.IPlay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instrument extends StockItem{

    private String colour;
    private InstrumentType type;

    public Instrument() {
    }

    public Instrument(int buyPrice, int sellPrice, Shop shop, String colour, InstrumentType type) {
        super(buyPrice, sellPrice, shop);
        this.colour = colour;
        this.type = type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setType(InstrumentType type) {
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
}
