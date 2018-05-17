package ParentClasses;

public abstract class Component extends Product {

    private String sound;

    public Component(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice);
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

}
