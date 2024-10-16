package arrays;

import java.util.Arrays;

public class MeetingsOverlap {
    /**
     * Given an array arr[][] such that arr[i][0] is the starting time of ith meeting and arr[i][1] is the ending time of ith meeting,
     * the task is to check if it is possible for a person to attend all the meetings
     * such that he can attend only one meeting at a particular time.
     *
     * Input: arr[][] = {{1, 4}, {10, 15}, {7, 10}}
     * Output: true
     * Explanation: Since all the meetings are held at different times, it is possible to attend all the meetings.
     *
     * Input: arr[][] = {{2, 4}, {9, 12}, {6, 10}}
     * Output: false
     */

    public boolean meetingsOverlap(int[][] meetings){
        //Arrays.sort(meetings,(m1, m2) -> Integer.compare(m1[0],m2[0]));
        Arrays.sort(meetings,(m1,m2) -> Integer.valueOf(m1[0]).compareTo(Integer.valueOf(m2[0])));
        for(int i=0;i<meetings.length-1;i++){
            if(meetings[i][1] > meetings[i+1][0])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        boolean result = new MeetingsOverlap().meetingsOverlap(new int[][]{{2, 4}, {9, 12}, {6, 10}});
        System.out.println(result);
    }
}
