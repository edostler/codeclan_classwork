package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class HiHat extends Component implements IPlay {

    public HiHat(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Tish";
    }

}
