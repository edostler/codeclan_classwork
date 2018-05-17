import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHand {
    Hand hand;
    Card card;

    @Before
    public void setUp() throws Exception {
        card = new Card(Suit.HEARTS, Rank.ACE);

        hand = new Hand();
    }

    @Test
    public void testIsEmptyInitially() {
        assertEquals(0, hand.getSize());
    }

    @Test
    public void testCanAddCard() {
        hand.add(card);
        assertEquals(1, hand.getSize());
    }

    @Test
    public void testGetTotal() {
        hand.add(card);
        assertEquals(14, hand.getTotal());
    }
}
