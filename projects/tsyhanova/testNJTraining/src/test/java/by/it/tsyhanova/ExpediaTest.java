package by.it.tsyhanova;

import by.it.tsyhanova.pages.ResultPage;
import by.it.tsyhanova.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExpediaTest {

    WebDriver driver;


    @BeforeMethod (groups = {"at29"})
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @Test (groups = {"at29"})
    public void taskA() throws Exception {
        driver.get("https://www.expedia.com/");

        StartPage startPage = new StartPage(driver);

        ResultPage resultPage = startPage
                .selectSearchFlightMode()
                .selectOneWay()
                .setOrigin("Minsk, Belarus (MSQ-All Airports)")
                .setDestination("Moscow, Russia (MOW-All Airports)")
                .setDepartingDate("05/26/2019")
                .getSearch();

        int resultSearchCount = resultPage.getResultSearchCount();
        Assert.assertTrue(resultSearchCount > 1);
    }

    @AfterMethod (groups = {"at29"})
    public void tearDownBrowser() {
        driver.quit();
    }
}
