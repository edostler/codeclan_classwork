import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHolder {

    private Holder ed;

    @Before
    public void setUp() throws Exception {
        ed = new Holder("Ed Ostler", "51 Rampart Avenue");
    }

    @Test
    public void testName() {
        assertEquals("Ed Ostler", ed.getName());
    }

    @Test
    public void testAddress() {
        assertEquals("51 Rampart Avenue", ed.getAddress());
    }

    @Test
    public void setName() {
        ed.setName("Edward Ostler");
        assertEquals("Edward Ostler", ed.getName());
    }

    @Test
    public void setAddress() {
        ed.setAddress("Mansion On The Hill");
        assertEquals("Mansion On The Hill", ed.getAddress());
    }
}
