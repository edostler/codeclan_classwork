import device_management.Mouse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MouseTest {

    private Mouse mouse;

    @Before
    public void before() {
        mouse = new Mouse("Logitech", 5);
    }

    @Test
    public void canClickButton() {
        assertEquals("Click!", mouse.clickButton());
    }

}
