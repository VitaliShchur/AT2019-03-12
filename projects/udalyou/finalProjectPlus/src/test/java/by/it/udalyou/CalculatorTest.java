package by.it.udalyou;

import by.it.udalyou.Tools.Util;
import by.it.udalyou.pages.ResultPage;
import by.it.udalyou.pages.StartPage;
import by.it.udalyou.server.WebCalculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalculatorTest {

    WebDriver driver;
    WebCalculator webcalc;


  //  @BeforeSuite

  //  public void setUpCalculator() {
   //     webcalc = new WebCalculator();
   // }
    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }
    @Test
    public void taskB() throws Exception {

    //    WebCalculator webcalc = new WebCalculator();
        Util.shortWait(driver);
        driver.get("/http://localhost:8090/");
        Util.shortWait(driver);
        CalcPage calcPage = new CalcPage(driver);

            CalcPage resultCalk =calcPage.
               selectFildExpression("2+5-6/3").
               enter().
               getResult();
        System.out.println(resultCalk);
       Assert.assertEquals(resultCalk, 5.00000000);


    }
    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

}
