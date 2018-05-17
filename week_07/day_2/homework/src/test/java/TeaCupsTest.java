import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeaCupsTest {

    private TeaCups teacups;

    @Before
    public void before() {
        teacups = new TeaCups("Teddy Bears' Picnic", 5.00, 12, 1, 10, 2);
    }

    @Test
    public void hasName() {
        assertEquals("Teddy Bears' Picnic", teacups.getName());
    }

    @Test
    public void hasPrice() {
        assertEquals(5.00, teacups.getPrice(), 0.01);
    }

    @Test
    public void hasTill() {
        assertEquals(0.00, teacups.getTill(), 0.01);
    }

    @Test
    public void hasCapacity() {
        assertEquals(12, teacups.getCapacity());
    }

    @Test
    public void hasAgeLimit() {
        assertEquals(1, teacups.getAgeLimit());
    }

    @Test
    public void hasDuration() {
        assertEquals(10, teacups.getDuration());
    }

    @Test
    public void hasSpeed() {
        assertEquals(2, teacups.getSpeed());
    }

    @Test
    public void canGetRidersSize() {
        assertEquals(0, teacups.getRidersSize());
    }

    @Test
    public void canGetQueuersSize() {
        assertEquals(0, teacups.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide() {
        Customer customer = new Customer("Ed", 31, 25.00);
        teacups.addCustomerToRide(customer);
        assertEquals(1, teacups.getRidersSize());
        assertEquals(5.00, teacups.getTill(), 0.01);
        assertEquals(20.00, customer.getCash(), 0.01);
    }

    @Test
    public void canAddCustomerToRide__space_unavailable() {
        for (int i = 0; i < 13; i++) {
            Customer customer = new Customer("Ed", 31, 25.00);
            teacups.addCustomerToRide(customer);
        }
        assertEquals(12, teacups.getRidersSize());
        assertEquals(1, teacups.getQueuersSize());
    }

    @Test
    public void canAddCustomerToRide__not_enough_cash() {
        Customer customer = new Customer("Emma", 27, 1.00);
        teacups.addCustomerToRide(customer);
        assertEquals(0, teacups.getRidersSize());
    }

    @Test
    public void canGetFreeSpace() {
        Customer customer = new Customer("Ed", 31, 25.00);
        assertEquals(12, teacups.getFreeSpace());
        teacups.addCustomerToRide(customer);
        assertEquals(11, teacups.getFreeSpace());
    }

    @Test
    public void canThrill() {
        Customer customer = new Customer("Ed", 31, 25.00);
        teacups.thrill(customer);
        assertEquals(20.00, customer.getHappiness(), 0.01);
    }

    @Test
    public void canIncreaseTill() {
        teacups.increaseTill(10.00);
        assertEquals(10.00, teacups.getTill(), 0.01);
    }

//    @Test
//    public void canGetRiders() {
//        assertEquals(null, teacups.getRiders());
//    }

//    @Test
//    public void canRemoveCustomersFromRide() {
//        Customer customer = new Customer("Ed", 31, 25.00);
//        teacups.addCustomerToRide(customer);
//        assertEquals(1, teacups.getRidersSize());
//        teacups.removeCustomersFromRide();
//        assertEquals(0, teacups.getRidersSize());
//        assertEquals(0, teacups.getRidersSize());
//        assertEquals(20.00, customer.getHappiness(), 0.01);
//    }

    @Test
    public void canRemoveCustomersFromRide() {
        Customer customer = new Customer("Ed", 31, 25.00);
        teacups.addCustomerToRide(customer);
        assertEquals(1, teacups.getRidersSize());
        teacups.removeCustomersFromRide();
        assertEquals(0, teacups.getRidersSize());
    }

}
