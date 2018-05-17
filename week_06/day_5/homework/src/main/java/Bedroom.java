import java.util.ArrayList;

public class Bedroom extends Room {

    private double nightRate;
    private ArrayList<Guest> guests;

    public Bedroom(String roomName, int capacity, String roomType, double nightRate) {
        super(roomName, capacity, roomType);
        this.nightRate = nightRate;
        this.guests = new ArrayList<>();
    }

    public double getNightRate() {
        return nightRate;
    }

}
