package by.it.simanovich;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpediaTest {

    private static WebElement waitAndGetWebElement(WebDriver driver, By inputLocator) {
        return (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(inputLocator));
    }

    private WebDriver driver;

    @Before
    public void setupBrowser()  {
        driver = new ChromeDriver();
    }

    private static String getCurrentDate() {
        LocalDate date = LocalDate.now();
        LocalDate plusDays = date.plusDays(30);
        return plusDays.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    By searchResultLocator = By.xpath("//*[@class=\"grid-container standard-padding \"]");


    @Test
    public void taskA() throws Exception {


        driver.get("https://www.expedia.com/");

        WebElement buttonFlight = waitAndGetWebElement(driver, By.xpath("//*[@id=\"tab-flight-tab-hp\"]/span[1]")) ;
        buttonFlight.click();


        WebElement fromSearchField = waitAndGetWebElement(driver, By.xpath("//*[@id=\"flight-origin-hp-flight\"]"));
        fromSearchField.sendKeys("Minsk, Belarus (MSQ-All Airports)\n");

        WebElement toSearchField = waitAndGetWebElement(driver, By.xpath("//*[@id=\"flight-destination-hp-flight\"]"));
        toSearchField.sendKeys("Moscow, Russia (MOW-All Airports)\n");

        WebElement departingDate = waitAndGetWebElement(driver, By.xpath("//*[@id=\"flight-departing-hp-flight\"]"));
        departingDate.sendKeys(getCurrentDate());

        Thread.sleep(3000);

        departingDate.sendKeys("\n");

        Thread.sleep(5000);

        List<WebElement> elementsResult = driver.findElements(searchResultLocator);
        int size = elementsResult.size();
        assert (size>1);



    }

    @After
    public void browserQuit(){
        driver.quit();
    }

}
