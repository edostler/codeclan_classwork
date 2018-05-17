import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdminTest {

    private DatabaseAdmin databaseAdmin;

    @Before
    public void before() {
        databaseAdmin = new DatabaseAdmin("Navid", 121, 28000);
    }

    @Test
    public void hasName() {
        assertEquals("Navid", databaseAdmin.getName());
    }

    @Test
    public void hasNI() {
        assertEquals(121, databaseAdmin.getNI());
    }

    @Test
    public void hasSalary() {
        assertEquals(28000, databaseAdmin.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__positive() {
        databaseAdmin.raiseSalary(10000);
        assertEquals(38000.00, databaseAdmin.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__negative() {
        databaseAdmin.raiseSalary(-10000);
        assertEquals(28000.00, databaseAdmin.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(280, databaseAdmin.payBonus(), 0.01);
    }

    @Test
    public void canSetName__not_null() {
        databaseAdmin.setName("Ed");
        assertEquals("Ed", databaseAdmin.getName());
    }

    @Test
    public void canSetName__null() {
        databaseAdmin.setName(null);
        assertEquals("Navid", databaseAdmin.getName());
    }

}
