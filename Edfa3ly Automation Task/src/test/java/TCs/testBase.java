package TCs;

import Utilities.Helper;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import Base.PageBase;

public class testBase {
 @AfterSuite
 public void f() {
  PageBase.quit();
  }
    //take screenshot when test case failed and add it in the Screenshots folder
    @AfterMethod
    public void screenShotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed");
            System.out.println("Taking Screenshot....");
            Helper.captureScreenShot(PageBase.driver, result.getName());
        }
    }

}
