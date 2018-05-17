package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class TomTom extends Component implements IPlay {

    public TomTom(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Tom-tom";
    }

}
