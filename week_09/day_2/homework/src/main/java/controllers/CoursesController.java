package controllers;

import db.DBHelper;
import models.Course;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class CoursesController {

    public CoursesController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/courses", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Course> courses = DBHelper.getAll(Course.class);

            model.put("template", "templates/courses/index.vtl");
            model.put("courses", courses);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }
}
