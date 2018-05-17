package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Randomiser {

    public static List<String> getNames(int amount) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ed");
        names.add("Auld Danny");
        names.add("J");
        names.add("Paul");
        names.add("Ellie");
        names.add("Jean");
        names.add("Chris");
        names.add("Angus");
        names.add("Christie");
        names.add("Steven");
        names.add("Jim");
        names.add("Ria");
        names.add("Victor");
        names.add("Sarah");
        names.add("Graeme");
        names.add("Debbie");
        names.add("Young Danny");
        names.add("Emma");
        Collections.shuffle(names);

        if (amount > names.size()) {
            return names;
        }
        else {
            return names.subList(0, amount);
        }

    }

//    refactored in homework review
//    private ArrayList<String> names;
//
//    public Randomiser() {
//        this.names = new ArrayList<>();
//        names.add("Ed");
//        names.add("Auld Danny");
//        names.add("J");
//        names.add("Paul");
//        names.add("Ellie");
//        names.add("Jean");
//        names.add("Chris");
//        names.add("Angus");
//        names.add("Christie");
//        names.add("Steven");
//        names.add("Jim");
//        names.add("Ria");
//        names.add("Victor");
//        names.add("Sarah");
//        names.add("Graeme");
//        names.add("Debbie");
//        names.add("Young Danny");
//        names.add("Emma");
//    }

//    public String getOne() {
//        if (this.names.size() < 1) {
//            return "No names in list";
//        }
//        else {
//            Collections.shuffle(this.names);
//            return this.names.get(0);
//        }
//    }
//
//    public ArrayList<String> getTwo() {
//        if (this.names.size() < 1) {
//            names.add("No names in list");
//            return names;
//        }
//        else if (this.names.size() < 3) {
//            return names;
//        }
//        else {
//            Collections.shuffle(names);
//            ArrayList<String> twoNames = new ArrayList<>();
//            twoNames.add(names.get(0));
//            twoNames.add(names.get(1));
//            return twoNames;
//        }
//    }
//
//    public ArrayList<String> getThree() {
//        if (this.names.size() < 1) {
//            names.add("No names in list");
//            return names;
//        }
//        else if (this.names.size() < 4) {
//            return names;
//        }
//        else {
//            Collections.shuffle(names);
//            ArrayList<String> threeNames = new ArrayList<>();
//            threeNames.add(names.get(0));
//            threeNames.add(names.get(1));
//            threeNames.add(names.get(2));
//            return threeNames;
//        }
//    }
//
//    public ArrayList<String> getFour() {
//        if (this.names.size() < 1) {
//            names.add("No names in list");
//            return names;
//        }
//        else if (this.names.size() < 5) {
//            return names;
//        }
//        else {
//            Collections.shuffle(names);
//            ArrayList<String> fourNames = new ArrayList<>();
//            fourNames.add(names.get(0));
//            fourNames.add(names.get(1));
//            fourNames.add(names.get(2));
//            fourNames.add(names.get(3));
//            return fourNames;
//        }
//    }

}
