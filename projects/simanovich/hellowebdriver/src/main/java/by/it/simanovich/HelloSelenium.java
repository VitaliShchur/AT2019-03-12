package by.it.simanovich;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        By inputLocator = By.xpath("//input[@class = 'gLFyf gsfi']");
        WebElement queryInput = waitAndGetWebElement(driver, inputLocator);
        queryInput.sendKeys("привет\n");
        waitAndGetWebElement(driver, By.xpath("//span[@class=\"csb ch\"]"));
        driver.quit();
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By inputLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(inputLocator));
        return driver.findElement(inputLocator);
    }
}
