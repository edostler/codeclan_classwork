import models.Game;
import spark.ModelAndView;

import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;

public class Controller {

    public static void main(String[] args) {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/randomGame", (req, res) -> {

            String result = Game.getGame();

            HashMap<String, Object> model = new HashMap<>();
            model.put("game", result);

            return new ModelAndView(model, "result.vtl");

        }, velocityTemplateEngine);

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

    }

}
