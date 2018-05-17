import db.DBHelper;
import models.Department;
import models.Employee;
import models.Manager;
import sun.nio.cs.ext.GB18030;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager1 = new Manager("Ed", "Ostler",60000, 100000);
        DBHelper.save(manager1);
        Manager manager2 = new Manager("Phil", "Ostler",80000, 120000);
        DBHelper.save(manager2);

        Department dept1 = new Department("HR", manager1);
        DBHelper.save(dept1);
        Department dept2 = new Department("Sales", manager2);
        DBHelper.save(dept2);

        Employee employee1 = new Employee("Al", "Bundy", 35000, manager1);
        employee1.setDate2(10,9,2018);
        DBHelper.save(employee1);
        Employee employee2 = new Employee("Peggy", "Bundy", 50000, manager2);
        DBHelper.save(employee2);
        Department foundDepartment = DBHelper.find(Department.class, dept1.getId());
        Employee foundEmployee = DBHelper.find(Employee.class, employee1.getId());
        Manager foundManager = DBHelper.find(Manager.class, manager1.getId());


        List<Employee> results = DBHelper.getEmployeeByManager(manager1);

        Manager found = DBHelper.find(Manager.class, manager1.getId());
        found.giveRaise();
        DBHelper.update(found);
    }
}
