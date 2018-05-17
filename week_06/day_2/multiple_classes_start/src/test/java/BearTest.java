import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BearTest {

    private Bear bear;
    private Salmon salmon;
    private River river;

    @Before
    public void before(){
        bear = new Bear("Baloo");
        salmon = new Salmon();
        river = new River();
        river.addSalmon(salmon);
    }

    @Test
    public void bellyStartsEmpty() {
        assertEquals(0, bear.checkBellySize());
    }

    @Test
    public void canEatSalmon() {
        bear.eatSalmon(river);
        assertEquals(1, bear.checkBellySize());
        assertEquals(0, river.checkStockSize());
    }

    @Test
    public void canShitInTheWoods() {
        bear.eatSalmon(river);
        assertEquals(1, bear.checkBellySize());
        bear.shitInTheWoods();
        assertEquals(0, bear.checkBellySize());
    }
}
