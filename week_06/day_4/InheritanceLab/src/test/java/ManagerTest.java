import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    private Manager manager;

    @Before
    public void before() {
        manager = new Manager("Jack", 123, 33000, "Glasgow");
    }

    @Test
    public void hasName() {
        assertEquals("Jack", manager.getName());
    }

    @Test
    public void hasNI() {
        assertEquals(123, manager.getNI());
    }

    @Test
    public void hasSalary() {
        assertEquals(33000, manager.getSalary(), 0.01);
    }

    @Test
    public void hasDeptName() {
        assertEquals("Glasgow", manager.getDeptName());
    }

    @Test
    public void canRaiseSalary__positive() {
        manager.raiseSalary(10000);
        assertEquals(43000.00, manager.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__negative() {
        manager.raiseSalary(-10000);
        assertEquals(33000.00, manager.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(330, manager.payBonus(), 0.01);
    }

    @Test
    public void canSetName__not_null() {
        manager.setName("Ed");
        assertEquals("Ed", manager.getName());
    }

    @Test
    public void canSetName__null() {
        manager.setName(null);
        assertEquals("Jack", manager.getName());
    }

}
