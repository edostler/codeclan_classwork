public class Player {
    private String name;
    private Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public Hand getHand() {
        return hand;
    }
}
