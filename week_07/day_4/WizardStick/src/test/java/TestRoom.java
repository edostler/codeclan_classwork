import Characters.Enemy;
import Characters.Orc;
import Enums.Weapons;
import Rooms.Room;
import Rooms.RoomNames;
import Treasures.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRoom {

    Room room;
    Orc orc;
    Gold gold;

    @Before
    public void setUp() throws Exception {
        orc = new Orc("Orc", 100);
        orc.setWeapon(Weapons.AXE);
        gold = new Gold("Gold");
        room = new Room(RoomNames.ROOMOFBRIDGES.getRoomName(), RoomNames.ROOMOFBRIDGES.getRoomNumber(), orc, gold);
    }

    @Test
    public void testRoomHasName() {
        assertEquals("Room of Bridges", room.getRoomname());
    }

    @Test
    public void testRoomHasNumber() {
        assertEquals(7, room.getRoonnum());
    }

    @Test
    public void testRoomHasEnemy() {
        assert(room.getEnemy() instanceof Enemy);
    }

    @Test
    public void testRoomHasTreasure() {
        assert(room.getTreasure() instanceof Treasure);
    }

    @Test
    public void testDescribeRoom() {
        assertEquals("You enter the Room of Bridges. Suddenly, a belligerent and bloodthirsty Orc appears, wielding a deadly axe, and guarding a huge chest of Gold", room.describeRoom());
    }
}
