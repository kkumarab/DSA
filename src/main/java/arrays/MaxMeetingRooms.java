package arrays;

// Java implementation of the above approach

import java.util.*;

class MaxMeetingRooms {

    static int minHalls(int[][] intervals) {
            int n = intervals.length;
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            Arrays.sort(start);
            Arrays.sort(end);
            int i = 1, j = 0, curr = 1;
            int answer = 1;
            while (i < start.length && j < end.length) {

                if (start[i] < end[j]) {
                    curr++;
                    i++;
                } else {
                    curr--;
                    j++;
                }
                answer = Integer.max(answer, curr);
            }
            return answer;
        }

    // Driver Code
    public static void main(String[] args) {
        int[][] intervals = { { 1, 18 }, { 18, 23 }, { 15, 29 }, {4, 15}, {2, 11}, {5, 13} };
        System.out.println(minHalls(intervals));
    }
}

