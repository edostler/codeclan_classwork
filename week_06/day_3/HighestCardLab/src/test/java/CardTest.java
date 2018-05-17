import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
    }

    @Test
    public void canGetSuit() {
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(RankType.QUEEN, card.getRank());
    }

    @Test
    public void canGetRankValue() {
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        assertEquals(10, card.getRankValueFromRank());
    }

    @Test
    public void canGetAllSuits() {
        SuitType[] expected = {SuitType.HEARTS, SuitType.DIAMONDS, SuitType.SPADES, SuitType.CLUBS};
        SuitType[] suits = card.getAllSuits();
        assertEquals(4, suits.length);
        assertArrayEquals(expected, suits);
    }

    @Test
    public void canGetAllRanks() {
        RankType[] expected = {RankType.ACE, RankType.TWO, RankType.THREE, RankType.FOUR, RankType.FIVE, RankType.SIX, RankType.SEVEN, RankType.EIGHT, RankType.NINE, RankType.TEN, RankType.JACK, RankType.QUEEN, RankType.KING};
        RankType[] ranks = card.getAllRanks();
        assertEquals(13, ranks.length);
        assertArrayEquals(expected, ranks);
    }

}