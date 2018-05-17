package Components;

import Interfaces.IPlay;
import ParentClasses.Component;

public class BassDrum extends Component implements IPlay {

    public BassDrum(String productName, double buyingPrice, String sound) {
        super(productName, buyingPrice, sound);
    }

    @Override
    public String play() {
        return "Dum";
    }

}