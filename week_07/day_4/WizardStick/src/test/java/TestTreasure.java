import Treasures.Gems;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTreasure {

    private Gold gold;
    private Gems gem;

    @Before
    public void setUp() throws Exception {
        gold = new Gold("Gold");
        gem = new Gems("Diamond");
    }

    @Test
    public void testCanGetTreasure() {
        assertEquals("Gold", gold.getType());
    }

    @Test
    public void testCanGetGem() {
        assertEquals("Diamond", gem.getType());
    }
}
