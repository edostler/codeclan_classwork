import java.util.ArrayList;

public class ConfRoom extends Room {

    private double dayRate;
    private ArrayList<Guest> guests;

    public ConfRoom(String roomName, int capacity, String roomType, double dayRate) {
        super(roomName, capacity, roomType);
        this.dayRate = dayRate;
        this.guests = new ArrayList<>();
    }

    public double getDayRate() {
        return dayRate;
    }

}
