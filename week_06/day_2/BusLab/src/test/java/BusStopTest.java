import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusStopTest {

    private BusStop busStop;
    private Person person;

    @Before
    public void before() {
        busStop = new BusStop();
        person = new Person();
    }

    @Test
    public void canGetQueueSize() {
        assertEquals(0, busStop.getQueueSize());
    }

    @Test
    public void canAddPersonToQueue() {
        busStop.addPersonToQueue(person);
        assertEquals(1, busStop.getQueueSize());
    }

    @Test
    public void canRemovePersonFromQueue__queue_has_person() {
        busStop.addPersonToQueue(person);
        assertEquals(1, busStop.getQueueSize());
        busStop.removePersonFromQueue();
        assertEquals(0, busStop.getQueueSize());
    }

    @Test
    public void canRemovePersonFromQueue__queue_has_no_person() {
        assertEquals(0, busStop.getQueueSize());
        busStop.removePersonFromQueue();
        assertEquals(0, busStop.getQueueSize());
    }
}
