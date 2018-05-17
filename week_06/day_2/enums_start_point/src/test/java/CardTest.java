import static org.junit.Assert.*;
        import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(SuitType.HEARTS, ValueType.QUEEN);
    }

    @Test
    public void canGetSuit() {
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void queenHasValueTen() {
        card = new Card(SuitType.HEARTS, ValueType.QUEEN);
        assertEquals(10, card.getValueFromEnum());
    }

    @Test
    public void canGetAllSuits() {
        SuitType[] expected = {SuitType.HEARTS, SuitType.DIAMONDS, SuitType.SPADES, SuitType.CLUBS};
        SuitType[] suits = SuitType.values();
        assertEquals(4, suits.length);
        assertArrayEquals(expected, suits);
    }

}