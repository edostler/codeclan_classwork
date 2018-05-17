import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Shop shop = new Shop("Ed's");
        DBHelper.saveOrUpdate(shop);

        Guitar guitar1 = new Guitar(160, 200, shop, "Blue", "Ibanez", 4);
        DBHelper.saveOrUpdate(guitar1);

        Guitar guitar2 = new Guitar(160, 200, shop, "Red", "Fender", 4);
        DBHelper.saveOrUpdate(guitar2);


        Piano piano1 = new Piano(500, 1000,shop,"Black", "Elton");
        DBHelper.saveOrUpdate(piano1);
        Piano piano2 = new Piano(600, 500, shop,"White", "Stevie");
        DBHelper.saveOrUpdate(piano2);

        MusicStand musicStand = new MusicStand(10, 20, shop, "Silver");
        DBHelper.saveOrUpdate(musicStand);

        MusicBook musicBook = new MusicBook(5, 20, shop,"Music By Numbers");
        DBHelper.saveOrUpdate(musicBook);


        Guitar foundGuitar = DBHelper.find(Guitar.class, guitar1.getId());
        Piano foundPiano = DBHelper.find(Piano.class, piano1.getId());
        MusicStand foundMusicStand = DBHelper.find(MusicStand.class, musicStand.getId());
        MusicBook foundMusicBook = DBHelper.find(MusicBook.class, musicBook.getId());

        List<Guitar> foundGuitars = DBHelper.getAll(Guitar.class);
        List<MusicBook> foundMusicBooks = DBHelper.getAll(MusicBook.class);

    }

}
