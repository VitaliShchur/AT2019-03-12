package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"at23"})
public class GoogleSiteTest {

    private WebDriver driver;

    @BeforeMethod
    public void driverInit(){
        driver = new ChromeDriver();
    }

    @Test(groups = {"at23"})
    public void findAnyResultByRequest(){
        driver.get("https://www.google.com");
        By input = By.xpath("//input[@class=\"gLFyf gsfi\"]");
        WebElement element = waitAndGetElement(driver,input);
        element.sendKeys("eee\n");

        By result = By.xpath("//*[@alt=\"Google\"]");
        waitAndGetElement(driver, result);
    }

    private static WebElement waitAndGetElement(WebDriver driver, By query) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(query));
        return driver.findElement(query);
    }

    @AfterMethod
    public void driverQuit(){
        driver.quit();
    }


}
