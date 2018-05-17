import java.util.HashMap;

public class Machine {

    private HashMap<Selection, Tray> selections;
    private double cash;
    private double credit;

    public Machine(HashMap<Selection, Tray> selections, double cash) {
        this.selections = selections;
        this.cash = cash;
        this.credit = 0.00;
    }

    public double getCash() {
        return cash;
    }

    public double getCredit() {
        return credit;
    }

    public void addMoney(double amountEntered) {
        credit += amountEntered;
    }

    public double giveRefund() {
        double currentCredit = getCredit();
        credit = 0;
        return currentCredit;
    }

    public int getStockLevelForTray(Selection selection) {
        return selections.get(selection).getStockSize();
    }

    public Product vend(Selection selection) {
        Tray tray = selections.get(selection);
        Product product = null;
        if (credit >= tray.getPrice()) {
            if (tray.getStockSize() > 0) {
                cash += tray.getPrice();
                credit -= tray.getPrice();
                product = tray.removeItemFromStock();
            }
        }
        return product;
    }
}
