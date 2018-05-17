import org.junit.Before;

public class PlayerTest {

    private Player player;
    private Hand hand;
    private Card card;

    @Before
    public void before() {
        hand = new Hand();
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        hand.addCardToHand(card);
        player = new Player("Ed", hand);
    }

}
