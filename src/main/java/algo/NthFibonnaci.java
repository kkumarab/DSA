package algo;

public class NthFibonnaci {
    /**
     * WAP to find nth Fibonnaci number
     */

    static Integer [] memo;
    public int getFibbonaciNumer(int n){
        if (n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;

        return getFibbonaciNumer(n - 1) + getFibbonaciNumer(n - 2);
    }



    public static void main(String[] args){
        NthFibonnaci obj = new NthFibonnaci();
        int n=9;
        memo = new Integer[n];
        System.out.println("Fibonnaci number 4->" + obj.getFibbonaciNumer(n));
    }
}
