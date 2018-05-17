import java.util.ArrayList;

public class Radio extends Component {

    private ArrayList<Station> stations;
    private Station tunedStation;

    public Radio(String make, String model, Station tunedStation) {
        super(make, model);
        this.tunedStation = tunedStation;
        this.stations = new ArrayList<>();
    }

    public String getTunedStationName() {
        return tunedStation.getStationName();
    }

    public double getTunedFrequency() {
        return tunedStation.getFrequency();
    }

    public Station getTunedStation() {
        return tunedStation;
    }

    public void setTunedStation(Station station) {
        this.tunedStation = station;
    }

    public int getStationsSize() {
        return stations.size();
    }

    public void addStationToRadio(Station station) {
        stations.add(station);
    }

}
