import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LooperTest {

    private Looper looper;

    @Before
    public void before() {
        looper = new Looper("Corkscrew", 10.00, 16, 12, 5, 15, 70, 3);
    }

    @Test
    public void hasName() {
        assertEquals("Corkscrew", looper.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(10.00, looper.getPrice(), 0.01);
    }

    @Test
    public void hasTill() {
        assertEquals(0.00, looper.getTill(), 0.01);
    }

    @Test
    public void hasCapacity() {
        assertEquals(16, looper.getCapacity());
    }

    @Test
    public void hasAgeLimit() {
        assertEquals(12, looper.getAgeLimit());
    }

    @Test
    public void hasDuration() {
        assertEquals(5, looper.getDuration());
    }

    @Test
    public void hasSpeed() {
        assertEquals(15, looper.getSpeed());
    }

    @Test
    public void hasMaxElevation() {
        assertEquals(70, looper.getMaxElevation());
    }

    @Test
    public void hasLoops() {
        assertEquals(3, looper.getLoops());
    }

    @Test
    public void canGetRidersSize() {
        assertEquals(0, looper.getRidersSize());
    }

    @Test
    public void canGetQueuersSize() {
        assertEquals(0, looper.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide() {
        Customer customer = new Customer("Ed", 31, 25.00);
        looper.addCustomerToRide(customer);
        assertEquals(1, looper.getRidersSize());
        assertEquals(10.00, looper.getTill(), 0.01);
        assertEquals(15.00, customer.getCash(), 0.01);
    }

    @Test
    public void canAddCustomerToRide__space_unavailable() {
        for (int i = 0; i < 17; i++) {
            Customer customer = new Customer("Ed", 31, 25.00);
            looper.addCustomerToRide(customer);
        }
        assertEquals(16, looper.getRidersSize());
        assertEquals(1, looper.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide__underage() {
        Customer customer = new Customer("Zoe", 2, 20.00);
        looper.addCustomerToRide(customer);
        assertEquals(0, looper.getRidersSize());
    }

    @Test
    public void canAddCustomerToRide__not_enough_cash() {
        Customer customer = new Customer("Emma", 27, 1.00);
        looper.addCustomerToRide(customer);
        assertEquals(0, looper.getRidersSize());
    }

    @Test
    public void canGetFreeSpace() {
        Customer customer = new Customer("Ed", 31, 25.00);
        assertEquals(16, looper.getFreeSpace());
        looper.addCustomerToRide(customer);
        assertEquals(15, looper.getFreeSpace());
    }

    @Test
    public void canThrill() {
        Customer customer = new Customer("Ed", 31, 25.00);
        looper.thrill(customer);
        assertEquals(112.00, customer.getHappiness(), 0.01);
    }

    @Test
    public void canIncreaseTill() {
        looper.increaseTill(10.00);
        assertEquals(10.00, looper.getTill(), 0.01);
    }

}
