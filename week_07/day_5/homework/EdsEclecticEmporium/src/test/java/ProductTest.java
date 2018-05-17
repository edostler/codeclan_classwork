import Components.BassDrum;
import Enums.Colour;
import Enums.ComponentList;
import Enums.InstrumentList;
import Enums.ItemList;
import Instruments.AcousticGuitar;
import Items.Amplifier;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private AcousticGuitar acousticGuitar;
    private BassDrum bassDrum;
    private Amplifier amplifier;

    @Before
    public void before() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());

        bassDrum = new BassDrum(
                ComponentList.BASSDRUM.getComponentName(),
                ComponentList.BASSDRUM.getComponentBuyingPrice(),
                ComponentList.BASSDRUM.getComponentSound());

        amplifier = new Amplifier(
                ItemList.AMPLIFIER.getItemName(),
                ItemList.AMPLIFIER.getItemBuyingPrice());
    }

    @Test
    public void canCalculateMarkup__instrument() {
        assertEquals(60, acousticGuitar.calculateMarkup(), 0.01);
    }
    @Test
    public void canCalculateMarkup__component() {
        assertEquals(20, bassDrum.calculateMarkup(), 0.01);
    }
    @Test
    public void canCalculateMarkup__item() {
        assertEquals(15, amplifier.calculateMarkup(), 0.01);
    }

}
