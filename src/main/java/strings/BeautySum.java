package strings;

import java.util.*;

public class BeautySum {


    public int beautySum(String s) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<s.length();i++){
            Character key = s.charAt(i);
            if(map.containsKey(key)){
                int count = map.get(key);
                map.put(key,count+1);
            }
            else{
                map.put(key,1);
            }
        }
        List<Map.Entry<Character,Integer>> lst = new ArrayList<>(map.entrySet());
        Collections.sort(lst,(o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        return (lst.get(0).getValue() + lst.get(lst.size()-1).getValue());
    }

    public static void main(String[] args){
        int result = new BeautySum().beautySum("aabcbaa");
        System.out.println(result);
    }
}
