package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class Valve extends Component implements IPlay {

    public Valve(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Pah-pa-rah";
    }

}
