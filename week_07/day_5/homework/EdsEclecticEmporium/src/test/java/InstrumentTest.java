import Components.*;
import Enums.Colour;
import Enums.ComponentList;
import Enums.InstrumentList;
import Instruments.*;
import ParentClasses.Component;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {

    private AcousticGuitar acousticGuitar;
    private DrumKit drumKit;
    private ElectricGuitar electricGuitar;
    private Piano piano;
    private Trumpet trumpet;

    @Before
    public void before() {
        acousticGuitar = new AcousticGuitar(
                InstrumentList.ACOUSTICGUITAR.getInstrumentName(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ACOUSTICGUITAR.getInstrumentType(),
                Colour.RED.getColour());
        drumKit = new DrumKit(
                InstrumentList.DRUMKIT.getInstrumentName(),
                InstrumentList.DRUMKIT.getInstrumentBuyingPrice(),
                InstrumentList.DRUMKIT.getInstrumentType(),
                Colour.PURPLE.getColour());
        electricGuitar = new ElectricGuitar(
                InstrumentList.ELECTRICGUITAR.getInstrumentName(),
                InstrumentList.ELECTRICGUITAR.getInstrumentBuyingPrice(),
                InstrumentList.ELECTRICGUITAR.getInstrumentType(),
                Colour.BLUE.getColour());
        piano = new Piano(
                InstrumentList.PIANO.getInstrumentName(),
                InstrumentList.PIANO.getInstrumentBuyingPrice(),
                InstrumentList.PIANO.getInstrumentType(),
                Colour.BLACK.getColour());
        trumpet = new Trumpet(
                InstrumentList.TRUMPET.getInstrumentName(),
                InstrumentList.TRUMPET.getInstrumentBuyingPrice(),
                InstrumentList.TRUMPET.getInstrumentType(),
                Colour.YELLOW.getColour());
    }

    @Test
    public void hasProductName() {
        assertEquals("Acoustic Guitar", acousticGuitar.getProductName());
    }

    @Test
    public void hasInstrumentType() {
        assertEquals("String", acousticGuitar.getInstrumentType());
    }

    @Test
    public void hasBuyingPrice() {
        assertEquals(120, acousticGuitar.getBuyingPrice(), 0.01);
    }

    @Test
    public void hasSellingPrice() {
        assertEquals(180, acousticGuitar.getSellingPrice(), 0.01);
    }

    @Test
    public void hasComponents() {
        ArrayList<Component> components = new ArrayList<>();
        assertEquals(components, acousticGuitar.getComponents());
    }

    @Test
    public void hasColour() {
        assertEquals("Red", acousticGuitar.getColour());
    }

    @Test
    public void canGetNumberOfComponents() {
        assertEquals(0, acousticGuitar.getNumberOfComponents());
    }

    @Test
    public void canAddComponent() {
        GuitarString guitarString = new GuitarString(
                ComponentList.GUITARSTRING.getComponentName(),
                ComponentList.GUITARSTRING.getComponentBuyingPrice(),
                ComponentList.GUITARSTRING.getComponentSound());
        acousticGuitar.addComponent(guitarString);
        assertEquals(1, acousticGuitar.getNumberOfComponents());
    }

    @Test
    public void canPlayInstrument__drumkit() {
        drumKit = new DrumKit(
                InstrumentList.DRUMKIT.getInstrumentName(),
                InstrumentList.DRUMKIT.getInstrumentBuyingPrice(),
                InstrumentList.DRUMKIT.getInstrumentType(),
                Colour.PURPLE.getColour());
        SnareDrum snareDrum = new SnareDrum(
                ComponentList.SNAREDRUM.getComponentName(),
                ComponentList.SNAREDRUM.getComponentBuyingPrice(),
                ComponentList.SNAREDRUM.getComponentSound());
        BassDrum bassDrum = new BassDrum(
                ComponentList.BASSDRUM.getComponentName(),
                ComponentList.BASSDRUM.getComponentBuyingPrice(),
                ComponentList.BASSDRUM.getComponentSound());
        HiHat hiHat = new HiHat(
                ComponentList.HIHAT.getComponentName(),
                ComponentList.HIHAT.getComponentBuyingPrice(),
                ComponentList.HIHAT.getComponentSound());
        drumKit.addComponent(snareDrum);
        drumKit.addComponent(bassDrum);
        drumKit.addComponent(hiHat);
        assertEquals("Ba Dum Tish", drumKit.playInstrument());
    }

    @Test
    public void canPlayInstrument__acoustic_guitar() {
        GuitarString guitarString = new GuitarString(
                ComponentList.GUITARSTRING.getComponentName(),
                ComponentList.GUITARSTRING.getComponentBuyingPrice(),
                ComponentList.GUITARSTRING.getComponentSound());
        acousticGuitar.addComponent(guitarString);
        acousticGuitar.addComponent(guitarString);
        acousticGuitar.addComponent(guitarString);
        acousticGuitar.addComponent(guitarString);
        acousticGuitar.addComponent(guitarString);
        acousticGuitar.addComponent(guitarString);
        assertEquals("Twang Twang Twang Twang Twang Twang", acousticGuitar.playInstrument());
    }

    @Test
    public void canPlayInstrument__other_drum_sounds() {
        Cymbal cymbal = new Cymbal(
                ComponentList.CYMBAL.getComponentName(),
                ComponentList.CYMBAL.getComponentBuyingPrice(),
                ComponentList.CYMBAL.getComponentSound());
        TomTom tomTom = new TomTom(
                ComponentList.TOMTOM.getComponentName(),
                ComponentList.TOMTOM.getComponentBuyingPrice(),
                ComponentList.TOMTOM.getComponentSound());
        drumKit.addComponent(cymbal);
        drumKit.addComponent(tomTom);
        assertEquals("Clash Tom-tom", drumKit.playInstrument());
    }

    @Test
    public void canPlayInstrument__piano() {
        Key key = new Key(
                ComponentList.KEY.getComponentName(),
                ComponentList.KEY.getComponentBuyingPrice(),
                ComponentList.KEY.getComponentSound());
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        piano.addComponent(key);
        assertEquals("Plink Plink Plink Plink Plink Plink Plink Plink", piano.playInstrument());
    }

    @Test
    public void canPlayInstrument__trumpet() {
        Valve valve = new Valve(
                ComponentList.VALVE.getComponentName(),
                ComponentList.VALVE.getComponentBuyingPrice(),
                ComponentList.VALVE.getComponentSound());
        trumpet.addComponent(valve);
        trumpet.addComponent(valve);
        trumpet.addComponent(valve);
        assertEquals("Pah-pa-rah Pah-pa-rah Pah-pa-rah", trumpet.playInstrument());
    }

    @Test
    public void canPlayInstrument__unknown() {
        Valve valve = new Valve(
                "Unknown",
                ComponentList.VALVE.getComponentBuyingPrice(),
                ComponentList.VALVE.getComponentSound());
        trumpet.addComponent(valve);
        assertEquals("UNKNOWN_COMPONENT:Unknown:EOM", trumpet.playInstrument());
    }

}
