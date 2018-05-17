import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeveloperTest {

    private Developer developer;

    @Before
    public void before() {
        developer = new Developer("Bobby", 120, 23000);
    }

    @Test
    public void hasName() {
        assertEquals("Bobby", developer.getName());
    }

    @Test
    public void hasNI() {
        assertEquals(120, developer.getNI());
    }

    @Test
    public void hasSalary() {
        assertEquals(23000, developer.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__positive() {
        developer.raiseSalary(10000);
        assertEquals(33000.00, developer.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__negative() {
        developer.raiseSalary(-10000);
        assertEquals(23000.00, developer.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(230, developer.payBonus(), 0.01);
    }

    @Test
    public void canSetName__not_null() {
        developer.setName("Ed");
        assertEquals("Ed", developer.getName());
    }

    @Test
    public void canSetName__null() {
        developer.setName(null);
        assertEquals("Bobby", developer.getName());
    }

}
