import java.util.ArrayList;

public class River {

    //declarations
    private ArrayList<Salmon> stock;

    //constructor
    public River() {
        this.stock = new ArrayList<>();
    }

    //methods
    public int checkStockSize() {
        return this.stock.size();
    }

    public void addSalmon(Salmon salmon) {
        this.stock.add(salmon);
    }

    public Salmon removeSalmon() {
        return this.stock.remove(0);
    }

}
