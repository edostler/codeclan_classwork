import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Game game;
    private Deck deck;
    private Card card1;
    private Card card2;
    private Player player1;
    private Player player2;
    private Hand hand1;
    private Hand hand2;
    private Hand p1hand;
    private Hand p2hand;

    @Before
    public void before() {
        deck = new Deck();
        deck.generateDeck();
        game = new Game(deck);
        hand1 = new Hand();
        hand2 = new Hand();
        p1hand = new Hand();
        p2hand = new Hand();
        card1 = new Card(SuitType.HEARTS, RankType.QUEEN);
        card2 = new Card(SuitType.CLUBS, RankType.SEVEN);
        hand1.addCardToHand(card1);
        hand2.addCardToHand(card2);
        player1 = new Player("Ed", hand1);
        player2 = new Player("Phil", hand2);
    }

    @Test
    public void canGetPlayerSize() {
        assertEquals(0, game.getPlayerSize());
    }

    @Test
    public void canAddPlayerToGame() {
        assertEquals(0, game.getPlayerSize());
        game.addPlayerToGame(player1);
        ArrayList<Player> result = game.getPlayers();
        assertEquals(1, game.getPlayerSize());
        assertTrue(result.contains(player1));
        assertFalse(result.contains(player2));
    }

    @Test
    public void canDeclareWinner__player_1_wins() {
        p1hand = player1.getHand();
        p2hand = player2.getHand();
        String winner = game.declareWinner(p1hand, p2hand);
        assertEquals("Player 1 Wins!", winner);
    }

    @Test
    public void canDeclareWinner__player_2_wins() {
        p2hand = player1.getHand();
        p1hand = player2.getHand();
        String winner = game.declareWinner(p1hand, p2hand);
        assertEquals("Player 2 Wins!", winner);
    }

    @Test
    public void canDeclareWinner__draw() {
        p1hand = player1.getHand();
        p2hand = player1.getHand();
        String winner = game.declareWinner(p1hand, p2hand);
        assertEquals("Draw!", winner);
    }

    @Test
    public void canPlayGame() {

        //    add player1
        //    add player2
        //    generate deck
        //    set game deck to deck
        //    get game deck
        //    deal card1 (set game deck?)
        //    get p1 hand
        //    add card1 to p1 hand (set p1 hand?)
        //    get game deck
        //    deal card2 (set game deck?)
        //    get p2 hand
        //    add card2 to p2 hand (set p2 hand?)
        //    check total of each players hand
        //    declare winner
    }

}