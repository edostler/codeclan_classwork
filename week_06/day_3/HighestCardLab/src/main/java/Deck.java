import java.util.ArrayList;

public class Deck {

    //declarations
    private ArrayList<Card> deck;

    //constructor
    public Deck() {
        this.deck = new ArrayList<Card>();
    }

    //methods
    public int getDeckSize() {
        return this.deck.size();
    }

    public void generateDeck() {
        for (SuitType suit : SuitType.values()) {
            for (RankType rank : RankType.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void dealCard() {

    }
}
