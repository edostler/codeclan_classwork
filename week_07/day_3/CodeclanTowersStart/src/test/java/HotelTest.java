import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    BedRoom singleRoom;
    BedRoom doubleRoom;
    BedRoom suite;
    Guest guest;
    ConferenceRoom conferenceRoom;
    DiningRoom diningRoom;


    @Before
    public void before(){
        singleRoom = new BedRoom(RoomType.SINGLE, 25.00, 101);
        doubleRoom  = new BedRoom(RoomType.DOUBLE, 50.00, 201);
        suite  = new BedRoom(RoomType.SUITE, 100.00, 301);
        guest = new Guest("Ed");
        conferenceRoom = new ConferenceRoom(100, "Jura", 200.00);
        diningRoom = new DiningRoom(50, "Diningroom");
        ArrayList<Room> testRooms = new ArrayList<>();
        testRooms.add(singleRoom);
        testRooms.add(doubleRoom);
        testRooms.add(suite);
        testRooms.add(conferenceRoom);
        testRooms.add(diningRoom);
        hotel = new Hotel(testRooms);
    }

    @Test
    public void canCheckInToSingleRoom() {
        ArrayList<Guest> testList = new ArrayList<>();
        testList.add(guest);
        hotel.checkInToBedroom(testList, 101);
        BedRoom room = hotel.getBedroom(101);
        assertEquals(1, room.getRoomGuestCount());
    }

}
