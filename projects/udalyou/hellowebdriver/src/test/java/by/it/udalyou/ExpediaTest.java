package by.it.udalyou;
import org.openqa.selenium.By;
import by.it.udalyou.pages.ResultPage;
import by.it.udalyou.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ExpediaTest {


    WebDriver driver;


    @BeforeMethod
    public void setUpBrowser() {
        driver = new ChromeDriver();
    }
///*[@id="tab-flight-tab-hp"]

    @Test
    public void taskA() throws Exception {
        driver.get("https://www.expedia.com/");

        StartPage startPage = new StartPage(driver);

        ResultPage resultPage = startPage
                .selectSearchFlightMode()
                .selectOneWay()
                .setOrigin("Minsk, Belarus (MSQ-All Airports)")
                .setDestination("Moscow, Russia (MOW-All Airports)")
                .setDepartingDate("06/22/2019")
                .getSearch();

        int resultSearchCount = resultPage.getResultSearchCount();
        Assert.assertTrue(resultSearchCount > 1);

        //  StartPage startPage=new StartPage(driver);
        //startPage.
/*
   WebElement buttonFlight=driver.findElement(By.id("tab-flight-tab-hp"));
        Thread.sleep(100);
        buttonFlight.click();
        WebElement buttonOneWay=driver.findElement(By.id("flight-type-one-way-label-hp-flight"));
        Thread.sleep(100);
        buttonOneWay.click();

   WebElement inputOrigin=driver.findElement(By.id("flight-origin-hp-flight"));
        Thread.sleep(100);
      inputOrigin.sendKeys("Minsk, Belarus (MSQ-Minsk Intl.)");
        Thread.sleep(100);

        WebElement inputDestination=driver.findElement(By.id("flight-destination-hp-flight"));
        Thread.sleep(100);
        inputDestination.sendKeys("Moscow, Russia (MOW-All Airports)");
        Thread.sleep(100);

        WebElement dataDeparting=driver.findElement(By.id("flight-departing-single-hp-flight"));
        Thread.sleep(100);
        dataDeparting.sendKeys("06/20/2019");
        Thread.sleep(500);
        ((WebElement) dataDeparting).sendKeys("\n");
        Thread.sleep(500);
      //  dataDeparting.click();
   /*     WebElement countFliyinTo=driver.findElement(By.id("traveler-selector-hp-flight"));


        WebElement cntFliyin=driver.findElement(
                By.id("//*[@id=\"traveler-selector-hp-flight\"]/div/ul/li/div/div/div/div[1]/div[1]/label/span"));
        Thread.sleep(500);
        cntFliyin.click();

        WebElement countFliyin=driver.findElement(
                By.id("gcw-flights-form-hp-flight"));

        countFliyin.click();
        Thread.sleep(100);
        //gcw-flights-form-hp-flight

   Thread.sleep(5000);
        WebElement priseFliyin=driver.findElement(By.id("flight-destination-hp-flight"));
        Thread.sleep(500);

        List<WebElement> resultPrice=driver.findElements(By.xpath("//*[@data-test-id='listing-price-dollars']"));
       Assert.assertTrue(resultPrice.size()>1);
    }
*/
    }
     @AfterMethod
        public void tearDownBrowser() {
            driver.quit();
        }
    }
