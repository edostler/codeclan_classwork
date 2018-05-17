import java.util.ArrayList;

public abstract class Ride {

    private String name;
    private double price;
    private double till;
    private int capacity;
    private int ageLimit;
    private int duration;
    private int speed;
    private ArrayList<Customer> riders;
    private ArrayList<Customer> queuers;

    public Ride(String name, double price, int capacity, int ageLimit, int duration, int speed) {
        this.name = name;
        this.price = price;
        this.till = 0;
        this.capacity = capacity;
        this.ageLimit = ageLimit;
        this.duration = duration;
        this.speed = speed;
        this.riders = new ArrayList<>();
        this.queuers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTill() {
        return till;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public int getDuration() {
        return duration;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRidersSize() {
        return riders.size();
    }

    public int getQueuersSize() {
        return queuers.size();
    }

    public void addCustomerToRide(Customer customer) {
        if (customer.getAge() >= getAgeLimit() &&  customer.getCash() >= getPrice()) {
            if (getFreeSpace() > 0) {
                riders.add(customer);
            }
            else {
                queuers.add(customer);
            }
            payForRide(customer);
        }
    }

    public int getFreeSpace() {
        return getCapacity() - getRidersSize();
    }

    public void payForRide(Customer customer) {
        customer.reduceCash(price);
        increaseTill(price);
    }

    public void increaseTill(double fee) {
        this.till += fee;
    }

    public ArrayList<Customer> getRiders() {
        return riders;
    }

    public void removeCustomersFromRide() {
        this.riders.clear();
    }
}
