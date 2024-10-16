package arrays;

public class SecondHighestNumber {
    /**
     * WAP to find 2nd highest number in an array
     */

    public int find2ndHighest(int[] arr){
        int largest = Integer.MIN_VALUE,secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i]>secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args){
        System.out.println(new SecondHighestNumber().find2ndHighest(new int[] {1,9,3,7,5,6,2}));
    }
}
