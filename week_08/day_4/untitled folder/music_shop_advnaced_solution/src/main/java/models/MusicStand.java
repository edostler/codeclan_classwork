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

    public MusicStand(int buyPrice, int sellPrice, Shop shop, String colour) {
        super(buyPrice, sellPrice, shop);
        this.colour = colour;
    }

    @Column(name="colour")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
