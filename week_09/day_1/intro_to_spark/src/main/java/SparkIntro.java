import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static spark.Spark.get;

public class SparkIntro {

    public static void main(String[] args) {
        //at this point there will be a red line of doom, alt enter and set language levels to 8.
        get("/hello", (req, res) -> {
            return "Hello World!";
        });

        get("/randomName", (req, res) -> {
            ArrayList<String> names = new ArrayList<>();
            names.add("Ed");
            names.add("Phil");
            names.add("Emma");
            Collections.shuffle(names);
            return names.get(0);
        });

        get("/hello/:name", (req, res) -> {
            return "Hello " + req.params(":name");
        });

        get("/friends/:number", (req, res) -> {
            String[] friends = {"Jack", "Victor", "Isa", "Winston"};
            int index = Integer.parseInt(req.params(":number"));
            return friends[index];
        });

        get("add/:num1/:num2", (req, res) -> {
            int num1 = Integer.parseInt(req.params(":num1"));
            int num2 = Integer.parseInt(req.params(":num2"));
            return num1 + num2;
        });

    }

}
