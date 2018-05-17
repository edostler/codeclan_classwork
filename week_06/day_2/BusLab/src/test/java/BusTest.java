import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before() {
        bus = new Bus("Edinburgh", 5);
        person = new Person();
        busStop = new BusStop();
        busStop.addPersonToQueue(person);
    }

    @Test
    public void canGetBusSize() {
        assertEquals(0, bus.getBusSize());
    }

    @Test
    public void canAddPersonToBus__bus_has_space() {
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        assertEquals(5, bus.getBusSize());
    }

    @Test
    public void canAddPersonToBus__bus_has_no_space() {
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        bus.addPersonToBus(person);
        assertEquals(5, bus.getBusSize());
    }

    @Test
    public void canRemovePersonFromBus__bus_has_person() {
        bus.addPersonToBus(person);
        assertEquals(1, bus.getBusSize());
        bus.removePersonFromBus(person);
        assertEquals(0, bus.getBusSize());
    }

    @Test
    public void canRemovePersonFromBus__bus_has_no_person() {
        assertEquals(0, bus.getBusSize());
        bus.removePersonFromBus(person);
        assertEquals(0, bus.getBusSize());
    }

    @Test
    public void canMakePickUp() {
        bus.
    }


}
