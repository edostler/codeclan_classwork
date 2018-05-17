package models;

import behaviours.ISell;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StockItem implements ISell {

    private int id;
    protected int buyPrice;
    protected int sellPrice;

    public StockItem() {
    }

    public StockItem(int buyPrice, int sellPrice) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    @Column(name="buy_price")
    public int getBuyPrice() {
        return this.buyPrice;
    }

    @Column(name="sell_price")
    public int getSellPrice() {
        return this.sellPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }
}
