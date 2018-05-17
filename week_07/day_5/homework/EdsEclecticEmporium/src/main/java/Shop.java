import ParentClasses.Product;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<Product> products;
    private Double till;
    private Double profit;

    public Shop(String name, Double till) {
        this.name = name;
        this.till = till;
        this.products = new ArrayList<>();
        this.profit = 0.00;
    }

    public String getName() {
        return name;
    }

    public Double getTill() {
        return till;
    }

    public Double getProfit() {
        return profit;
    }

    public int getProductsSize() {
        return products.size();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addToTill(Double cash) {
        till += cash;
    }

    public void removeFromTill(Double cash) {
        till -= cash;
    }

    public void addToProfit(Double cash) {
        profit += cash;
    }

    public void removeFromProfit(Double cash) {
        profit -= cash;
    }

    public void buyProduct(Product product) {
        products.add(product);
        till -= product.getBuyingPrice();
        profit -= product.getBuyingPrice();
    }

    public void sellProduct(Product product) {
        products.remove(product);
        till += product.getBuyingPrice();
        profit += product.getBuyingPrice();
    }
}
