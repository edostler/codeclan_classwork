package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class GuitarString extends Component implements IPlay {

    public GuitarString(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Twang";
    }

}
