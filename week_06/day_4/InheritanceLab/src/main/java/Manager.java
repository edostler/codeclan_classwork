public class Manager extends Employee {

    private String deptName;

    public Manager(String name, int NI, double salary, String deptName) {
        super(name, NI, salary);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

}
