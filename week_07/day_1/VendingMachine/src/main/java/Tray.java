import java.util.ArrayList;

public class Tray {

    private ArrayList<Product> stock;
    private double price;
    private int capacity;

    public Tray(double price, int capacity) {
        this.price = price;
        this.capacity = capacity;
        this.stock = new ArrayList<>();
    }

    public double getPrice() {
        return price;
    }

    public int getStockSize() {
        return this.stock.size();
    }

    public void addItemToStock(Product product) {
        if (getStockSize() < this.capacity) {
            this.stock.add(product);
        }
    }

    public Product removeItemFromStock() {
        return this.stock.remove(0);
    }

    public int getCapacity() {
        return this.capacity;
    }

}


