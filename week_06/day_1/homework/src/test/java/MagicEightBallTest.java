import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MagicEightBallTest {

    private MagicEightBall magicEightBall;

    @Before
    public void before() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Seek the answer within yourself.");
        answers.add("Guess again!");
        answers.add("Only the pure of heart can know.");
        magicEightBall = new MagicEightBall(answers);
    }

    @Test
    public void hasAnswers() {
        ArrayList results = magicEightBall.getAnswers();
        assertTrue(results.contains("Seek the answer within yourself."));
        assertTrue(results.contains("Guess again!"));
        assertTrue(results.contains("Only the pure of heart can know."));
        assertFalse(results.contains("Ask someone who gives a damn."));
    }

    @Test
    public void canGetStringCount() {
        assertEquals(3, magicEightBall.getStringCount());
    }

    @Test
    public void canAddAnswer() {
        String answer = "Don't ask!";
        magicEightBall.addAnswer(answer);
        ArrayList results = magicEightBall.getAnswers();
        assertEquals(4, magicEightBall.getStringCount());
        assertTrue(results.contains(answer));
    }

    @Test
    public void canGetRandomAnswer() {
        ArrayList results = magicEightBall.getAnswers();
        String randomAnswer = magicEightBall.getRandomAnswer();
        assertTrue(results.contains(randomAnswer));
    }

    @Test
    public void canRemoveAnswer() {
        String answer = "Guess again!";
        magicEightBall.removeAnswer(answer);
        ArrayList results = magicEightBall.getAnswers();
        assertEquals(2, magicEightBall.getStringCount());
        assertFalse(results.contains(answer));
    }
}
