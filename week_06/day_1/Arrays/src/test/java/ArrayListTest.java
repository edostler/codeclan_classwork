import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {

    private ArrayListExample arrayListExample;
    private ArrayListExample arrayListNumberExample;

    @Before
    public void before(){
        arrayListExample = new ArrayListExample();
    }

    @Test
    public void canAddItem(){
        arrayListExample.add("Hello");
        assertEquals(1, arrayListExample.getWordCount());
    }

    @Test
    public void doesArrayContainWord() {
        arrayListExample.add("Hello");
        assertTrue(arrayListExample.arrayContainsWord("Hello"));
    }

    @Test
    public void canTotalNumbers() {
        assertEquals(10, arrayListNumberExample.getTotal());
    }

    @Test
    public void canGetRandom() {
        ArrayList results = arrayListExample.getNumbers();
        int randomNumber = arrayListExample.getRandomNumber();
        assertTrue(results.contains(randomNumber));
    }

}