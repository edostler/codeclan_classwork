import db.DBEmployee;
import models.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Ed Ostler", 18000.00);
        Employee employee2 = new Employee("Phil Ostler", 18000.00);
        DBEmployee.save(employee1);
        DBEmployee.save(employee2);
        List<Employee> foundEmployees = DBEmployee.getEmployees();
        Employee firstEmployee = foundEmployees.get(0);
    }
}
