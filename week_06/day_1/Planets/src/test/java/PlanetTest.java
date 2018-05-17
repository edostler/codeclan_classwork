import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlanetTest {

    //declarations
    private Planet planet;

    //setup
    @Before
    public void before(){
        planet = new Planet("Mars", 3390);
    }

    //tests

    @Test
    public void hasName() {
        assertEquals("Mars", planet.getName());
    }

    @Test
    public void hasSize() {
        assertEquals(3390, planet.getSize());
    }

    @Test
    public void canExplode() {
        assertEquals("Boom! Mars has exploded because it's size is now 3390.", planet.explode());
    }

}
