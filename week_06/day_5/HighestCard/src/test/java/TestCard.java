import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCard {

    private Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card(Suit.SPADES, Rank.ACE);
    }

    @Test
    public void testSuit() {
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void testRank() {
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void testScore() {
        assertEquals(14, card.getScore());
    }
}
