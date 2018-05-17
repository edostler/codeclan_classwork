public class Director extends Manager {

    private double budget;

    public Director(String name, int NI, double salary, String deptName, double budget) {
        super(name, NI, salary, deptName);
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public double payBonus() {
        return getSalary()*0.02;
    }

}
