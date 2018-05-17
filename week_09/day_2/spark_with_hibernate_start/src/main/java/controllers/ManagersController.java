package controllers;

import db.DBHelper;
import models.Department;
import models.Employee;
import models.Manager;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ManagersController {

    public ManagersController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/managers", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Manager> managers = DBHelper.getAll(Manager.class);

            model.put("template", "templates/managers/index.vtl");
            model.put("managers", managers);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        get("/managers/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();

            List<Department> departments = DBHelper.getAll(Department.class);

            model.put("template", "templates/managers/create.vtl");
            model.put("departments", departments);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());

        post("/managers", (req, res) -> {

            int departmentId = Integer.parseInt(req.queryParams("department"));
            Department department = DBHelper.find(departmentId, Department.class);
            String firstName = req.queryParams("firstName");
            String lastName = req.queryParams("lastName");
            int salary = Integer.parseInt(req.queryParams("salary"));
            double budget = Double.parseDouble(req.queryParams("budget"));

            Manager manager = new Manager(firstName, lastName, salary, department, budget);

            DBHelper.save(manager);

            res.redirect("/managers");

            return null;

        }, new VelocityTemplateEngine());


        get("/managers/:id/edit", (req, res) -> {

            Integer id = Integer.parseInt(req.params(":id"));

            Manager manager = DBHelper.find(id, Manager.class);

            List<Department> departments = DBHelper.getAll(Department.class);

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/managers/edit.vtl");
            model.put("departments", departments);
            model.put("manager", manager);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        post("/managers/:id", (req, res) -> {

            Integer id = Integer.parseInt(req.params(":id"));

            Manager manager = DBHelper.find(id, Manager.class);

            Integer departmentId = Integer.parseInt(req.queryParams("department"));

            Department department = DBHelper.find(departmentId, Department.class);
            String firstName = req.queryParams("firstName");
            String lastName = req.queryParams("lastName");
            int salary = Integer.parseInt(req.queryParams("salary"));
            double budget = Double.parseDouble(req.queryParams("budget"));

            manager.setFirstName(firstName);
            manager.setLastName(lastName);
            manager.setDepartment(department);
            manager.setSalary(salary);
            manager.setBudget(budget);

            DBHelper.save(manager);

            res.redirect("/managers");

            return null;

        }, new VelocityTemplateEngine());

        get("/managers/:id", (req, res) -> {

            Integer id = Integer.parseInt(req.params(":id"));

            Manager manager = DBHelper.find(id, Manager.class);

            Map<String, Object> model = new HashMap<>();

            model.put("template", "templates/managers/show.vtl");
            model.put("manager", manager);

            return new ModelAndView(model, "templates/layout.vtl");

        }, new VelocityTemplateEngine());


        post("/managers/:id/delete", (req, res) -> {

            Integer id = Integer.parseInt(req.params(":id"));

            Manager manager = DBHelper.find(id, Manager.class);

            DBHelper.delete(manager);

            res.redirect("/managers");

            return null;

        }, new VelocityTemplateEngine());

    }

}
