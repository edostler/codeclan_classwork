import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfRoomTest {

    private ConfRoom largeConf;

    @Before
    public void before() {
        largeConf = new ConfRoom("Conference Room 3", RoomType.CONF_LG.getCapacity(), RoomType.CONF_LG.getRoomType(), 1000);
    }

    @Test
    public void hasNightRate() {
        assertEquals(1000, largeConf.getDayRate(), 0.01);
    }

}
