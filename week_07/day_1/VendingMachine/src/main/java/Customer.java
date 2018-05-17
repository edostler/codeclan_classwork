import java.util.ArrayList;

public class Customer {

    private String name;
    private double cash;
    private ArrayList<Product> inventory;

    public Customer(String name, double cash) {
        this.name = name;
        this. cash = cash;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getCustomerCash() {
        return cash;
    }

    public int inventoryEmptyInitially() {
        return this.inventory.size();
    }

}
