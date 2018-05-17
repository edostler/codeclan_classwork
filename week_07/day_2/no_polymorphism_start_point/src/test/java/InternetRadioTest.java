import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InternetRadioTest {

    private InternetRadio internetRadio;

    @Before
    public void before() {
        internetRadio = new InternetRadio("Radio 1");
    }

    @Test
    public void canConnect() {
        assertEquals("Internet Radio connected to: CodeClan", internetRadio.connect("CodeClan"));
    }

    @Test
    public void canGetStation() {
        assertEquals("Radio 1", internetRadio.getStation());
    }

    @Test
    public void canTuneToStation() {
        internetRadio.tuneToStation("Radio 1");
        assertEquals("Radio 1", internetRadio.getStation());
    }

}
