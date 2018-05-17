import java.util.ArrayList;

public class Game {

    //declarations
    private ArrayList<Player> players;
    private Deck deck;
    private String winner;
    private int p1total;
    private int p2total;

    //constructor
    public Game(Deck deck) {
        this.players = new ArrayList<Player>();
    }

    //methods
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getPlayerSize() {
        return this.players.size();
    }

    public void addPlayerToGame(Player player) {
        this.players.add(player);
    }

    public String declareWinner(Hand p1hand, Hand p2hand) {
        p1total = p1hand.calculateTotal();
        p2total = p2hand.calculateTotal();
        if (p1total > p2total) {
            return winner = "Player 1 Wins!";
        }
        else if (p2total > p1total) {
            return winner = "Player 2 Wins!";
        }
        else {
            return winner = "Draw!";
        }
    }

    public void playGame() {

        //    add player1
        //    add player2
        //    generate deck
        //    set game deck to deck
        //    get game deck
        //    deal card1 (set game deck?)
        //    get p1 hand
        //    add card1 to p1 hand (set p1 hand?)
        //    get game deck
        //    deal card2 (set game deck?)
        //    get p2 hand
        //    add card2 to p2 hand (set p2 hand?)
        //    check total of each players hand
        //    declare winner

    }

}
