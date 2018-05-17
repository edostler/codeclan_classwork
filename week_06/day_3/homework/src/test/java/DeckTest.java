import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    private Deck deck;
    private Card card1;
    private Card card2;

    @Before
    public void before() {
        deck = new Deck();
        card1 = new Card(SuitType.HEARTS, RankType.QUEEN);
        card2 = new Card(SuitType.CLUBS, RankType.SEVEN);
    }

    @Test
    public void canGetDeckSize() {
        assertEquals(0, deck.getDeckSize());
    }

    @Test
    public void canAddCardToHand() {
        assertEquals(0, deck.getDeckSize());
        deck.addCardToDeck(card1);
        ArrayList<Card> result = deck.getDeck();
        assertEquals(1, deck.getDeckSize());
        assertTrue(result.contains(card1));
    }

    @Test
    public void canGetOccurrenceOfCardInDeck() {
        deck.addCardToDeck(card1);
        deck.addCardToDeck(card1);
        deck.addCardToDeck(card2);
        assertEquals(2, deck.getOccurrenceOfCardInDeck(card1));
        assertEquals(1, deck.getOccurrenceOfCardInDeck(card2));
    }

    @Test
    public void canGenerateDeck() {
        deck.generateDeck();
        assertEquals(52, deck.getDeckSize());
//        assertEquals(1, deck.getOccurrenceOfCardInDeck(card1));
//        assertEquals(1, deck.getOccurrenceOfCardInDeck(card2));
    }

    @Test
    public void canGetDeckSuitTypes() {
        deck.generateDeck();
        SuitType[] expected = {SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.HEARTS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.DIAMONDS, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.SPADES, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS, SuitType.CLUBS};
        SuitType[] suits = deck.getDeckSuitTypes();
        assertArrayEquals(expected, suits);
    }

    @Test
    public void canGetDeckRankTypes() {
        deck.generateDeck();
        RankType[] expected = {RankType.ACE, RankType.TWO, RankType.THREE, RankType.FOUR, RankType.FIVE, RankType.SIX, RankType.SEVEN, RankType.EIGHT, RankType.NINE, RankType.TEN, RankType.JACK, RankType.QUEEN, RankType.KING, RankType.ACE, RankType.TWO, RankType.THREE, RankType.FOUR, RankType.FIVE, RankType.SIX, RankType.SEVEN, RankType.EIGHT, RankType.NINE, RankType.TEN, RankType.JACK, RankType.QUEEN, RankType.KING, RankType.ACE, RankType.TWO, RankType.THREE, RankType.FOUR, RankType.FIVE, RankType.SIX, RankType.SEVEN, RankType.EIGHT, RankType.NINE, RankType.TEN, RankType.JACK, RankType.QUEEN, RankType.KING, RankType.ACE, RankType.TWO, RankType.THREE, RankType.FOUR, RankType.FIVE, RankType.SIX, RankType.SEVEN, RankType.EIGHT, RankType.NINE, RankType.TEN, RankType.JACK, RankType.QUEEN, RankType.KING};
        RankType[] ranks = deck.getDeckRankTypes();
        assertArrayEquals(expected, ranks);
    }

    @Test
    public void canDealCard() {
        deck.generateDeck();
        Card randomCard = deck.dealCard();
        ArrayList<Card> currentDeck = deck.getDeck();
        assertFalse(currentDeck.contains(randomCard));
    }

}
