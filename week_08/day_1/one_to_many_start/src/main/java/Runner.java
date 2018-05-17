//import db.DBDepartment;
//import db.DBEmployee;
import db.DBHelper;
import models.Department;
import models.Employee;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
//        DBEmployee.deleteAll();
//        DBDepartment.deleteAll();

        Department dept1 = new Department("HR");
        DBHelper.saveOrUpdate(dept1);

        Department dept2 = new Department("Sales");
        DBHelper.saveOrUpdate(dept2);

        Employee employee1 = new Employee("Jack", "Jarvis", 25000, dept1);
        DBHelper.saveOrUpdate(employee1);
//        System.out.println("New Employee ID: " + employee1.getId());

        Employee employee2 = new Employee("Isa", "Drennan", 30000, dept2);
        DBHelper.saveOrUpdate(employee2);

        employee2.setSalary(35000);
        DBHelper.saveOrUpdate(employee2);

//        DBHelper.delete(employee1);
        DBHelper.deleteById(employee1.getId(), "Employee");

        List<Employee> employees = DBHelper.getAll("Employee");

//        for(Employee employee : employees){
//            System.out.println("Employee ID: " + employee.getId() + "\nEmployee Name: " + employee.getFirstName() + " " + employee.getLastName() + "\nEmployee Salary: " + employee.getSalary());
//        }

        List<Department> departments = DBHelper.getAll("Department");

//        for(Department department : departments){
//            System.out.println("Dept ID: " + department.getId() + "\nDept Ttile: " + department.getTitle());
//        }

        List<Employee> employeesOfDept1 = DBHelper.getEmployees(dept1.getId());
    }

}