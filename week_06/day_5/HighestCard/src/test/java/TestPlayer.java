import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlayer {
    Hand hand;
    Card card;
    Player player;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();
        card = new Card(Suit.SPADES, Rank.ACE);

        player = new Player("John", hand);
    }

    @Test
    public void testCanGivePlayerACard() {
        player.takeCard(card);
        assertEquals(1, player.getHand().getSize());
    }
}
