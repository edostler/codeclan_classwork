public class PersonalAccount extends Account {

    private Holder holder;

    public PersonalAccount(String sort_code, String account_number, Holder holder) {
        super(sort_code, account_number);
        this.holder = holder;
    }

    public Holder getHolder() {
        return this.holder;
    }
}
