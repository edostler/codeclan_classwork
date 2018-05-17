import behaviours.IMonthlyCharge;

public class StandingOrder implements IMonthlyCharge {

    private double amount;
    private String recipient;

    public StandingOrder(double amount, String recipient) {
        this.amount = amount;
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
