import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HotelTest {

    private Hotel hotel;
    private DiningRoom diningRoom;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private Bedroom bedroom3;
    private ConfRoom confRoom;
    private Guest guest1;
    private Guest guest2;

    @Before
    public void before() {
        diningRoom = new DiningRoom("Dining Room", RoomType.DINING.getCapacity(), RoomType.DINING.getRoomType());
        hotel = new Hotel("Eddington Chase Hotel", diningRoom);
        bedroom1 = new Bedroom("Room 1", RoomType.SINGLE.getCapacity(), RoomType.SINGLE.getRoomType(), 66.60);
        bedroom2 = new Bedroom("Room 2", RoomType.SINGLE.getCapacity(), RoomType.SINGLE.getRoomType(), 66.60);
        bedroom3 = new Bedroom("Room 3", RoomType.SINGLE.getCapacity(), RoomType.SINGLE.getRoomType(), 66.60);
        confRoom = new ConfRoom("Conference Room 1", RoomType.CONF_SM.getCapacity(), RoomType.CONF_SM.getRoomType(), 200);
        guest1 = new Guest("Ed");
        guest2 = new Guest("Emma");
    }

    @Test
    public void hasName() {
        assertEquals("Eddington Chase Hotel", hotel.getName());
    }

    @Test
    public void hasDiningRoom() {
        assertEquals(diningRoom, hotel.getDiningRoom());
    }

    @Test
    public void canGetBedroomsSize() {
        assertEquals(0, hotel.getBedroomsSize());
    }

    @Test
    public void canGetConfRoomsSize() {
        assertEquals(0, hotel.getConfRoomsSize());
    }

    @Test
    public void canAddBedroom() {
        assertEquals(0, hotel.getBedroomsSize());
        hotel.addBedroom(bedroom1);
        assertEquals(1, hotel.getBedroomsSize());
    }

    @Test
    public void canAddConfRoom() {
        assertEquals(0, hotel.getConfRoomsSize());
        hotel.addConfRoom(confRoom);
        assertEquals(1, hotel.getConfRoomsSize());
    }

    @Test
    public void canGetBedroomGuests() {
        hotel.addBedroom(bedroom1);
        bedroom1.addGuest(guest1);
        ArrayList expected = hotel.getBedroomGuests(bedroom1);
        assertEquals(expected, bedroom1.getGuests());
        assertTrue(expected.contains(guest1));
    }

    @Test
    public void canCheckGuestIn__room_has_space() {
        hotel.addBedroom(bedroom1);
        assertEquals(0, bedroom1.getRoomSize());
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest1));
        hotel.checkGuestIn(bedroom1, guest1);
        assertEquals(1, bedroom1.getRoomSize());
        assertTrue(hotel.getBedroomGuests(bedroom1).contains(guest1));
    }

    @Test
    public void canCheckGuestIn__room_has_no_space() {
        hotel.addBedroom(bedroom1);
        assertEquals(0, bedroom1.getRoomSize());
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest1));
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest2));
        hotel.checkGuestIn(bedroom1, guest1);
        hotel.checkGuestIn(bedroom1, guest2);
        assertEquals(1, bedroom1.getRoomSize());
        assertTrue(hotel.getBedroomGuests(bedroom1).contains(guest1));
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest2));
    }

    @Test
    public void canCheckGuestOut__guest_is_in_that_room() {
        hotel.addBedroom(bedroom1);
        hotel.checkGuestIn(bedroom1, guest1);
        assertEquals(1, bedroom1.getRoomSize());
        assertTrue(hotel.getBedroomGuests(bedroom1).contains(guest1));
        hotel.checkGuestOut(bedroom1, guest1);
        assertEquals(0, bedroom1.getRoomSize());
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest1));
    }

    @Test
    public void canCheckGuestOut__guest_is_not_in_that_room() {
        hotel.addBedroom(bedroom1);
        hotel.checkGuestOut(bedroom1, guest1);
        assertEquals(0, bedroom1.getRoomSize());
        assertFalse(hotel.getBedroomGuests(bedroom1).contains(guest1));
    }

    @Test
    public void canGetEmptyRooms() {
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.checkGuestIn(bedroom1, guest1);
        ArrayList<Bedroom> expected = new ArrayList<>();
        expected.add(bedroom2);
        expected.add(bedroom3);
        assertEquals(expected, hotel.getEmptyBedrooms());
    }

}
