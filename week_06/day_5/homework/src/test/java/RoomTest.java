import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Bedroom bedroom;
    private DiningRoom diningRoom;
    private ConfRoom conferenceRoom;
    private Guest guest;

    @Before
    public void before() {
        bedroom = new Bedroom("Room 1", RoomType.SINGLE.getCapacity(), RoomType.SINGLE.getRoomType(), 66.60);
        diningRoom = new DiningRoom("Dining Room", RoomType.DINING.getCapacity(), RoomType.DINING.getRoomType());
        conferenceRoom = new ConfRoom("Conference Room 1", RoomType.CONF_SM.getCapacity(), RoomType.CONF_SM.getRoomType(), 200);
        guest = new Guest("Ed");
    }

    @Test
    public void hasRoomName() {
        assertEquals("Room 1", bedroom.getRoomName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(200, diningRoom.getCapacity());
    }

    @Test
    public void hasRoomType() {
        assertEquals("Small Conference", conferenceRoom.getRoomType());
    }

    @Test
    public void canGetRoomSize() {
        assertEquals(0, bedroom.getRoomSize());
    }

    @Test
    public void canAddGuest() {
        assertEquals(0, bedroom.getRoomSize());
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getRoomSize());
    }

    @Test
    public void canRemoveGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getRoomSize());
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.getRoomSize());
    }

}
