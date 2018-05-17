package Treasures;

public abstract class Treasure {

    private String type;

    public Treasure(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
