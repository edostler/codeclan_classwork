import java.util.HashMap;

public class HashmapDemo {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        //creating a new hashmap
        HashMap<String, String> favouriteFruits = new HashMap<>();
        //to add to a hashmap (we can't store primitive values in hashmaps, like ints or booleans)
        favouriteFruits.put("Ed", "apple");
        favouriteFruits.put("Emma", "banana");
        favouriteFruits.put("Ellie", "blueberry");
        //to get from a hashmap
        System.out.println(favouriteFruits.get("Emma"));
        //to store and get an integer (can't be int)
        HashMap<String, Integer> personAge = new HashMap<>();
        personAge.put("Ed", 31);
        System.out.println(personAge.get("Ed"));
    }

}
