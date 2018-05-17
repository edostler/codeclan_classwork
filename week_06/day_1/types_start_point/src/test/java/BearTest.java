import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BearTest {

    //we declare the variable name here
    private Bear bear;

    //and we initialise it here in Before
    @Before
    public void before(){
        bear = new Bear("Baloo", 25, 95.62);
    }

    //and then can use it from then on in our tests
    @Test
    public void hasName() {
        assertEquals("Baloo", bear.getName());
    }

    @Test
    public void hasAge() {
        assertEquals(25, bear.getAge());
    }

    @Test
    public void hasWeight() {
        assertEquals(95.62, bear.getWeight(),0.01);
    }

    @Test
    public void readyToHibernate__true() {
        assertTrue(bear.readyToHibernate());
    }

    @Test
    public void readyToHibernate__false() {
        Bear bear2 = new Bear("SuperTed", 31, 75.13);
        assertFalse(bear2.readyToHibernate());
    }


}
