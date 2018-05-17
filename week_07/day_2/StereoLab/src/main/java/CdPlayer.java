import java.util.ArrayList;

public class CdPlayer extends Component {

    private ArrayList<Cd> cdLibrary;
    private int capacity;
    private Cd currentCd;

    public CdPlayer(String make, String model, int capacity) {
        super(make, model);
        this.capacity = capacity;
        this.cdLibrary = new ArrayList<>();
        this.currentCd = null;
    }

    public int getCapacity() {
        return capacity;
    }

    public Cd getCurrentCd() {
        return currentCd;
    }

    public String getCurrentCdTitle() {
        return currentCd.getTitle();
    }

    public String getCurrentCdArtist() {
        return currentCd.getArtist();
    }

    public void setCurrentCd(Cd cd) {
        this.currentCd = cd;
    }

    public int getCdLibrarySize() {
        return cdLibrary.size();
    }

    public void addCdToLibrary(Cd cd) {
        cdLibrary.add(cd);
    }
}
