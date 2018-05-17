import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CdTest {

    private Cd cd;

    @Before
    public void before() {
        cd = new Cd("Americana", "The Offspring");
    }

    @Test
    public void canGetTitle() {
        assertEquals("Americana", cd.getTitle());
    }

    @Test
    public void canGetArtist() {
        assertEquals("The Offspring", cd.getArtist());
    }
}
