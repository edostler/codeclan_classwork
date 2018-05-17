import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreefallerTest {

    private Freefaller freefaller;

    @Before
    public void before() {
        freefaller = new Freefaller("Oblivion", 15.00, 20, 14, 2, 5, 100, 80);
    }

    @Test
    public void hasName() {
        assertEquals("Oblivion", freefaller.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(15.00, freefaller.getPrice(), 0.01);
    }

    @Test
    public void hasTill() {
        assertEquals(0.00, freefaller.getTill(), 0.01);
    }

    @Test
    public void hasCapacity() {
        assertEquals(20, freefaller.getCapacity());
    }

    @Test
    public void hasAgeLimit() {
        assertEquals(14, freefaller.getAgeLimit());
    }

    @Test
    public void hasDuration() {
        assertEquals(2, freefaller.getDuration());
    }

    @Test
    public void hasSpeed() {
        assertEquals(5, freefaller.getSpeed());
    }

    @Test
    public void hasMaxElevation() {
        assertEquals(100, freefaller.getMaxElevation());
    }

    @Test
    public void hasMaxDrop() {
        assertEquals(80, freefaller.getMaxDrop());
    }

    @Test
    public void canGetRidersSize() {
        assertEquals(0, freefaller.getRidersSize());
    }

    @Test
    public void canGetQueuersSize() {
        assertEquals(0, freefaller.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide() {
        Customer customer = new Customer("Ed", 31, 25.00);
        freefaller.addCustomerToRide(customer);
        assertEquals(1, freefaller.getRidersSize());
        assertEquals(15.00, freefaller.getTill(), 0.01);
        assertEquals(10.00, customer.getCash(), 0.01);
    }

    @Test
    public void canAddCustomerToRide__space_unavailable() {
        for (int i = 0; i < 21; i++) {
            Customer customer = new Customer("Ed", 31, 25.00);
            freefaller.addCustomerToRide(customer);
        }
        assertEquals(20, freefaller.getRidersSize());
        assertEquals(1, freefaller.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide__underage() {
        Customer customer = new Customer("Zoe", 2, 20.00);
        freefaller.addCustomerToRide(customer);
        assertEquals(0, freefaller.getRidersSize());
    }

    @Test
    public void canAddCustomerToRide__not_enough_cash() {
        Customer customer = new Customer("Emma", 27, 1.00);
        freefaller.addCustomerToRide(customer);
        assertEquals(0, freefaller.getRidersSize());
    }

    @Test
    public void canGetFreeSpace() {
        Customer customer = new Customer("Ed", 31, 25.00);
        assertEquals(20, freefaller.getFreeSpace());
        freefaller.addCustomerToRide(customer);
        assertEquals(19, freefaller.getFreeSpace());
    }

    @Test
    public void canThrill() {
        Customer customer = new Customer("Ed", 31, 25.00);
        freefaller.thrill(customer);
        assertEquals(100.00, customer.getHappiness(), 0.01);
    }

    @Test
    public void canIncreaseTill() {
        freefaller.increaseTill(10.00);
        assertEquals(10.00, freefaller.getTill(), 0.01);
    }

}
