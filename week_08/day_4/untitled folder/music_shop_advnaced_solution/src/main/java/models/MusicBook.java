package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="music_books")
public class MusicBook extends StockItem {

    String title;

    public MusicBook() {
    }

    public MusicBook(int buyPrice, int sellPrice, Shop shop, String title) {
        super(buyPrice, sellPrice, shop);
        this.title = title;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
