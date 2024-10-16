package strings;

import java.util.ArrayList;

public class GetAllPermutations {



    public ArrayList<String> getPermutations(String str, String answer, ArrayList<String> allPermutations){
        if(str.length()==0){
            allPermutations.add(answer);
            return allPermutations;
        }
        for(int i=0;i<str.length();i++){
            String ros = str.substring(0,i) + str.substring(i+1);
            char c = str.charAt(i);
            getPermutations(ros,answer + c, allPermutations);
        }
        return allPermutations;
    }

    public static void main(String[] args){
        ArrayList<String> lst = new GetAllPermutations().getPermutations("abc","", new ArrayList<>());
        for(String str: lst){
            System.out.println(str);
        }
    }
}
