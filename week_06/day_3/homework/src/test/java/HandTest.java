import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandTest {

    private Hand hand;
    private Card card1;
    private Card card2;

    @Before
    public void before() {
        hand = new Hand();
        card1 = new Card(SuitType.HEARTS, RankType.QUEEN);
        card2 = new Card(SuitType.CLUBS, RankType.SEVEN);
    }

    @Test
    public void canGetHandSize() {
        assertEquals(0, hand.getHandSize());
    }

    @Test
    public void canAddCardToHand() {
        assertEquals(0, hand.getHandSize());
        hand.addCardToHand(card1);
        ArrayList<Card> result = hand.getHand();
        assertEquals(1, hand.getHandSize());
        assertTrue(result.contains(card1));
    }

    @Test
    public void canCalculateTotal() {
        hand.addCardToHand(card1);
        hand.addCardToHand(card2);
        assertEquals(17, hand.calculateTotal());
    }

}
