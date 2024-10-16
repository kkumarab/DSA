package arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    /**
     * Given an integer array nums, return an array answer such that
     * answer[i] is equal to the product of all the elements of nums except nums[i].
     * Input: nums = [1,2,3,4]
     * Output: [24,12,8,6]
     */


    public int[] productExceptSelf(int[] nums){
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];
        Arrays.fill(leftProducts,1);
        Arrays.fill(rightProducts,1);
        int [] result = new int[nums.length];
        for(int i=1;i<nums.length;i++){
            leftProducts[i] = leftProducts[i-1] * nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightProducts[i] = rightProducts[i+1] * nums[i+1];
        }
        for(int i=0;i<leftProducts.length;i++){
            result[i] = leftProducts[i] * rightProducts[i];
        }
        return result;
    }

    public static void main(String[] args){
        new ProductExceptSelf().productExceptSelf(new int[]{5,2,3,4});
    }
}
