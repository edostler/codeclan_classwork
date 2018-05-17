import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SweetTest {

    private Sweet sweet;

    @Before
    public void before() {
        sweet = new Sweet("Twix", 35);
    }

    @Test
    public void canGetName() {
        assertEquals("Twix", sweet.getName());
    }
}
