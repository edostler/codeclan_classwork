import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterfacesTest {

    Printer printer;
    Mouse mouse;

    @Before
    public void before() {
        printer = new Printer();
        mouse = new Mouse();
    }

    @Test
    public void canConnect() {
        assertEquals("connected", printer.connect());
    }

    @Test
    public void canPrint() {
        assertEquals("printing: Hello world!", printer.print("Hello world!"));
    }

    @Test
    public void mouseCanConnect() {
        assertEquals("mouse connected", mouse.connect());
    }

    @Test
    public void canConnectAsPeripheral() {
        IPeripheral printer = new Printer();
        assertEquals("connected", printer.connect());
    }

//    @Test
//    public void canPrintAsPeripheral() {
//        IPeripheral printer = new Printer;
//        assertEquals("printing: Hello world!", printer.print("Hello world!"));
//    }



}
