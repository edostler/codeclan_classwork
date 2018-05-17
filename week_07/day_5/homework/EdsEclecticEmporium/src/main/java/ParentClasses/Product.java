package ParentClasses;

public abstract class Product{

    private String productName;
    private double buyingPrice;
    private double sellingPrice;

    public Product(String productName, double buyingPrice) {
        this.productName = productName;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = buyingPrice * 1.5;
    }

    public String getProductName() {
        return productName;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double calculateMarkup() {
        return this.sellingPrice - this.buyingPrice;
    }

}
