package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="guitars")
public class Guitar extends Instrument  {

    private String model;
    private int numberOfStrings;

    public Guitar() {
    }

    public Guitar(String model, String colour, int numberOfStrings, int buyPrice, int sellPrice) {
        super(colour, InstrumentType.STRING, buyPrice, sellPrice);
        this.numberOfStrings = numberOfStrings;
        this.model = model;
    }

    @Column(name="model")
    public String getModel() {
        return this.model;
    }

    @Column(name="number_of_strings")
    public int getNumberOfStrings() {
        return this.numberOfStrings;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public String play() {
        return "Kerrang!!!";
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }

}
