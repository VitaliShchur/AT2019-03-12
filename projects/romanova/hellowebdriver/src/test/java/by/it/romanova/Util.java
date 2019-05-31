package by.it.romanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Util {

    protected WebDriver driver;

    protected Util(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> waitForElements(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementAndClick(By locator) {
        waitForElement(5000, locator).click();
    }

    protected void waitForElementAndClick(long timeout, By locator) {
        waitForElement(timeout, locator).click();
    }

    protected void waitForElementAndSendKeys(By locator, String text) {
        WebElement element = waitForElement(5000, locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected int getAmountOfElements(By locator)
    {
        List elements = waitForElements(10000, locator);
        return elements.size();
    }

    protected void assertSeveralElements(By locator)
    {
        int amount_of_elements = getAmountOfElements(locator);
        Assert.assertTrue(amount_of_elements>=1);
    }
}
