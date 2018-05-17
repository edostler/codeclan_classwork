package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class Cymbal extends Component implements IPlay {

    public Cymbal(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Clash";
    }

}
