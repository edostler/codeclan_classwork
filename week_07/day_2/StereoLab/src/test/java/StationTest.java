import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StationTest {

    private Station station;

    @Before
    public void before() {
        station = new Station("Radio 1", 94.7);
    }

    @Test
    public void canGetStationName() {
        assertEquals("Radio 1", station.getStationName());
    }

    @Test
    public void canGetFrequency() {
        assertEquals(94.7, station.getFrequency(), 0.01);
    }

}
