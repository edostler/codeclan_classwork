import db.DBHelper;
import models.Department;
import models.Employee;
import models.Engineer;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Department department = new Department("Products");
        DBHelper.saveOrUpdate(department);

        Manager manager = new Manager("Ed", "Ostler", 40000, department, 1000000);
        DBHelper.saveOrUpdate(manager);

        Engineer engineer1 = new Engineer("Phil", "Ostler", 30000, department);
        DBHelper.saveOrUpdate(engineer1);
        Engineer engineer2 = new Engineer("Emma", "Lawrie", 30000, department);
        DBHelper.saveOrUpdate(engineer2);

        Manager foundManager = DBHelper.find(Manager.class, manager.getId());

        List<Engineer> foundEngineers = DBHelper.getAll(Engineer.class);

        Manager departmentManager = DBHelper.getManagerOfDepartment(department);

        List<Employee> employees = DBHelper.getEmployeesOfDepartment(department);
        List<Employee> employees2 = DBHelper.getEmployeesOfDepartment2(department);
    }
}
