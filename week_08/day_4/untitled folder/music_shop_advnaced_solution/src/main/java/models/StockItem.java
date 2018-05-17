package models;

import behaviours.ISell;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StockItem {

    private int id;
    private int buyPrice;
    private int sellPrice;
    private Shop shop;

    public StockItem() {
    }

    public StockItem(int buyPrice, int sellPrice, Shop shop) {
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.shop = shop;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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

    @Column(name="buy_price")
    public int getBuyPrice() {
        return this.buyPrice;
    }

    @Column(name="sell_price")
    public int getSellPrice() {
        return this.sellPrice;
    }

    @ManyToOne
    @JoinColumn(name="shop_id", nullable=false)
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }
}
