package by.it.medvedeva;

import by.it.medvedeva.pages.ResultPage;
import by.it.medvedeva.pages.StartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ExpediaTest{
    WebDriver driver;



    @BeforeMethod
    public void setUpBrowser(){

        driver = new ChromeDriver();
    }
    @Test
    public void taskA () throws Exception{

        driver.get("https://www.expedia.com");
        StartPage startPage = new StartPage(driver);
        ResultPage resultPage = startPage
                .selectSearchFlightMode()
                .selectOneWay()
                .setOrigin("Minsk, Belarus (MSQ-All Airports)")
                .setDestination("Moscow, Russia (MOW-All Airports)")
                .setDepartingDate("06/28/2019")
                .getSearch();

        int resultSearchCount = resultPage.getResultSearchCount();
        Assert.assertTrue(resultSearchCount > 1);



       // WebElement buttonFlight = driver.findElement(By.id("tab-flight-tab-hp"));
       // buttonFlight.click();

      //  WebElement oneWayButton = driver.findElement(By.id("flight-type-one-way-label-hp-flight"));
      //  oneWayButton.click();

       // WebElement inputOrigin = driver.findElement(By.id("flight-origin-hp-flight"));
       // inputOrigin.sendKeys("Minsk, Belarus (MSQ-All Airports\n");

      //  WebElement inputDestination = driver.findElement(By.id("flight-destination-hp-flight"));
       // inputDestination.sendKeys("Moscow, Russia (MOW-All Airports\n");

       // WebElement inputDepartingDate = driver.findElement(By.id("flight-departing-hp-flight"));
       // inputDepartingDate.sendKeys("06/20/2019\n");

        //WebElement searchButton = driver.findElement(By.id(""));
        /// some oper
        Thread.sleep(5000);

        List <WebElement> resultsPrice = driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
        Assert.assertTrue(resultsPrice.size()>1);




    }

@AfterMethod
    public void tearDownBrowser(){

        driver.quit();
}

}