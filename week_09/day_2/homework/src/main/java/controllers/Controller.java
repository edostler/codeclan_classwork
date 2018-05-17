package controllers;

import db.Seeds;

public class Controller {
    public static void main(String[] args) {

        Seeds.seedData();

        CoursesController coursesController = new CoursesController();
        InstructorsController instructorsController = new InstructorsController();
        LessonsController lessonsController = new LessonsController();
        StudentsController studentsController = new StudentsController();

    }

}
