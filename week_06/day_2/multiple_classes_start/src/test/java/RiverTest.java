import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RiverTest {

    River river;
    Salmon salmon;

    @Before
    public void before() {
        river = new River();
        salmon = new Salmon();
    }

    @Test
    public void canAddSalmon() {
        river.addSalmon(salmon);
        assertEquals(1, river.checkStockSize());
    }

    @Test
    public void canRemoveSalmon() {
        river.addSalmon(salmon);
        assertEquals(1, river.checkStockSize());
        river.removeSalmon();
        assertEquals(0, river.checkStockSize());
    }
}
