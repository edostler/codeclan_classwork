package models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name="employees")
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Manager manager;
    private Calendar date;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int salary, Manager manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.manager = manager;
        this.date = new GregorianCalendar();
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

    @Column(name="first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @ManyToOne
    @JoinColumn(name="manager_id", nullable = false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Column(name="date")
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setDate2(int day, int month, int year) {
        date.set(Calendar.DAY_OF_MONTH,day);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.YEAR,year);
    }
}
