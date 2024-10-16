package jdk8;

import java.util.*;
import java.util.stream.Collectors;

public class SortMap {

    public LinkedHashMap<String,Integer> sortMap(HashMap<String,Integer> map){
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList,(obj1,obj2) -> obj1.getValue().compareTo(obj2.getValue()));
        entryList.stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).collect(Collectors.toList());
        LinkedHashMap<String,Integer> resultMap = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry: entryList){
            resultMap.put(entry.getKey(),entry.getValue());
        }
        return resultMap;
    }

    public static void main(String[] args){
        HashMap<String ,Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        LinkedHashMap<String ,Integer> sortedMap = new SortMap().sortMap(map);
        System.out.println("Done");
    }

}
