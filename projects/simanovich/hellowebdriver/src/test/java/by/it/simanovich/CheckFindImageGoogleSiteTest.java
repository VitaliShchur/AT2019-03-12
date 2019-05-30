package by.it.simanovich;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;

public class CheckFindImageGoogleSiteTest {

    private WebDriver driver;

    private static WebElement waitAndGetWebElement(WebDriver driver, By inputLocator) {
        return (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(inputLocator));
    }


    @Before
    public void setupDriver() {
       driver =  new ChromeDriver();
       driver.manage().window().maximize();
    }


    @Test
    public void taskA () throws Exception{
        driver.get("https://www.google.com");
        By byQueryInput = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
        queryInput.sendKeys("seleniumhq\n");
        By byImagelocator = By.xpath("//*[@id=\"hdtb-msb-vis\"]/div[2]/a");
        WebElement imageClick = waitAndGetWebElement(driver, byImagelocator);
        imageClick.click();
        By byFirstImage = By.xpath("//*[@id=\"i48MSmX01sE18M:\"]");
        WebElement firstImage = waitAndGetWebElement(driver,byFirstImage);
        firstImage.click();
        By byLinkFromImage = By.xpath("//*[@id=\"irc_cc\"]/div[2]/div[3]/div[1]/div/div[1]/span/a");
        WebElement linkFromImage = waitAndGetWebElement(driver, byLinkFromImage);
        linkFromImage.click();
        Thread.sleep(5000);

        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        String newTab = handlesList.get(handlesList.size() - 1);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(3333);


        driver.switchTo().window(newTab);

        String url = driver.getCurrentUrl();
        assertTrue("not complete find", url.startsWith("https://www.seleniumhq.org"));


        Assert.assertEquals("1", "1");
    }

    @Test
    public void taskB() throws Exception {

        driver.get("https://www.google.com");

        By byQueryInput = By.xpath("//input[@name='q']");
        WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
        queryInput.sendKeys("seleniumhq\n");

        By byLinkImagesSearch = By.xpath("//a[@class='q qs'][contains(@href,'tbm=isch')]");
        WebElement linkImagesSearch = waitAndGetWebElement(driver, byLinkImagesSearch);
        linkImagesSearch.click();

        By byLinkResultFirstImage = By.xpath("//img[@class='rg_ic rg_i'][@data-atf=1]");
        WebElement linkResultFirstImage = waitAndGetWebElement(driver, byLinkResultFirstImage);


        Actions actions = new Actions(driver);
        WebElement photoButton = waitAndGetWebElement(driver, By.xpath("//span[@class='S3Wjs']"));
        photoButton.click();;
        actions.pause(Duration.ofMillis(555)).perform();

        WebElement target = waitAndGetWebElement(driver, By.xpath("//div[@id='qbp']"));
        target.click();;

        WebElement from = waitAndGetWebElement(driver, By.xpath("//*[@id='i48MSmX01sE18M:']"));

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

    @After
    public void theDownBrowser () {
        driver.quit();
    }
}
