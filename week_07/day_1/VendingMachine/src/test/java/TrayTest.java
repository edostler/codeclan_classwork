import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrayTest {

    private Tray tray;

    @Before
    public void before() {
        tray = new Tray(0.50, 5);
    }

    @Test
    public void testTrayPrice() {
        assertEquals(0.50, tray.getPrice(), 0.01);
    }

    @Test
    public void canGetStockSize() {
        assertEquals(0, tray.getStockSize());
    }

    @Test
    public void canAddItemToStock() {
        Drink drink = new Drink("Pepsi", 330);
        tray.addItemToStock(drink);
        assertEquals(1, tray.getStockSize());
    }

//    @Test
//    public void canRemoveItemFromStock() {
//        Drink drink = new Drink("Pepsi", 330);
//        assertEquals(0, tray.getStockSize());
//        tray.addItemToStock(drink);
//        assertEquals(0, tray.getStockSize());
//        tray.removeItemFromStock(drink);
//        assertEquals(0, tray.getStockSize());
//    }

    @Test
    public void canRemoveItemFromStock() {
        //test via instance of Drink methodology
        Drink drink1 = new Drink("Pepsi", 330);
        Drink drink2 = new Drink("Pepsi", 330);
        tray.addItemToStock(drink1);
        tray.addItemToStock(drink2);
        //this line below is an example of 'casting' which is where we are changing the returned Product into a Drink class
        Drink removedDrink = (Drink) tray.removeItemFromStock();
        assertEquals(drink1, removedDrink);
    }

    @Test
    public void testTrayCapacityCannotBeBreached() {
        for (int i = 0; i < 6; i++) {
            Drink drink = new Drink("Pepsi", 330);
            tray.addItemToStock(drink);
        }
        assertEquals(5, tray.getStockSize());
    }

}
