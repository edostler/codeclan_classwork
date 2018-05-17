import db.DBHelper;
import models.Department;
import models.Employee;
import models.Project;

public class Runner {

    public static void main(String[] args) {

        Department dept1 = new Department("HR");
        DBHelper.save(dept1);
        Department dept2 = new Department("Sales");
        DBHelper.save(dept2);

        Employee employee1 = new Employee("Al", "Bundy", 35000, dept1);
        DBHelper.save(employee1);

        Employee employee2 = new Employee("Peggy", "Bundy", 50000, dept1);
        DBHelper.save(employee2);

        Project project1 = new Project("Employee System");
        DBHelper.save(project1);

        DBHelper.addEmployeeToProject(employee1, project1);
        DBHelper.addEmployeeToProject(employee2, project1);


        Project foundProject = DBHelper.find(Project.class, project1.getId());
    }
}
