package by.it.vshchur;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckGoogleSiteTest {
    @Test
    public void userTryToFindHelloGoogle() throws Exception {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com");
            By queryLocator = By.xpath("//html/head[@title='Google']");
            Assert.assertTrue(driver.getTitle().contains("Google"));
//            queryInput.sendKeys("Привет!\n");
//            waitAndGetWebElement(driver, By.xpath("//span[@class='csb ch']"));
        } finally {
            driver.quit();
        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }
}
