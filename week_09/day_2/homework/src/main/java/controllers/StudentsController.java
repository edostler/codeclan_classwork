package controllers;

import db.DBHelper;
import models.Course;
import models.Student;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class StudentsController {

    public StudentsController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/students", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Student> students = DBHelper.getAll(Student.class);

            model.put("template", "templates/students/index.vtl");
            model.put("students", students);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }

}
