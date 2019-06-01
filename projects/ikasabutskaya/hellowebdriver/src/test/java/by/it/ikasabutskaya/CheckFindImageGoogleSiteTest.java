package by.it.ikasabutskaya;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class CheckFindImageGoogleSiteTest {

    private WebDriver driver;

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        return (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
    }

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver();
        //		driver.manage().window().maximize(); //doesn't work WebDriverException: unknown error: failed to change window state to maximized, current state is normal
    }

    @Test
    public void taskA() throws Exception {
        driver.get("https://google.com");
        By bySearchInputField = By.cssSelector("input.gLFyf.gsfi");
        WebElement searchInputField = waitAndGetWebElement(driver, bySearchInputField);
        searchInputField.sendKeys("seleniumhq\n");
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("td.cur"))); // wait for footer with "Google"

        By byimagesLink = By.cssSelector("div#hdtb-msb-vis  a.q.qs[href*='isch']");
        WebElement imagesLink = waitAndGetWebElement(driver, byimagesLink);
        imagesLink.click();
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.S3Wjs"))); // wait for photo camera image

        By byFirstImageLink = By.xpath("//*[@class='rg_bx rg_di rg_el ivg-i'][@data-ri='0']");
        WebElement firstImageLink = waitAndGetWebElement(driver, byFirstImageLink);
        firstImageLink.click();

        By byVisitLink = By.xpath("//a[@class='irc_vpl i3599 irc_lth'][@tabindex=0]");
        WebElement visitLink = waitAndGetWebElement(driver, byVisitLink);
        visitLink.click();  // page is opened in a separate browser tab

        Set<String> handles = driver.getWindowHandles();
        ArrayList<String> handlsList = new ArrayList<>(handles);
        String newTab = handlsList.get(handlsList.size() - 1);
        driver.switchTo().window(newTab);
        (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.urlToBe("https://www.seleniumhq.org/"));
        String tabUrl = driver.getCurrentUrl();
        Assert.assertTrue("", tabUrl.startsWith("https://www.seleniumhq.org/"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
