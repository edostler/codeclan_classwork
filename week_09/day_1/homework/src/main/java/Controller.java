import models.Randomiser;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.staticFileLocation;
import static spark.Spark.get;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        staticFileLocation("/public");

        get("/result/:number", (req, res) -> {

            int amount = Integer.parseInt(req.params(":number"));

            List<String> results = Randomiser.getNames(amount);
//
            HashMap<String, Object> model = new HashMap<>();
            model.put("results", results);

            model.put("template", "result.vtl");

            return new ModelAndView(model, "layout.vtl");

        }, velocityTemplateEngine);

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });



//        refactored from homework review
//        Randomiser randomiser = new Randomiser();

//        get("/one", (req, res) -> {
//
//            String result = randomiser.getOne();
//
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("result", result);
//
//            model.put("template", "one.vtl");
//
//            return new ModelAndView(model, "layout.vtl");
//
//        }, velocityTemplateEngine);
//
//
//        get("/two", (req, res) -> {
//
//            ArrayList<String> results = randomiser.getTwo();
//
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("results", results);
//
//            model.put("template", "group.vtl");
//
//            return new ModelAndView(model, "layout.vtl");
//
//        }, velocityTemplateEngine);
//
//
//        get("/three", (req, res) -> {
//
//            ArrayList<String> results = randomiser.getThree();
//
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("results", results);
//
//            model.put("template", "group.vtl");
//
//            return new ModelAndView(model, "layout.vtl");
//
//        }, velocityTemplateEngine);
//
//
//        get("/four", (req, res) -> {
//
//            ArrayList<String> results = randomiser.getFour();
//
//            HashMap<String, Object> model = new HashMap<>();
//            model.put("results", results);
//
//            model.put("template", "group.vtl");
//
//            return new ModelAndView(model, "layout.vtl");
//
//        }, velocityTemplateEngine);


    }

}
