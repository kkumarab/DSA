package jdk8;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ListOperations {

    public ArrayList<String> sortList(ArrayList<String> lst){
        lst = (ArrayList<String>) lst.stream().sorted().collect(Collectors.toList());
        return lst;
    }

    public ArrayList<String> filterList(ArrayList<String> lst){
        lst = (ArrayList<String>) lst.stream().filter(obj -> obj.equals("two")||obj.equals("four")).collect(Collectors.toList());
        return lst;
    }

    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        names.add("three");
        names.add("four");
        names = new ListOperations().sortList(names);
        System.out.println("Done");
        names = new ListOperations().filterList(names);
        System.out.println("done");
    }
}
