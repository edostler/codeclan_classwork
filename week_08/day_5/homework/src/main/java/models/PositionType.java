package models;

public enum PositionType {

    GOALKEEPER("Goalkeeper"),
    DEFENDER("Defender"),
    MIDFIELDER("Midfielder"),
    STRIKER("Striker");

    private String position;

    PositionType(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

}
