import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class TestDeck {
    private Deck deck;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();
    }

    @Test
    public void testNumberOfCards() {
        assertEquals(52, deck.getNumberOfCards());
    }

    @Test
    public void testTopCard() {
        Card card = deck.getTopCard();
        assertNotNull(card);
    }

    @Test
    public void testCardsAreDifferent() {
        Card card1 = deck.getTopCard();
        Card card2 = deck.getTopCard();

        if(card1.getSuit() == card2.getSuit() && card1.getRank() == card2.getRank()){
            fail();
        }
    }
}
