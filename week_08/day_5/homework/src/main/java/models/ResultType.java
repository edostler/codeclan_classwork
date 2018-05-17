package models;

public enum ResultType {

    WIN("Win", 3),
    DRAW("Draw", 1),
    LOSS("Loss", 0);

    private String result;
    private int points;

    ResultType(String result, int points) {
        this.result = result;
        this.points = points;
    }

    public String getResult() {
        return result;
    }

    public int getPoints() {
        return points;
    }

}
