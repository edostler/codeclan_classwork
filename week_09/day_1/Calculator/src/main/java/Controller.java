import models.Calculator;

import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class Controller {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/add/:name/:num1/:num2", (req, res) -> {
            String name = req.params(":name");
            Integer num1 = Integer.parseInt(req.params(":num1"));
            Integer num2 = Integer.parseInt(req.params(":num2"));

            Calculator calculator = new Calculator(num1, num2);
            int result = calculator.add();

            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);
            model.put("name", name);

            return new ModelAndView(model, "result.vtl");

        }, velocityTemplateEngine);


        get("/subtract/:num1/:num2", (req, res) -> {
            Integer num1 = Integer.parseInt(req.params(":num1"));
            Integer num2 = Integer.parseInt(req.params(":num2"));

            Calculator calculator = new Calculator(num1, num2);
            int result = calculator.subtract();
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);

            return new ModelAndView(model, "result.vtl");

        }, velocityTemplateEngine);


        get("/multiply/:num1/:num2", (req, res) -> {
            Integer num1 = Integer.parseInt(req.params(":num1"));
            Integer num2 = Integer.parseInt(req.params(":num2"));

            Calculator calculator = new Calculator(num1, num2);
            int result = calculator.multiply();
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);

            return new ModelAndView(model, "result.vtl");

        }, velocityTemplateEngine);


        get("/divide/:num1/:num2", (req, res) -> {
            Integer num1 = Integer.parseInt(req.params(":num1"));
            Integer num2 = Integer.parseInt(req.params(":num2"));

            Calculator calculator = new Calculator(num1, num2);
            double result = calculator.divide();
            HashMap<String, Object> model = new HashMap<>();
            model.put("result", result);

            return new ModelAndView(model, "result.vtl");

        }, velocityTemplateEngine);

    }

}
