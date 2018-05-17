package Enums;

public enum Colour {

    BLUE("Blue"),
    RED("Red"),
    ORANGE("Orange"),
    PURPLE("Purple"),
    YELLOW("Yellow"),
    BLACK("Black"),
    WHITE("White"),
    GREEN("Green");

    private String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

}
