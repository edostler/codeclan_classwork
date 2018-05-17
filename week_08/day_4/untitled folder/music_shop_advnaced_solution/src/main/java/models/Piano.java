package models;

import models.InstrumentType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pianos")
public class Piano extends Instrument {

    private String manufacturer;

    public Piano() {
    }

    public Piano(int buyPrice, int sellPrice, Shop shop, String colour, String manufacturer) {
        super(buyPrice, sellPrice, shop, colour, InstrumentType.KEYBOARD);
        this.manufacturer = manufacturer;
    }

    @Column(name="manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String play() {
        return "Plink Plonk";
    }

}
