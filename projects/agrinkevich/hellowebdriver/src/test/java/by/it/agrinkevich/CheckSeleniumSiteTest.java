package by.it.agrinkevich;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckSeleniumSiteTest {

    @Test(groups = {"at23"})
    public void userCheckDependencyContainsText() throws Exception {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com");
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("seleniumhq\n");
            waitAndGetWebElement(driver, By.xpath("//h3[@class='LC20lb']")).click();
            waitAndGetWebElement(driver, By.cssSelector("#menu_download > a")).click();
            waitAndGetWebElement(driver, By.xpath("//*[@id=\"nav\"]/li/ul/li[3]/a")).click();
            queryLocator = By.xpath("//*[@id=\"mainContent\"]/pre[1]");
            queryInput = waitAndGetWebElement(driver, queryLocator);

            Assert.assertTrue(queryInput.getText().contains("<artifactId>selenium-java</artifactId>"));

            String dependencyText = queryInput.getText();
            Pattern pattern = Pattern.compile("<version>(.+?)</version>");
            Matcher matcher = pattern.matcher(dependencyText);
            matcher.find();
            System.out.println("Version for selenium-java: " + matcher.group(1));
        } finally {
            driver.quit();
        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }

}
