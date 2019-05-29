package by.it.romanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelloSelenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        By input = By.xpath("//input[@class=\"gLFyf gsfi\"]");
        WebElement element = waitAndGetElement(driver,input);
        element.sendKeys("eee\n");

        By resultheader = By.xpath("//*[@id=\"hdtbSum\"]");
        waitAndGetElement(driver, resultheader);
        driver.quit();
    }

    private static WebElement waitAndGetElement(WebDriver driver, By query) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(query));
        return driver.findElement(query);
    }
}
