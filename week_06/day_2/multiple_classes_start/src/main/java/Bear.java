import java.util.ArrayList;

public class Bear {

    //declarations
    private String name;
    private ArrayList<Salmon> belly;

    //constructor
    public Bear(String name) {
        this.name = name;
        this.belly = new ArrayList<>();
    }

    //methods
    public int checkBellySize() {
        return this.belly.size();
    }

    public void eatSalmon(River river) {
        Salmon salmon = river.removeSalmon();
        this.belly.add(salmon);
    }

    public void shitInTheWoods() {
        this.belly.clear();
    }

}
