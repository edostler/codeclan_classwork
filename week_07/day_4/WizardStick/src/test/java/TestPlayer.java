import Characters.*;
import Enums.Weapons;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {

    Knight knight;
    Barbarian barbarian;
    Cleric cleric;
    Dwarf dwarf;
    Warlock warlock;
    Wizard wizard;

    Ogre ogre;


    @Before
    public void setUp() throws Exception {
        knight = new Knight("Brave Sir Robin", "Knight", 100, 10);
        barbarian = new Barbarian("Hannibal", "Barbarian", 100, 2);
        cleric = new Cleric("Eustace the Monk", "Cleric", 100);
        dwarf = new Dwarf("Sneezy", "Dwarf", 100);
        warlock = new Warlock("Adam", "Warlock", 100);
        wizard = new Wizard("Gandalf", "Wizard", 100);
        ogre = new Ogre("Ogre", 100);
    }

    @Test
    public void testHasName() {
        assertEquals("Brave Sir Robin", knight.getName());
    }

    @Test
    public void testHasType() {
        assertEquals("Dwarf", dwarf.getType());
    }

    @Test
    public void testHasHealth() {
        assertEquals(100, wizard.getHealth());
    }

    @Test
    public void testDeductHealth() {
        knight.deductHealth(10);
        assertEquals(90, knight.getHealth());
    }

    @Test
    public void testCalculateActualDamage() {
        knight.setLevel(2);
        knight.setWeapon(Weapons.AXE);
        assertEquals(16, knight.calculateActualDamage());
    }

    @Test
    public void testAttack() {
        barbarian.setLevel(2);
        barbarian.setWeapon(Weapons.SWORD);
        assertEquals("Hannibal slashes the Ogre with their sword inflicting a damage of 40", barbarian.attack(barbarian, ogre));
    }
}
