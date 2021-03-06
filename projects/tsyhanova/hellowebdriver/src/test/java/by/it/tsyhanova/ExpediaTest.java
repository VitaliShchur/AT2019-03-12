package by.it.tsyhanova;

import by.it.tsyhanova.pages.ResultPage;
import by.it.tsyhanova.pages.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpediaTest {

    WebDriver driver;


    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }

    @Test
    public void taskA() throws Exception {
        driver.get("https://www.expedia.com/");

        StartPage startPage = new StartPage(driver);

        ResultPage resultPage = startPage
                .selectSearchFlightMode()
                .selectOneWay()
                .setOrigin("Minsk, Belarus (MSQ-All Airports)")
                .setDestination("Moscow, Russia (MOW-All Airports)")
                .setDepartingDate("05/30/2019")
                .getSearch();

        int resultSearchCount = resultPage.getResultSearchCount();
        Assert.assertTrue(resultSearchCount > 1);
    }
    /*@Test
    public void taskB(){
        driver.get("https://www.expedia.com/");


    }*/

    @After
    public void tearDownBrowser() {
        driver.quit();
    }
}
