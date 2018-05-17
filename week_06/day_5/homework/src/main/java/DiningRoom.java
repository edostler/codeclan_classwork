import java.util.ArrayList;

public class DiningRoom extends Room {

    private ArrayList<Guest> guests;

    public DiningRoom(String roomName, int capacity, String roomType) {
        super(roomName, capacity, roomType);
        this.guests = new ArrayList<>();
    }

}
