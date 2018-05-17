import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterTest {

    private Printer printer;

    @Before
    public void before() {
        printer = new Printer();
    }

    @Test
    public void canPrint() {
        assertEquals("printing: Hello World!", printer.print("Hello World!"));
    }

    @Test
    public void canConnect() {
        assertEquals("Printer connected to: CodeClan", printer.connect("CodeClan"));
    }
}
