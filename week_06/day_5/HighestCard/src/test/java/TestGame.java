import org.junit.Before;
import org.junit.Test;

public class TestGame {
    Deck deck;

    Hand hand1;
    Hand hand2;

    Player player1;
    Player player2;

    Game game;

    @Before
    public void setUp() throws Exception {
        deck = new Deck();

        hand1 = new Hand();
        hand2 = new Hand();

        player1 = new Player("John", hand1);
        player2 = new Player("Danny", hand2);

        game = new Game(player1, player2, deck);
    }

    @Test
    public void testGameGeneratesWinner() {
        game.start();

        assert(game.getWinner() instanceof Player);
    }
}
