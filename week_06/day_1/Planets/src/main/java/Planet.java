public class Planet {

    //declarations
    private String name;
    private int size;

    //constructor
    public Planet(String name, int size){
        this.name = name;
        this.size = size;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

//    using string concatenation
//    public String explode() {
//        return "Boom! " + this.name + " has exploded.";
//    }
//
//    using interpolation
//    public String explode() {
//        return String.format("Boom! %s has exploded.", this.name);
//    }

//    using interpolation with second interpolation
    public String explode() {
        return String.format("Boom! %s has exploded because it's size is now %d.", this.name, this.size);
    }

}
