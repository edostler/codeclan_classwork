package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="music_stands")
public class MusicStand extends StockItem {

    private String colour;

    public MusicStand() {
    }

    public MusicStand(String colour, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.colour = colour;
    }

    @Column(name="colour")
    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }
}
