import java.util.ArrayList;

public class Freefaller extends Rollercoaster implements IThrill {

    private int maxDrop;
    private ArrayList<Customer> riders;
    private ArrayList<Customer> queuers;

    public Freefaller(String name, double price, int capacity, int ageLimit, int duration, int speed, int maxElevation, int maxDrop) {
        super(name, price, capacity, ageLimit, duration, speed, maxElevation);
        this.maxDrop = maxDrop;
        this.riders = new ArrayList<>();
        this.queuers = new ArrayList<>();
    }

    public int getMaxDrop() {
        return maxDrop;
    }

    @Override
    public void thrill(Customer customer) {
        double thrill = (getDuration() * getSpeed()) + (getMaxElevation() / 10) + maxDrop;
        customer.setHappiness(customer.getHappiness() + thrill);
    }
}
