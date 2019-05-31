package by.it.tsyhanova;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class CheckFindImageGoogleSiteTest {

    private WebDriver driver;

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
    }

    @BeforeMethod (groups = {"at28"})
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (groups = {"at28"})
    public void taskA() throws Exception {
        driver.get("https://www.google.com");
        // Engish page
        // driver.get("https://www.google.com/webhp?hl=en");
        By byQueryInput = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
        queryInput.sendKeys("seleniumhq\n");

        By byLinkImagesSearch = By.xpath("//a[@class='q qs'][contains(@href,'tbm=isch')]");
        WebElement linkImagesSearch = waitAndGetWebElement(driver, byLinkImagesSearch);
        linkImagesSearch.click();

        By byLinkResultFirstImage = By.xpath("//*[@class='rg_bx rg_di rg_el ivg-i'][@data-ri='0']");
        WebElement linkResultFirstImage = waitAndGetWebElement(driver, byLinkResultFirstImage);
        linkResultFirstImage.click();

        By byLinkResultSite = By.xpath("//a[@class='irc_vpl i3599 irc_lth'][@tabindex=0]");
        WebElement linkResultSite = waitAndGetWebElement(driver, byLinkResultSite);

        //wait rendering (но лучше проверить это явно)
        Thread.sleep(333);
        linkResultSite.click();

        //open a new tab and check url at the last tab
        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        String newTab = handlesList.get(handlesList.size() - 1);

        // switch to new tab
        driver.switchTo().window(newTab);

        String url = driver.getCurrentUrl();
        assertTrue("not complete find", url.startsWith("https://www.seleniumhq.org"));
    }

    @Test (groups = {"at28"})
    public void taskB() throws Exception {

        driver.get("https://www.google.com");
        // Engish page
        // driver.get("https://www.google.com/webhp?hl=en");
        By byQueryInput = By.xpath("//input[@name='q']");
        WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
        queryInput.sendKeys("seleniumhq\n");

        By byLinkImagesSearch = By.xpath("//a[@class='q qs'][contains(@href,'tbm=isch')]");
        WebElement linkImagesSearch = waitAndGetWebElement(driver, byLinkImagesSearch);
        linkImagesSearch.click();

        By byLinkResultFirstImage = By.xpath("//img[@class='rg_ic rg_i'][@data-atf=1]");
        WebElement linkResultFirstImage = waitAndGetWebElement(driver, byLinkResultFirstImage);
        //linkResultFirstImage.click();

        Actions actions = new Actions(driver);
        WebElement photoButton = waitAndGetWebElement(driver, By.xpath("//span[@class='S3Wjs']"));
        photoButton.click();;
        actions.pause(Duration.ofMillis(555)).perform();

        WebElement target = waitAndGetWebElement(driver, By.xpath("//div[@id='qbp']"));
        target.click();

        WebElement from = waitAndGetWebElement(driver, By.xpath("//*[@id='i48MSmX01sE18M:']"));
        //from.click();

        actions
                .clickAndHold(from)
                .release(target)
                .build()
                .perform();


        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("alert('Focus window');");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }

    @AfterMethod (groups = {"at28"})
    public void tearDownBrowser() {
        driver.quit();
    }


}
