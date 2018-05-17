import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkTest {

    Network network;
    Desktop desktop;
    Printer printer;
    private InternetRadio internetRadio;


    @Before
    public void before() {
        network = new Network("CodeClan", 3);
        printer = new Printer();
        desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
        internetRadio = new InternetRadio("Radio 1");
    }

    @Test
    public void hasName() {
        assertEquals("CodeClan", network.getName());
    }

    @Test
    public void canGetCapacity() {
        assertEquals(3, network.getCapacity());
    }

    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectDesktop__slots_available() {
        network.connect(desktop);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll() {
        network.connect(desktop);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectPrinter__slots_available() {
        network.connect(printer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectInternetRadio__slots_available() {
        network.connect(internetRadio);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnect__slots_not_available() {
        network.connect(printer);
        network.connect(desktop);
        network.connect(internetRadio);
        network.connect(printer);
        assertEquals(3, network.deviceCount());
    }

    @Test
    public void canCountFreeSlots() {
        network.connect(desktop);
        assertEquals(2, network.countFreeSlots());
    }
}
