import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private DiningRoom diningRoom;
    private ArrayList<ConfRoom> confRooms;

    public Hotel(String name, DiningRoom diningRoom) {
        this.name = name;
        this.bedrooms = new ArrayList<>();
        this.diningRoom = diningRoom;
        this.confRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public DiningRoom getDiningRoom() {
        return diningRoom;
    }

    public int getBedroomsSize() {
       return this.bedrooms.size();
    }

    public int getConfRoomsSize() {
       return this.confRooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addConfRoom(ConfRoom confRoom) {
        this.confRooms.add(confRoom);
    }

    public ArrayList<Guest> getBedroomGuests(Bedroom bedroom) {
        return bedroom.getGuests();
    }

    public void checkGuestIn(Bedroom bedroom, Guest guest) {
        if (bedroom.getRoomSize() < bedroom.getCapacity()) {
            for (Bedroom searchRoom : this.bedrooms) {
                if (searchRoom == bedroom) {
                    searchRoom.addGuest(guest);
                }
            }
        }
    }

    public void checkGuestOut(Bedroom bedroom, Guest guest) {
        for (Bedroom searchRoom : this.bedrooms) {
            if (searchRoom == bedroom) {
                searchRoom.removeGuest(guest);
            }
        }
    }

    public ArrayList<Bedroom> getEmptyBedrooms() {
        ArrayList<Bedroom> emptyBedrooms = new ArrayList<>();
        for (Bedroom bedroom: this.bedrooms) {
            if (bedroom.getRoomSize() == 0) {
                emptyBedrooms.add(bedroom);
            }
        }
        return emptyBedrooms;
    }

}
