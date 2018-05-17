import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectorTest {

    private Director director;

    @Before
    public void before() {
        director = new Director("Victor", 122, 53000, "Glasgow", 5000);
    }

    @Test
    public void hasName() {
        assertEquals("Victor", director.getName());
    }

    @Test
    public void hasNI() {
        assertEquals(122, director.getNI());
    }

    @Test
    public void hasSalary() {
        assertEquals(53000, director.getSalary(), 0.01);
    }

    @Test
    public void hasDeptName() {
        assertEquals("Glasgow", director.getDeptName());
    }

    @Test
    public void canRaiseSalary__positive() {
        director.raiseSalary(10000);
        assertEquals(63000.00, director.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary__negative() {
        director.raiseSalary(-10000);
        assertEquals(53000.00, director.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(1060, director.payBonus(), 0.01);
    }

    @Test
    public void hasBudget() {
        assertEquals(5000, director.getBudget(), 0.01);
    }

    @Test
    public void canSetName__not_null() {
        director.setName("Ed");
        assertEquals("Ed", director.getName());
    }

    @Test
    public void canSetName__null() {
        director.setName(null);
        assertEquals("Victor", director.getName());
    }

}
