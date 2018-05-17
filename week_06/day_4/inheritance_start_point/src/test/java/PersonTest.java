import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    private Person person;

    @Before
    public void before() {
        person = new Person("Ed", "G4");
    }

    @Test
    public void hadName() {
        assertEquals("Ed", person.getName());
    }

    @Test
    public void hasCohort() {
        assertEquals("G4", person.getCohort());
    }

    @Test
    public void cabChangeName() {
        person.setName("Angus");
        assertEquals("Angus", person.getName());
    }

    @Test
    public void cabChangeCohort() {
        person.setCohort("G5");
        assertEquals("G5", person.getCohort());
    }

    @Test
    public void canTalk() {
        assertEquals("I love Java", person.talk("Java"));
    }

}
