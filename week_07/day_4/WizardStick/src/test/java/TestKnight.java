import Characters.Barbarian;
import Characters.Knight;
import Characters.Ogre;
import Enums.Weapons;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestKnight {

    Knight knight;
    Ogre ogre;

    @Before
    public void setUp() throws Exception {
        knight = new Knight("Brave Sir Robin", "Knight", 100, 10);
        ogre = new Ogre("Ogre", 100);
    }

}
