package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private static final int maxTry = 2;
    private int count =0;

    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            System.out.println("========INSIDE RETRY========");
            if(count<maxTry){
                count++;
                return true;
            }
        }
        return false;
    }
}
