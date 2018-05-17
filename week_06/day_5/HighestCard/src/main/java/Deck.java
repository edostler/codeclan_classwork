import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        populate();
    }

    private void populate() {
        // for each suit in Suits
        for(Suit suit: Suit.values()){

            // for each rank, create a new card along with the suit
            for(Rank rank: Rank.values()){
                Card card = new Card(suit, rank);

                // Add the card to this.cards
                cards.add(card);
            }
        }

        Collections.shuffle(cards);
    }

    public int getNumberOfCards() {
        return cards.size();
    }

    public Card getTopCard() {
        return this.cards.remove(0);
    }
}
