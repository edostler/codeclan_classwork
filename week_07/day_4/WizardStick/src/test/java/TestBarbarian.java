import Characters.Barbarian;
import Characters.Ogre;
import Enums.Weapons;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBarbarian {

    Barbarian barbarian;
    Ogre ogre;

    @Before
    public void setUp() throws Exception {
        barbarian = new Barbarian("Hannibal", "Barbarian", 100, 2);
        ogre = new Ogre("Ogre", 100);
    }

    @Test
    public void testAttack() {
        barbarian.setLevel(2);
        barbarian.setWeapon(Weapons.SWORD);
        assertEquals("Hannibal slashes the Ogre with their sword inflicting a damage of 40", barbarian.attack(barbarian, ogre));
    }
}
