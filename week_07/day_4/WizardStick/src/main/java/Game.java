import Characters.Enemy;
import Characters.Player;
import Rooms.Room;
import Treasures.Treasure;

import java.util.ArrayList;

public class Game {

    String name;
    ArrayList<Player> players;
    ArrayList<Room> rooms;

    public Game(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRoomToGame(Room room) {
        this.rooms.add(room);
    }

    public int noOfRooms() {
        return this.rooms.size();
    }

    public void addPlayerToGame(Player player) {
        this.players.add(player);
    }

    public int noOfPlayers() {
        return this.players.size();
    }
}

