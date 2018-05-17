import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CdPlayerTest {

    private CdPlayer cdPlayer;
    private Cd cd;

    @Before
    public void before() {
        cd = new Cd("Americana", "The Offspring");
        cdPlayer = new CdPlayer("Sony", "Skipfree", 3);
        cdPlayer.addCdToLibrary(cd);
        cdPlayer.setCurrentCd(cd);
    }

    @Test
    public void canGetMake() {
        assertEquals("Sony", cdPlayer.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Skipfree", cdPlayer.getModel());
    }

    @Test
    public void canGetCurrentCd() {
        assertEquals(cd, cdPlayer.getCurrentCd());
    }

    @Test
    public void canGetCurrentCdTitle() {
        assertEquals("Americana", cdPlayer.getCurrentCdTitle());
    }

    @Test
    public void canGetCurrentCdArtist() {
        assertEquals("The Offspring", cdPlayer.getCurrentCdArtist());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(3, cdPlayer.getCapacity());
    }

    @Test
    public void canGetCdLibrarySize() {
        assertEquals(1, cdPlayer.getCdLibrarySize());
    }

    @Test
    public void canAddCdToLibrary() {
        Cd cd = new Cd("Deja Entendu", "Brand New");
        cdPlayer.addCdToLibrary(cd);
        assertEquals(2, cdPlayer.getCdLibrarySize());
    }

    @Test
    public void canSetCurrentCd() {
        Cd cd = new Cd("Deja Entendu", "Brand New");
        cdPlayer.setCurrentCd(cd);
        assertEquals(cd, cdPlayer.getCurrentCd());
        assertEquals("Deja Entendu", cdPlayer.getCurrentCdTitle());
        assertEquals("Brand New", cdPlayer.getCurrentCdArtist());
    }
}
