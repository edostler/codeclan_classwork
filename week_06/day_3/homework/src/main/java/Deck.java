import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    //declarations
    private ArrayList<Card> deck;
    private SuitType[] suits;
    private RankType[] ranks;

    //constructor
    public Deck() {
        this.deck = new ArrayList<Card>();
        this.suits = new SuitType[52];
        this.ranks = new RankType[52];
    }

    //methods
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public int getDeckSize() {
        return this.deck.size();
    }

    public void addCardToDeck(Card card) {
        this.deck.add(card);
    }

    public int getOccurrenceOfCardInDeck(Card searchCard) {
        int i = 0;
        for (Card card : deck) {
            if (card == searchCard) {
                i += 1;
            }
        }
        return i;
    }

    public SuitType[] getDeckSuitTypes() {
        int i = 0;
        for (Card card : deck) {
            this.suits[i] = card.getSuit();
            i += 1;
        }
        return suits;
    }

    public RankType[] getDeckRankTypes() {
        int i = 0;
        for (Card card : deck) {
            this.ranks[i] = card.getRank();
            i += 1;
        }
        return ranks;
    }

    public void generateDeck() {
        for (SuitType suit : SuitType.values()) {
            for (RankType rank : RankType.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public Card dealCard() {
        Collections.shuffle(deck);
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

}
