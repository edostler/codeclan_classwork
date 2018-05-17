public class Game {
    private Player player1;
    private Player player2;
    private Deck deck;

    private Player winner;

    public Game(Player player1, Player player2, Deck deck) {
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
    }

    public void start() {
        // Pull two cards from deck
        Card card1 = deck.getTopCard();
        Card card2 = deck.getTopCard();

        // Give the cards to the players
        player1.takeCard(card1);
        player2.takeCard(card2);

        // Compare the values of the players' cards
        decideWinner();
    }

    public void decideWinner() {
        if(player1.getHand().getTotal() > player2.getHand().getTotal()){
            winner = player1;
        }else{
            winner = player2;
        }
    }

    public Player getWinner() {
        return winner;
    }
}
