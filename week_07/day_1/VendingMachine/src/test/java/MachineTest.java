import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MachineTest {

    private Machine machine;

    @Before
    public void before() {
        HashMap<Selection, Tray> selections = new HashMap<>();
        for (Selection selection : Selection.values()) {
            Tray tray = new Tray(0.50, 10);
            for (int i = 0; i < 5; i++) {
                Sweet twix = new Sweet("Twix", 35);
                tray.addItemToStock(twix);
            }
            selections.put(selection, tray);
        }
        machine = new Machine(selections, 10.00);
    }

    @Test
    public void testCoinsAddToCredit() {
        machine.addMoney(0.75);
        assertEquals(0.75, machine.getCredit(), 0.01);
        assertEquals(10.00, machine.getCash(), 0.01);
    }

    @Test
    public void testMachineCanGiveRefund() {
        machine.addMoney(1.50);
        double refunded = machine.giveRefund();
        assertEquals(0.00, machine.getCredit(), 0.01);
        assertEquals(1.50, refunded, 0.01);
        assertEquals(10.00, machine.getCash(), 0.01);
    }

    @Test
    public void testStockLevelOfTray() {
        assertEquals(5, machine.getStockLevelForTray(Selection.A1));
    }

    @Test
    public void testVendingMachineCanGiveItem__exact_change() {
        machine.addMoney(0.50);
        Product product = machine.vend(Selection.A1);
        assertEquals(4, machine.getStockLevelForTray(Selection.A1));
        assertEquals(10.50, machine.getCash(), 0.01);
        assertEquals(0.00, machine.getCredit(), 0.01);
        //using an assert method to check that the assertion passes
        assert(product instanceof Sweet);
        assertEquals("Twix", product.getName());
    }

    @Test
    public void testVendingMachineCanGiveItem__not_exact_change() {
        machine.addMoney(0.55);
        Product product = machine.vend(Selection.A1);
        assertEquals(4, machine.getStockLevelForTray(Selection.A1));
        assertEquals(10.50, machine.getCash(), 0.01);
        assertEquals(0.05, machine.getCredit(), 0.01);
        assert(product instanceof Sweet);
        assertEquals("Twix", product.getName());
    }

    @Test
    public void testVendingMachineCanGiveItem__item_not_in_stock() {
        machine.addMoney(3.00);
        for (int i = 0; i < 6; i++) {
            machine.vend(Selection.A1);
        }
        assertEquals(0.50, machine.getCredit(), 0.01);
    }

}
