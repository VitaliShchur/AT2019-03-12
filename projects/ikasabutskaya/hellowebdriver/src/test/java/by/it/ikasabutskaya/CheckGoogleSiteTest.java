package by.it.ikasabutskaya;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckGoogleSiteTest {

    @Test

    public void userTryFindRasrasrasInGoogle() throws Exception {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.google.com");
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("ras ras ras\n");
            waitAndGetWebElement(driver, By.xpath("//span[@class=\"csb ch\"]"));

        }
        finally {
            driver.quit();

        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));

        return driver.findElement(queryLocator);
    }
}
