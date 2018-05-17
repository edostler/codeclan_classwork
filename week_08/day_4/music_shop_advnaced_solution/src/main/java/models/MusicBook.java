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

    public MusicBook(String title, int buyPrice, int sellPrice) {
        super(buyPrice, sellPrice);
        this.title = title;
    }

    @Column(name="title")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int calculateMarkup() {
        return this.sellPrice - this.buyPrice;
    }

}
