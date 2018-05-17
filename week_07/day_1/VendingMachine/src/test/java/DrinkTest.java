import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    private Drink drink;

    //short cut to open a new class, select cursor on drink and hit alt+enter
    @Before
    public void before() {
        drink = new Drink("Pepsi", 330);
    }

    @Test
    public void canGetName() {
        assertEquals("Pepsi", drink.getName());
    }



}
