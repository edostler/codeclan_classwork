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

    public Guitar(int buyPrice, int sellPrice, Shop shop, String colour, String model, int numberOfStrings) {
        super(buyPrice, sellPrice, shop, colour, InstrumentType.STRING);
        this.model = model;
        this.numberOfStrings = numberOfStrings;
    }

    @Column(name="model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="number_of_strings")
    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public String play() {
        return "Kerrang!!!";
    }

}
