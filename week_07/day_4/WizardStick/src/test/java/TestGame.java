import Characters.Barbarian;
import Characters.Enemy;
import Characters.Orc;
import Characters.Player;
import Enums.Weapons;
import Rooms.Room;
import Rooms.RoomNames;
import Treasures.Treasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    Player player;
    Room room;
    Gold gold;
    Orc orc;

    Game game;


    @Before
    public void setUp() throws Exception {
        gold = new Gold("Gold");

        orc = new Orc("Orc", 100);
        orc.setWeapon(Weapons.CLUB);
        orc.setLevel(1);

        room = new Room(RoomNames.ROOMOFFAILEDCODINGDREAMS.getRoomName(), RoomNames.ROOMOFFAILEDCODINGDREAMS.getRoomNumber(), orc, gold);

        player = new Barbarian("Hannibal", "Barbarian", 100, 2);
        player.setWeapon(Weapons.SWORD);
        player.setLevel(1);

        game = new Game("Hit Me With Your Wizard Stick!");
    }

    @Test
    public void testGameName() {
        assertEquals("Hit Me With Your Wizard Stick!", game.getName());
    }

    @Test
    public void testAddRoomToGame() {
        game.addRoomToGame(room);
        assertEquals(1, game.noOfRooms());
    }

    @Test
    public void testAddAPlayer() {
        game.addPlayerToGame(player);
        assertEquals(1, game.noOfPlayers());
    }

}

