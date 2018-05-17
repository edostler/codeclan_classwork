import java.util.ArrayList;

public abstract class Rollercoaster extends Ride {

    private int maxElevation;
    private ArrayList<Customer> riders;
    private ArrayList<Customer> queuers;


    public Rollercoaster(String name, double price, int capacity, int ageLimit, int duration, int speed, int maxElevation) {
        super(name, price, capacity, ageLimit, duration, speed);
        this.maxElevation = maxElevation;
        this.riders = new ArrayList<>();
        this.queuers = new ArrayList<>();
    }

    public int getMaxElevation() {
        return maxElevation;
    }

}
