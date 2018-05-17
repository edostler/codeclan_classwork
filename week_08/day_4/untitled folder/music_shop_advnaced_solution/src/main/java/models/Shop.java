package models;

import behaviours.ISell;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="shop")
public class Shop {

    private int id;
    private String name;
    private List<StockItem> stock;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "shop")
    public List<StockItem> getStock() {
        return stock;
    }

    public void setStock(List<StockItem> stock) {
        this.stock = stock;
    }

    @Column(name="name")
    public String getName() {
        return this.name;
    }

    public int stockCount() {
        return this.stock.size();
    }

    public void addToStock(StockItem item) {
        this.stock.add(item);
    }

    public void removeFromStock(StockItem item) {
        this.stock.remove(item);
    }

    public int totalPotentialProfit() {
        int total = 0;
        for (StockItem item : stock) {
            total += item.calculateMarkup();
        }
        return total;
    }
}
