import models.Employee;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    public Employee employee;

    @Before
    public void before() {
        employee = new Employee("Ed Ostler", 18000.00);
    }

    @Test
    public void hasName () throws Exception {
        assertEquals("Ed Ostler", employee.getName());
    }

    @Test
    public void hasSalary() throws Exception {
        assertEquals(18000.00, employee.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary() throws Exception {
        employee.raiseSalary(2000.00);
        assertEquals(20000.00, employee.getSalary(), 0.01);
    }

}
