import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;

    public Hotel(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

//    public void checkInToBedroom(ArrayList<Guest> party, int roomNumber) {
//        for (Room room : rooms) {
//            if (room instanceof BedRoom) {
//                //commented out because IntelliJ writes this funnily, the version we use is casting.
////                if (((BedRoom) room).getRoomNumber() == roomNumber) {
////                    room.checkIn(party);
////                }
//                BedRoom bedroom = (BedRoom) room;
//                if (bedroom.getRoomNumber() == roomNumber) {
//                    room.checkIn(party);
//                }
//            }
//        }
//    }


    //refactored before having created the getBedroom function

    public void checkInToBedroom(ArrayList<Guest> party, int roomNumber) {
        BedRoom bedroom = getBedroom((roomNumber));
        bedroom.checkIn((party));
    }

    public BedRoom getBedroom(int roomNumber) {
        BedRoom bedroom = null;
        for (Room room : rooms) {
            if (room instanceof BedRoom) {
                bedroom = (BedRoom) room;
                if (bedroom.getRoomNumber() == roomNumber) {
                    return bedroom;
                }
            }
        }
        return bedroom;
    }

}
