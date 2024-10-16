package pointers;

public class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it can trap after raining.
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
     * In this case, 6 units of rain water (blue section) are being trapped.
     *
     */


    public int getRainWater(int[] arr){
        int[] leftAr = new int[arr.length];
        int[] rightAr = new int[arr.length];
        leftAr[0] = arr[0];
        rightAr[arr.length-1] = arr[arr.length-1];
        for(int i=1,j=arr.length-2;i<arr.length && j>=0;i++,j--){
            leftAr[i] = Math.max(leftAr[i-1],arr[i]);
            rightAr[j] = Math.max(rightAr[j+1],arr[j]);
        }
        int result =0;
        for(int i=0;i<leftAr.length;i++){
            result+= (Math.min(leftAr[i],rightAr[i])-arr[i]);
        }
        return result;
    }
}
