import java.util.ArrayList;

public class JointAccount extends Account{

    private ArrayList<Holder> holders;

    public JointAccount(String sort_code, String account_number, ArrayList<Holder> holders) {
        super(sort_code, account_number);
        this.holders = holders;
    }

    public ArrayList<Holder> getHolders() {
        return holders;
    }
}
