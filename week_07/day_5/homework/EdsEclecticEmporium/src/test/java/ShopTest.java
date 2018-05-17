import Enums.Colour;
import Enums.InstrumentList;
import Instruments.AcousticGuitar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private AcousticGuitar acousticGuitar;

    @Before
    public void before() {
        shop = new Shop("Ed's Eclectic Emporium", 500.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Ed's Eclectic Emporium", shop.getName());
    }

    @Test
    public void canGetTill() {
        assertEquals(500, shop.getTill(), 0.01);
    }

    @Test
    public void canGetProfit() {
        assertEquals(0, shop.getProfit(), 0.01);
    }

    @Test
    public void canGetProductsSize() {
        assertEquals(0, shop.getProductsSize());
    }

    @Test
    public void canAddProduct() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());
        shop.addProduct(acousticGuitar);
        assertEquals(1, shop.getProductsSize());
    }

    @Test
    public void canRemoveProduct() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());
        shop.addProduct(acousticGuitar);
        assertEquals(1, shop.getProductsSize());
        shop.removeProduct(acousticGuitar);
        assertEquals(0, shop.getProductsSize());
    }

    @Test
    public void canAddToTill() {
        shop.addToTill(10.00);
        assertEquals(510, shop.getTill(), 0.01);
    }

    @Test
    public void canRemoveFromTill() {
        shop.removeFromTill(10.00);
        assertEquals(490, shop.getTill(), 0.01);
    }

    @Test
    public void canAddToProfit() {
        shop.addToProfit(10.00);
        assertEquals(10, shop.getProfit(), 0.01);
    }

    @Test
    public void canRemoveFromProfit() {
        shop.removeFromProfit(10.00);
        assertEquals(-10, shop.getProfit(), 0.01);
    }

    @Test
    public void canBuyProduct() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());
        shop.buyProduct(acousticGuitar);
        assertEquals(1, shop.getProductsSize());
        assertEquals(380, shop.getTill(), 0.01);
        assertEquals(-120, shop.getProfit(), 0.01);
    }

    @Test
    public void canSellProduct() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());
        shop.addProduct(acousticGuitar);
        shop.sellProduct(acousticGuitar);
        assertEquals(0, shop.getProductsSize());
        assertEquals(620, shop.getTill(), 0.01);
        assertEquals(120, shop.getProfit(), 0.01);
    }

}
