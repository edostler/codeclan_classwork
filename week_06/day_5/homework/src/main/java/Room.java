import java.util.ArrayList;

public abstract class Room {

    private String roomName;
    private int capacity;
    private String roomType;
    private ArrayList<Guest> guests;

    public Room(String roomName, int capacity, String roomType) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.roomType = roomType;
        this.guests = new ArrayList<>();
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getRoomType() {
        return roomType;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public int getRoomSize() {
        return guests.size();
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest) {
        this.guests.remove(guest);
    }

}
