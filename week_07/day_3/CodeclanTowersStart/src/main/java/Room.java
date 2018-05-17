import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;


    public Room(int capacity) {
        this.capacity = capacity;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void checkIn(ArrayList<Guest> party) {
        if (party.size() <= capacity) {
            for (Guest guest : party) {
                this.guests.add(guest);
            }
        }
    }

    public void checkOut() {
        guests.clear();
    }

    public int getRoomGuestCount() {
        return this.guests.size();
    }

}
