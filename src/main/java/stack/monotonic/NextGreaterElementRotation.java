package stack.monotonic;

import java.util.Stack;

public class NextGreaterElementRotation {
    /**
     * Input: nums = [1,2,1]
     * Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number.
     * The second 1's next greater number needs to search circularly, which is also 2.
     */

    public int[] nextGreaterElementRotation(int[] nums){
        int[] result = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i=(nums.length*2)-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=nums[i%nums.length]){
                s.pop();
            }
            if(i<nums.length){
                result[i] = s.isEmpty() ? -1: s.peek();
            }
            s.push(nums[i%nums.length]);
        }
        return result;
    }

    public static void main(String[] args){
        new NextGreaterElementRotation().nextGreaterElementRotation(new int[]{1,2,1});
    }
}
