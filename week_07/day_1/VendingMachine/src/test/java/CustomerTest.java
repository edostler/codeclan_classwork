import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    @Before
    public void before() {
        customer = new Customer("Ed", 10.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Ed", customer.getName());
    }

    @Test
    public void canGetCash() {
        assertEquals(10.00, customer.getCustomerCash(), 0.01);
    }

    @Test
    public void checkInventoryEmptyInitially() {
        assertEquals(0, customer.inventoryEmptyInitially());
    }

}
