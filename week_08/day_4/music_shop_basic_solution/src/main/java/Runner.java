import db.DBHelper;
import models.Guitar;
import models.Piano;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Guitar guiter1 = new Guitar("Ibanez", "Blue", 4, 160, 200);
        DBHelper.saveOrUpdate(guiter1);
        Guitar guiter2 = new Guitar("Fender", "Red", 6, 185, 220);
        DBHelper.saveOrUpdate(guiter2);


        Piano piano1 = new Piano("Elton", "Black", 500, 1000);
        DBHelper.saveOrUpdate(piano1);
        Piano piano2 = new Piano("Stevie", "Black", 600, 500);
        DBHelper.saveOrUpdate(piano2);


        Guitar foundGuitar = DBHelper.find(Guitar.class, guiter1.getId());

        List<Guitar> foundGuitars = DBHelper.getAll(Guitar.class);

    }

}
