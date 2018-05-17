import db.DBHelper;
import models.Child;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Child liesl = new Child("Liesl", 16, "Soprano");
        Child friedrich = new Child("Friedrich", 14, "Tenor");
        Child louisa = new Child("Louisa", 13, "Contralto");
        Child kurt = new Child("Kurt", 11, "Tenor");
        Child brigitta = new Child("Brigitta", 10, "Soprano");
        Child marta = new Child("Marta", 7, "Mezzo-Soprano");
        Child gretl = new Child("Gretl", 5, "Soprano");

        DBHelper.saveOrUpdate(liesl);
        DBHelper.saveOrUpdate(friedrich);
        DBHelper.saveOrUpdate(louisa);
        DBHelper.saveOrUpdate(kurt);
        DBHelper.saveOrUpdate(brigitta);
        DBHelper.saveOrUpdate(marta);
        DBHelper.saveOrUpdate(gretl);

        friedrich.setRange("Bass");
        DBHelper.saveOrUpdate(friedrich);

        List<Child> children = DBHelper.getAll(Child.class);

        Child foundChild = DBHelper.findByName(liesl.getName());

        List<Child> childrenByAgeDesc = DBHelper.orderByAgeDesc();

        List<Child> childrenByAgeAsc = DBHelper.orderByAgeAsc();

        List<Child> foundChildren = DBHelper.findByRange("Soprano");

        List<Child> chilrenLessThan10 = DBHelper.findByAgeLessThan(10);

        Integer oldestAge = DBHelper.getOldestAge();

        Child oldestChild = DBHelper.getOldestChild();

        Integer youngestAge = DBHelper.getYoungestAge();

        Child youngestChild = DBHelper.getYoungestChild();

        Double averageAge = DBHelper.getAverageAge();

        Long totalAge = DBHelper.getTotalAge();

    }
}
