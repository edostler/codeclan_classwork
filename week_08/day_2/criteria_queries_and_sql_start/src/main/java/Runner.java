import db.DBHelper;
import models.Department;
import models.Employee;

import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {

        Department dept1 = new Department("HR");
        DBHelper.save(dept1);

        Department dept2 = new Department("Sales");
        DBHelper.save(dept2);

        Employee employee1 = new Employee("Bruce", "Wayne", 150000, dept1);
        DBHelper.save(employee1);

        Employee employee2 = new Employee("Clark", "Kent", 80000, dept2);
        DBHelper.save(employee2);

        Employee employee3 = new Employee("Diana" ,"Prince", 95000, dept1);
        DBHelper.save(employee3);

        Employee employee4 = new Employee("Arthur", "Curry", 60000, dept2);
        DBHelper.save(employee4);

        Employee employee5 = new Employee("Barry", "Allen", 45000, dept1);
        DBHelper.save(employee5);

        List<Employee> employees = DBHelper.getAll(Employee.class);
        List<Department> departments = DBHelper.getAll(Department.class);

        Employee foundEmployee = DBHelper.findById(Employee.class, employee3.getId());
        Department foundDepartment = DBHelper.findById(Department.class, dept2.getId());

        List<Employee> richEmployees = DBHelper.findBySalaryGreaterThan(50000);

        List<Employee> employeesBySalary = DBHelper.orderBySalary();

        Double averageSalary = DBHelper.getAverageSalary();


    }
}