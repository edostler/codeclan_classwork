import java.util.ArrayList;

public class TeaCups extends Ride implements IThrill {

    private ArrayList<Customer> riders;
    private ArrayList<Customer> queuers;

    public TeaCups(String name, double price, int capacity, int ageLimit, int duration, int speed) {
        super(name, price, capacity, ageLimit, duration, speed);
        this.riders = new ArrayList<>();
        this.queuers = new ArrayList<>();
    }

    @Override
    public void thrill(Customer customer) {
        double thrill = (getDuration() * getSpeed());
        customer.setHappiness(customer.getHappiness() + thrill);
    }

//    public void removeCustomersFromRide() {
//        for (Customer customer : riders) {
//            thrill(customer);
//        }
//        riders.clear();
//    }
//    public void removeCustomersFromRide() {
//        this.riders.clear();
//    }

}
