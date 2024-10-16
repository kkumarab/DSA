package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;


public class MyTest {

    @Test(retryAnalyzer = Retry.class)
    public void failingTest(){
        System.out.println("=========FAILING TEST=========");
        Assert.assertTrue(false);
    }

    @Test()
    public void anotherFailingTest(){
        System.out.println("=========ANOTHER FAILING TEST=========");
        Assert.assertTrue(false);
    }

    @Test
    public void passTest(){
        System.out.println("=========PASSING TEST=========");
        Assert.assertTrue(true);
    }

}
