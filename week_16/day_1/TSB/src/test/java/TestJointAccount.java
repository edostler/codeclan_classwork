import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestJointAccount {

    private JointAccount joint_account;
    private PersonalAccount personal_account2;
    private Holder ed;
    private Holder emma;
    private Holder phil;
    private ArrayList<Holder> holders;

    @Before
    public void setUp() throws Exception {
        String sort_code = "45-13-24";
        String account_number = "00123325";
        ed = new Holder("Ed Ostler", "51 Rampart Avenue");
        emma = new Holder("Emma Lawrie", "51 Rampart Avenue");
        holders = new ArrayList<Holder>();
        holders.add(ed);
        holders.add(emma);
        joint_account = new JointAccount(sort_code, account_number, holders);

        String account_number2 = "00123344";
        phil = new Holder("Phil Ostler", "Sholtsgate");
        personal_account2 = new PersonalAccount(sort_code, account_number2, phil);
    }

    @Test
    public void testHolders() {
        assertEquals(holders, joint_account.getHolders());
    }
}
