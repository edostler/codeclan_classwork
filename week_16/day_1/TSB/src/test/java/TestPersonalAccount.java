import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TestPersonalAccount {

    private PersonalAccount personal_account;
    private PersonalAccount personal_account2;
    private Holder ed;
    private Holder phil;

    @Before
    public void setUp() throws Exception {
        String sort_code = "45-13-24";
        String account_number = "00123325";
        String account_number2 = "00123344";
        ed = new Holder("Ed Ostler", "51 Rampart Avenue");
        phil = new Holder("Phil Ostler", "Sholtsgate");
        personal_account = new PersonalAccount(sort_code, account_number, ed);
        personal_account2 = new PersonalAccount(sort_code, account_number2, phil);
    }

    @Test
    public void testSort_code() {
        assertEquals("45-13-24", personal_account.getSort_code());
    }

    @Test
    public void testAccount_number() {
        assertEquals("00123325", personal_account.getAccount_number());
    }

    @Test
    public void testOpeningBalance() {
        assertEquals(0.0, personal_account.getBalance(), 0.1);

    }

    @Test
    public void testHolder() {
        assertEquals(ed, personal_account.getHolder());
    }

    @Test
    public void testDeposit__positive() {
        personal_account.deposit(100);
        assertEquals(100.0, personal_account.getBalance(), 0.1);
    }

    @Test
    public void testDeposit__negative() {
        personal_account.deposit(-100);
        assertEquals(0.0, personal_account.getBalance(), 0.1);
    }

    @Test
    public void testWithdrawal() {
        personal_account.deposit(100);
        try {
            personal_account.withdraw(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(50.0, personal_account.getBalance(), 0.1);
    }

    @Test
    public void testWithdrawal__intoOverdraft() {
        try {
            personal_account.withdraw(150);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(-150.0, personal_account.getBalance(), 0.1);
    }

    @Test
    public void testWithdrawal__beyondOverdraft() {
        try {
            personal_account.withdraw(200);
            fail();
        } catch (Exception e) {
        }
    }

    @Test
    public void testTransfer() {
        personal_account.deposit(1000);
        try {
            personal_account.transfer(personal_account2, 650);
            assertEquals(350.0, personal_account.getBalance(), 0.1);
            assertEquals(650.0, personal_account2.getBalance(), 0.1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTransfer__insufficientFunds() {
        try {
            personal_account.transfer(personal_account2, 200);
            fail();
        } catch (Exception e) {
        }

    }

    @Test
    public void testAddStandingOrder() {
        StandingOrder so = new StandingOrder(50, "Dad");
        personal_account.addMonthlyCharge(so);
        assertEquals(1, personal_account.getMonthlyCharges().size());
    }

    @Test
    public void testGetMonthlyTotal() {
        StandingOrder so1 = new StandingOrder(50, "Dad");
        StandingOrder so2 = new StandingOrder(100, "Wedding");
        personal_account.addMonthlyCharge(so1);
        personal_account.addMonthlyCharge(so2);
        assertEquals(150, personal_account.getMonthlyChargeTotal(), 0.1);
    }

    @Test
    public void testMonthlyChargesAreApplied() {
        personal_account.deposit(100);
        StandingOrder so1 = new StandingOrder(50, "Dad");
        StandingOrder so2 = new StandingOrder(10, "Wedding");
        personal_account.addMonthlyCharge(so1);
        personal_account.addMonthlyCharge(so2);
        personal_account.applyChargesAndInterest();

        assertEquals(42, personal_account.getBalance(), 0.1);
    }
    @Test
    public void testMonthlyFeesAreApplied() {
        StandingOrder so1 = new StandingOrder(400, "Rent");
        personal_account.addMonthlyCharge(so1);
        personal_account.applyChargesAndInterest();

        assertEquals(-550, personal_account.getBalance(), 0.1);
    }
}
