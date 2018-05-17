package models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="employees")
public  class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Department department;
    private Set<Project> projects;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.projects = new HashSet<Project>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name="employee_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="project_id", nullable = false, updatable = false)}
    )
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }
}
