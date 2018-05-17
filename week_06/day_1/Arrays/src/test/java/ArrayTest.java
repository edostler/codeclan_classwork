import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayTest {

    private ArrayExample arrayExample;

    @Before
    public void before(){
        arrayExample = new ArrayExample();
    }

    @Test
    public void canAddItem(){
        arrayExample.add("Hello");
        assertEquals(1, arrayExample.getWordCount());
    }

}
