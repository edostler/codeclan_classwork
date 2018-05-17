public class Player {

    //declarations
    private String name;
    private Hand hand;

    //constructor
    public Player(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
    }

    //methods
    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
