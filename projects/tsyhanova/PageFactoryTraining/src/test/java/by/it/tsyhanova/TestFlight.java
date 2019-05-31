package by.it.tsyhanova;

import by.it.tsyhanova.pageObjects.LoginPage;
import by.it.tsyhanova.pageObjects.SearchResultPage;
import by.it.tsyhanova.pageObjects.StartPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFlight {
    WebDriver driver;


    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void taskB() throws Exception {
        driver.get("https://flymerlin.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // This is to Instantiate Home Page, LogIn Page and SearchResultPage class
        StartPage StartPage = PageFactory.initElements(driver, StartPage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        SearchResultPage SearchResultPage=PageFactory.initElements(driver, SearchResultPage.class);

        // Once all classes Initialised, use their Web Element Objects
        LoginPage.myAccount.click();
        Thread.sleep(1000);
        LoginPage.LogInAction("by-@tut.by","NTAcWNFw27ACLHh\n");
        System.out.println("Login is Successful");

        Thread.sleep(5000);
        StartPage.SetFlightDetailes("Минск","Москва","25.05.2019\n");
        System.out.println("Input of the Date is done.");

        Thread.sleep(5000);
        int numberOfResultOnPage=SearchResultPage.getCount();
        Assert.assertTrue(numberOfResultOnPage>1,"Search is successful!");
    }


    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }
}
