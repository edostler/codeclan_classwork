import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StereoTest {

    private Stereo stereo;

    @Before
    public void before() {
        stereo = new Stereo("Gigablaster 700");
    }

    @Test
    public void canGetName() {
        assertEquals("Gigablaster 700", stereo.getName());
    }

    @Test
    public void canGetComponentsSize() {
        assertEquals(0, stereo.getComponentsSize());
    }

    @Test
    public void canAddComponent() {
        Station station = new Station("Radio 1", 94.7);
        Radio radio = new Radio("Sony", "Tuner", station);
        stereo.addComponent(radio);
        assertEquals(1, stereo.getComponentsSize());
    }

//    @Test
//    public void canTuneRadio__station_found() {
//        assertEquals("You're listening to Radio 1!", radio.tuneRadio(94.7));
//    }
//
//    @Test
//    public void canTuneRadio__station_not_found() {
//        assertEquals("Unknown station.", radio.tuneRadio(94.6));
//    }

}
