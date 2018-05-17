import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom familyRoom;

    @Before
    public void before() {
        familyRoom = new Bedroom("Room 4", RoomType.FAMILY.getCapacity(), RoomType.FAMILY.getRoomType(), 126.60);
    }

    @Test
    public void hasNightRate() {
        assertEquals(126.60, familyRoom.getNightRate(), 0.01);
    }

}
