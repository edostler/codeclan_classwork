import behaviours.IMonthlyCharge;

import java.util.ArrayList;

public abstract class Account {

    private String sort_code;
    private String account_number;
    private double balance;
    private ArrayList<IMonthlyCharge> monthlyCharges;

    public Account(String sort_code, String account_number) {
        this.sort_code = sort_code;
        this.account_number = account_number;
        this.balance = 0;
        this.monthlyCharges = new ArrayList<>();
    }

    public String getSort_code() {
        return sort_code;
    }

    public String getAccount_number() {
        return account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0 ) {
            this.balance += amount;
        }
    }

    public double getAvailableFunds() {
        return this.balance + 150;
    }

    public void withdraw(double amount) throws Exception {
        if(getAvailableFunds() >= amount){
            this.balance -= amount;
        }
        else {
            throw new Exception("Error in withdrawing funds, withdrawal cancelled");
        }
    }

    public void transfer(PersonalAccount otherAccount, double amount) throws Exception {
        withdraw(amount);
        otherAccount.deposit(amount);
    }

    public void addMonthlyCharge(IMonthlyCharge charge) {
        this.monthlyCharges.add(charge);
    }

    public ArrayList<IMonthlyCharge> getMonthlyCharges() {
        return new ArrayList<>(monthlyCharges);
    }

    public double getMonthlyChargeTotal() {
        double runningTotal = 0;
        for(IMonthlyCharge charge: monthlyCharges) {
            runningTotal += charge.getAmount();
        }
        return runningTotal;
    }

    public void applyChargesAndInterest() {
        applyCharges();
        applyInterestOrFees();
    }

    private void applyInterestOrFees() {
        if (this.balance > 0) {
            this.balance += balance * 0.05;
        }
        else if (this.balance < -150) {
            balance -= 150;
        }
    }

    private void applyCharges() {
        this.balance -= getMonthlyChargeTotal();
    }
}
