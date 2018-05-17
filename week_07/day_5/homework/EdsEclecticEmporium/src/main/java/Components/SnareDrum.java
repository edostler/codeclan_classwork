package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class SnareDrum extends Component implements IPlay {

    public SnareDrum(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Ba";
    }

}
