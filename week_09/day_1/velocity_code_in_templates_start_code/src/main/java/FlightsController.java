import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class FlightsController {
    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        staticFileLocation("/public");



        ArrayList<Flight> flights = new ArrayList<>();

        Flight flight1 = new Flight("SC666", "Scottish Airways","Inverness", "New York");
        flight1.setSeatsAvailable(false);

        Flight flight2 = new Flight("GX123", "Glasgow Flights","Glasgow", "Edinburgh");

        Flight flight3 = new Flight("GX666", "Glasgow Flights","Glasgow", "Bristol");

        Flight flight4 = new Flight("GX765", "Glasgow Flights","Glasgow", "Coventry");

        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);



        get("/flights", (req, res) -> {

            HashMap<String, Object> model = new HashMap<>();
            model.put("flights", flights);

            model.put("template", "flights.vtl");

            return new ModelAndView(model, "layout.vtl");
        }, velocityTemplateEngine);
    }
}
