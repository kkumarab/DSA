package arrays;

import java.util.HashMap;

public class MaxTime {
    static String largestTimeFromDigits(int[] A) {
        HashMap<Integer, Integer> mp1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mp2 = new HashMap<Integer, Integer>();
        for (int x : A) {
            if (mp1.containsKey(x)) mp1.put(x, mp1.get(x) + 1);
            else mp1.put(x, 1);
        }
        mp2 = (HashMap<Integer, Integer>) mp1.clone();

// Maximum possible time
        int hr = 23, m = 59, s = 59;

// Iterate to minimum
// possible time
        while (hr >= 0) {
            int h0 = hr / 10, h1 = hr % 10;
            int m0 = m / 10, m1 = m % 10;
            int s0 = s / 10, s1 = s % 10;
            int p = 0;
            int[] arr = {h0, h1, m0, m1, s0, s1};

            // Conditions to reduce the
            // the time iteratively
            for (int it : arr) {
                if (mp1.containsKey(it) && mp1.get(it) > 0) {
                    mp1.put(it, mp1.get(it) - 1);
                } else {
                    p = 1;
                }
            }

            // If all required digits
            // are present in the Map
            if (p == 0) {
                String st = "";
                st = String.valueOf(h0) + String.valueOf(h1);
                st += ':' + String.valueOf(m0) + String.valueOf(m1);
                st += ':' + String.valueOf(s0) + String.valueOf(s1);
                return st;
            }

            // Retrieve Original Count
            mp1 = (HashMap<Integer, Integer>) mp2.clone();

            // If seconds is reduced to 0
            if (s == 0) {
                s = 59;
                m--;
            }

            // If minutes is reduced to 0
            else if (m < 0) {
                m = 59;
                hr--;
            }
            if (s > 0) {
                s--;
            }
        }
        return "-1";
    }

    // Driver Code
    public static void main(String[] args) {
        int[] v = {0, 2, 1, 9, 3, 2};
        System.out.print(largestTimeFromDigits(v));
    }
}
