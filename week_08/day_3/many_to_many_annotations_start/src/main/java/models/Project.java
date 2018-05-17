package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projects")
public class Project {

    private int id;
    private String title;
    private Set<Employee> employees;

    public Project() {
    }

    public Project(String title) {
        this.title = title;
        this.employees = new HashSet<Employee>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    public Set<Employee> getEmployeees() {
        return employees;
    }

    public void setEmployeees(Set<Employee> employeees) {
        this.employees = employeees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
