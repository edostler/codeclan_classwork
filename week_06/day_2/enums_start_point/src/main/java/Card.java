public class Card {

    private SuitType suit;
    private ValueType value;

    public Card(SuitType suit, ValueType value) {
        this.suit = suit;
        this.value = value;
    }

    public SuitType getSuit() {
        return this.suit;
    }
    //the getValue method being called here is going to be written in the Enums ValueType
    public int getValueFromEnum() {
        return this.value.getValue();
    }

}