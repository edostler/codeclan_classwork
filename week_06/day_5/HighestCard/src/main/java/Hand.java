import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public int getSize() {
        return cards.size();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public int getTotal() {
        int total = 0;
        for(Card card: cards){
            total = total + card.getScore();
        }

        return total;
    }
}
