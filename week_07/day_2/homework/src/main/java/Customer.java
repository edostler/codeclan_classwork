public class Customer {

    private String name;
    private int age;
    private double cash;
    private double happiness;
    private int rideTime;
    private int queueTime;

    public Customer(String name, int age, double cash) {
        this.name = name;
        this.age = age;
        this.cash = cash;
        this.happiness = 0.00;
        this.rideTime = 0;
        this.queueTime = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getCash() {
        return cash;
    }

    public double getHappiness() {
        return happiness;
    }

    public void setHappiness(double happiness) {
        this.happiness = happiness;
    }

    public int getRideTime() {
        return rideTime;
    }

    public void setRideTime(int rideTime) {
        this.rideTime = rideTime;
    }

    public int getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(int queueTime) {
        this.queueTime = queueTime;
    }

    public void reduceCash(double fee) {
        this.cash -= fee;
    }

}
