import Components.*;
import Enums.ComponentList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComponentTest {

    private BassDrum bassDrum;
    private Cymbal cymbal;
    private GuitarString guitarString;
    private HiHat hiHat;
    private Key key;
    private SnareDrum snareDrum;
    private TomTom tomTom;
    private Valve valve;

    @Before
    public void before() {
        bassDrum = new BassDrum(
                ComponentList.BASSDRUM.getComponentName(),
                ComponentList.BASSDRUM.getComponentBuyingPrice(),
                ComponentList.BASSDRUM.getComponentSound());
        cymbal = new Cymbal(
                ComponentList.CYMBAL.getComponentName(),
                ComponentList.CYMBAL.getComponentBuyingPrice(),
                ComponentList.CYMBAL.getComponentSound());
        guitarString = new GuitarString(
                ComponentList.GUITARSTRING.getComponentName(),
                ComponentList.GUITARSTRING.getComponentBuyingPrice(),
                ComponentList.GUITARSTRING.getComponentSound());
        hiHat = new HiHat(
                ComponentList.HIHAT.getComponentName(),
                ComponentList.HIHAT.getComponentBuyingPrice(),
                ComponentList.HIHAT.getComponentSound());
        key = new Key(
                ComponentList.KEY.getComponentName(),
                ComponentList.KEY.getComponentBuyingPrice(),
                ComponentList.KEY.getComponentSound());
        snareDrum = new SnareDrum(
                ComponentList.SNAREDRUM.getComponentName(),
                ComponentList.SNAREDRUM.getComponentBuyingPrice(),
                ComponentList.SNAREDRUM.getComponentSound());
        tomTom = new TomTom(
                ComponentList.TOMTOM.getComponentName(),
                ComponentList.TOMTOM.getComponentBuyingPrice(),
                ComponentList.TOMTOM.getComponentSound());
        valve = new Valve(
                ComponentList.VALVE.getComponentName(),
                ComponentList.VALVE.getComponentBuyingPrice(),
                ComponentList.VALVE.getComponentSound());
    }

    @Test
    public void hasProductName() {
        assertEquals("Bass Drum", bassDrum.getProductName());
    }

    @Test
    public void hasBuyingPrice() {
        assertEquals(40, bassDrum.getBuyingPrice(), 0.01);
    }

    @Test
    public void hasSellingPrice() {
        assertEquals(60, bassDrum.getSellingPrice(), 0.01);
    }

    @Test
    public void hasSound() {
        assertEquals("Dum", bassDrum.getSound());
    }

    @Test
    public void canPlay__BassDrum() {
        assertEquals("Dum", bassDrum.play());
    }
    @Test
    public void canPlay__Cymbal() {
        assertEquals("Clash", cymbal.play());
    }
    @Test
    public void canPlay__GuitarString() {
        assertEquals("Twang", guitarString.play());
    }
    @Test
    public void canPlay__HiHat() {
        assertEquals("Tish", hiHat.play());
    }
    @Test
    public void canPlay__Key() {
        assertEquals("Plink", key.play());
    }
    @Test
    public void canPlay__SnareDrum() {
        assertEquals("Ba", snareDrum.play());
    }
    @Test
    public void canPlay__TomTom() {
        assertEquals("Tom-tom", tomTom.play());
    }
    @Test
    public void canPlay__Valve() {
        assertEquals("Pah-pa-rah", valve.play());
    }


}