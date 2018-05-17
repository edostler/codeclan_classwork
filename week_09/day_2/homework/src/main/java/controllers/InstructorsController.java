package controllers;

import db.DBHelper;
import models.Course;
import models.Instructor;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class InstructorsController {

    public InstructorsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/instructors", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Instructor> instructors = DBHelper.getAll(Instructor.class);

            model.put("template", "templates/instructors/index.vtl");
            model.put("instructors", instructors);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }

}
