import java.util.ArrayList;

public class Looper extends Rollercoaster implements IThrill {

    private int loops;
    private ArrayList<Customer> riders;
    private ArrayList<Customer> queuers;

    public Looper(String name, double price, int capacity, int ageLimit, int duration, int speed, int maxElevation, int loops) {
        super(name, price, capacity, ageLimit, duration, speed, maxElevation);
        this.loops = loops;
        this.riders = new ArrayList<>();
        this.queuers = new ArrayList<>();
    }

    public int getLoops() {
        return loops;
    }

    @Override
    public void thrill(Customer customer) {
        double thrill = (getDuration() * getSpeed()) + (getMaxElevation() / 10) + (loops * 10);
        customer.setHappiness(customer.getHappiness() + thrill);
    }
}
