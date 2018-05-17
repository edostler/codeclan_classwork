import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    private Radio radio;
    private Station station;

    @Before
    public void before() {
        station = new Station("Radio 1", 94.7);
        radio = new Radio("Sony", "Tuner", station);
        radio.addStationToRadio(station);
    }

    @Test
    public void canGetMake() {
        assertEquals("Sony", radio.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Tuner", radio.getModel());
    }

    @Test
    public void canGetTunedStation() {
        assertEquals(station, radio.getTunedStation());
    }

    @Test
    public void canGetTunedStationName() {
        assertEquals("Radio 1", radio.getTunedStationName());
    }

    @Test
    public void canGetTunedFrequency() {
        assertEquals(94.7, radio.getTunedFrequency(),0.01);
    }

    @Test
    public void canGetStationSize() {
        assertEquals(1, radio.getStationsSize());
    }

    @Test
    public void canAddStationToRadio() {
        Station station = new Station("Radio 2", 104.9);
        radio.addStationToRadio(station);
        assertEquals(2, radio.getStationsSize());
    }

    @Test
    public void canSetTunedStation() {
        Station station = new Station("Radio 2", 104.9);
        radio.setTunedStation(station);
        assertEquals(station, radio.getTunedStation());
        assertEquals("Radio 2", radio.getTunedStationName());
        assertEquals(104.9, radio.getTunedFrequency(), 0.01);
    }

}
