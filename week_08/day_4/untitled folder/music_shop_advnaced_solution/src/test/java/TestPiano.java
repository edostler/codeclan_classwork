import db.DBHelper;
import models.Piano;
import models.Shop;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TestPiano {

    Piano piano;
    Shop shop;

    @Before
    public void before() {
        Shop shop = new Shop("Ed's");
        piano = new Piano(1000, 1500, shop, "Blue", "Elton");
        DBHelper.saveOrUpdate(piano);
    }

    @Test
    public void canSave() {
        Piano found = DBHelper.find(Piano.class, piano.getId());
        assertEquals("Elton", found.getManufacturer());
    }

//    @Test
//    public void canUpdate() {
//        Piano found = DBHelper.find(Piano.class, piano.getId());
//        assertEquals(piano.getId(), found.getId());
//        found.setManufacturer("Steinway");
//        DBHelper.saveOrUpdate(found);
//        found = DBHelper.find(Piano.class, found.getId());
//        assertEquals("Steinway", found.getManufacturer());
//    }

}
