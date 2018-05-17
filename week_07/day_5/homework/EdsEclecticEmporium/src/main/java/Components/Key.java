package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class Key extends Component implements IPlay {

    public Key(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Plink";
    }

}
