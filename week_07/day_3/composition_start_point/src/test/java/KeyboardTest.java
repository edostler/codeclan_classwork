import device_management.Keyboard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeyboardTest {

    private Keyboard keyboard;

    @Before
    public void before() {
        keyboard = new Keyboard("Logitech");
    }

    @Test
    public void canPressKey() {
        assertEquals("Tap!", keyboard.pressKey());
    }
}
