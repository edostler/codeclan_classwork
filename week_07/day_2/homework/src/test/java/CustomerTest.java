import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;

    @Before
    public void before() {
        customer = new Customer("Ed", 31, 25.00);
    }

    @Test
    public void hasName() {
        assertEquals("Ed", customer.getName());
    }

    @Test
    public void hasAge() {
        assertEquals(31, customer.getAge());
    }

    @Test
    public void hasCash() {
        assertEquals(25.00, customer.getCash(), 0.01);
    }

    @Test
    public void hasHappiness() {
        assertEquals(0.00, customer.getHappiness(), 0.01);
    }

    @Test
    public void hasRideTime() {
        assertEquals(0, customer.getRideTime());
    }

    @Test
    public void hasQueueTime() {
        assertEquals(0, customer.getQueueTime());
    }

    @Test
    public void canReduceCash() {
        customer.reduceCash(10.00);
        assertEquals(15.00, customer.getCash(), 0.01);
    }

    @Test
    public void canSetHappiness() {
        customer.setHappiness(3.00);
        assertEquals(3.00, customer.getHappiness(), 0.01);
    }

    @Test
    public void canSetRideTime() {
        customer.setRideTime(15);
        assertEquals(15, customer.getRideTime());
    }

    @Test
    public void canSetQueueTime() {
        customer.setQueueTime(10);
        assertEquals(10, customer.getQueueTime());
    }

}
