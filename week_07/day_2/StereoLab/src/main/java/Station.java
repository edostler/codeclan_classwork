public class Station {

    private String stationName;
    private double frequency;

    public Station(String stationName, double frequency) {
        this.stationName = stationName;
        this.frequency = frequency;
    }

    public String getStationName() {
        return stationName;
    }

    public double getFrequency() {
        return frequency;
    }
}
