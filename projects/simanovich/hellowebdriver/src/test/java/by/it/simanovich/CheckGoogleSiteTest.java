package by.it.simanovich;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckGoogleSiteTest {

    @Test
    public void userTryFindHelloInGoogle () throws Exception{
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://google.com");
            By inputLocator = By.xpath("//input[@class = 'gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, inputLocator);
            queryInput.sendKeys("привет\n");
            waitAndGetWebElement(driver, By.xpath("//span[@class=\"csb ch\"]"));
        }

        finally {
            driver.quit();
        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By inputLocator) {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(inputLocator));
        return driver.findElement(inputLocator);
    }

}
