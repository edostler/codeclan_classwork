import java.util.ArrayList;

public class Hand {

    //declarations
    private ArrayList<Card> hand;

    //constructor
    public Hand() {
        this.hand = new ArrayList<Card>();
    }

    //methods
    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandSize() {
        return this.hand.size();
    }

    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    public int calculateTotal() {
        int i = 0;
        for (Card card : hand) {
            i += card.getRankValueFromRank();
        }
        return i;
    }

}
