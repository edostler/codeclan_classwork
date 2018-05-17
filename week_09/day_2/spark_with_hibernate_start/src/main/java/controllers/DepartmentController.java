package controllers;

import db.DBHelper;
import models.Department;
import models.Employee;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class DepartmentController {

    public DepartmentController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/departments", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Department> departments = DBHelper.getAll(Department.class);

            model.put("template", "templates/departments/index.vtl");
            model.put("departments", departments);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/departments/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/departments/create.vtl");

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        post("/departments", (req, res) -> {

            String title = req.queryParams("title");

            Department department = new Department(title);

            DBHelper.save(department);

            res.redirect("/departments");

            return null;

        }, new VelocityTemplateEngine());


        get("/department/team/:id", (req, res) -> {

            Integer id = Integer.parseInt(req.params(":id"));
            Department department = DBHelper.find(id, Department.class);
            String title = department.getTitle();

            List<Employee> employees = DBHelper.findEmployeesForDept(department);

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/employees/index.vtl");
            model.put("employees", employees);
            model.put("title", title);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

    }

}