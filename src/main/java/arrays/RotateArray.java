package arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class RotateArray {

    /**
     *Rotate an array {1,2,3,4,5} by given count say 2, result in {4,5,1,2,3}
     *
     */

    public void rotateArray(int[] arr, int count){
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=arr.length-1;i>=0;i--){
            q.add(arr[i]);
        }
        int rotationIte=1;
        while(rotationIte<=count){
            int top = q.poll();
            q.add(top);
            rotationIte++;
        }
        System.out.println("done");
        //for(int i=q.size()-1;i>=0;i++)
    }

    public static void main(String[] args){
        new RotateArray().rotateArray(new int[]{1,2,3,4,5},2);
    }
}
