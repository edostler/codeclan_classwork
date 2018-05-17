import Components.*;
import Enums.ComponentList;
import Enums.ItemList;
import Items.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    private Amplifier amplifier;
    private DrumStick drumStick;
    private InstrumentCase instrumentCase;
    private InstrumentStand instrumentStand;
    private MusicBook musicBook;
    private Plectrum plectrum;

    @Before
    public void before() {
        amplifier = new Amplifier(
                ItemList.AMPLIFIER.getItemName(),
                ItemList.AMPLIFIER.getItemBuyingPrice());
        drumStick = new DrumStick(
                ItemList.DRUMSTICK.getItemName(),
                ItemList.DRUMSTICK.getItemBuyingPrice());
        instrumentCase = new InstrumentCase(
                ItemList.INSTRUMENTCASE.getItemName(),
                ItemList.INSTRUMENTCASE.getItemBuyingPrice());
        instrumentStand = new InstrumentStand(
                ItemList.INSTRUMENTSTAND.getItemName(),
                ItemList.INSTRUMENTSTAND.getItemBuyingPrice());
        musicBook = new MusicBook(
                ItemList.MUSICBOOK.getItemName(),
                ItemList.MUSICBOOK.getItemBuyingPrice());
        plectrum = new Plectrum(
                ItemList.PLECTRUM.getItemName(),
                ItemList.PLECTRUM.getItemBuyingPrice());
    }

    @Test
    public void hasProductName() {
        assertEquals("Amplifier", amplifier.getProductName());
    }

    @Test
    public void hasBuyingPrice() {
        assertEquals(30, amplifier.getBuyingPrice(), 0.01);
    }

    @Test
    public void hasSellingPrice() {
        assertEquals(45, amplifier.getSellingPrice(), 0.01);
    }

}
