import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStandingOrder {

    private StandingOrder so;

    @Before
    public void setUp() throws Exception {
        double amount = 100;
        String recipient = "O2";
        so = new StandingOrder(amount, recipient);
    }

    @Test
    public void testAmount() {
        assertEquals(100, so.getAmount(), 0.1);
    }
    @Test
    public void testRecipient() {
        assertEquals("O2", so.getRecipient());
    }
}
