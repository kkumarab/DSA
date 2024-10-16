package stack.monotonic;

import java.util.Stack;

public class NextGreaterElement {

    /**
     * Given an array, print the Next Greater Element (NGE) for every element.
     * Input: arr[] = [ 4 , 5 , 2 , 25 ]
     * Output:  [5,25,25,-1]
     *
     */

    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> s = new Stack<Integer>();
        int[] result = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
           while(!s.isEmpty() && s.peek()<=nums[i]){
               s.pop();
           }
           result[i] = s.isEmpty() ? -1 : s.peek();
           s.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args){
        new NextGreaterElement().nextGreaterElement(new int[]{1,2,4,6,3,7});
    }
}
