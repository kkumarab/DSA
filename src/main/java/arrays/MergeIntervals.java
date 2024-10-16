package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1,a2)-> Integer.compare(a1[0],a2[0]));
        List<int[]> result = new ArrayList<>();
        result.add(new int[] { intervals[0][0], intervals[0][0] });
        int lastIndex = 0;
        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[0];
            if(start <= result.get(lastIndex)[1]){
                if(end>result.get(lastIndex)[1]){
                    result.get(lastIndex)[1] = end;
                }
            }
            else {
                result.add(new int[]{start,end});
                lastIndex++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args){
        int[] test = {1,2};
        System.out.println(test.getClass());
        new MergeIntervals().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println("done");
    }
}
