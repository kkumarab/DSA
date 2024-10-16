package strings.easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencySort {
    public String frequencySort(String s) {
        HashMap<Character,Integer> frMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            frMap.put(s.charAt(i),frMap.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> lst = new LinkedList<>(frMap.entrySet());
        lst = lst.parallelStream().sorted((o1,o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for(int i=0;i<lst.size();i++){
            Map.Entry entry = lst.get(i);
            for(int j = 0; j < (Integer)entry.getValue(); j++){
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        new FrequencySort().frequencySort("ccaaa");
    }
}
