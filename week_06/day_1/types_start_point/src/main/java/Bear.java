public class Bear {

    //these are declarations - almost always private
    private String name;
    private int age;
    private double weight;

    //this is a constructor (like initialise)
    public Bear(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    //cmd+n brings up the generate new menu, which allows us to create the below really easily
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean readyToHibernate() {
        return this.weight > 80.00;
    }
}
