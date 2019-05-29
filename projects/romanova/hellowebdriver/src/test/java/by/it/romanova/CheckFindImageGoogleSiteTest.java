package by.it.romanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Test(groups = {"at24"})
public class CheckFindImageGoogleSiteTest {

    private static final String
            INPUT_LOCATOR = "//input[@class=\"gLFyf gsfi\"]",
            IMAGES_LOCATOR = "//*[@class=\"q qs\"][1]",
            IMAGE_LOCATOR = "//*[@class=\"rg_bx rg_di rg_el ivg-i\"][@data-ri=0]",
            SITE_BUTTON_LOCATOR = "//a[@class=\"irc_vpl i3599 irc_lth\"][@tabindex=0]",
            SEARCH_IMAGES_BUTTON = "//*[@class=\"S3Wjs\"]",
            SEARCH_IMAGES_TABLE = "//*[@id=\"qbug\"]/table",
            SITE_HEADER = "/html/body/div[1]/div/header";

    private WebDriver driver;

    private static WebElement waitAndGetElement(WebDriver driver, By query) {
        return (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(query));
    }

   @BeforeMethod
    public void setUpBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(groups = {"at24"})
    public void taskA(){
        driver.get("https://www.google.com/");

        WebElement google_input = waitAndGetElement(driver, By.xpath(INPUT_LOCATOR));
        google_input.sendKeys("seleniumhq\n");

        WebElement image_tab = waitAndGetElement(driver, By.xpath(IMAGES_LOCATOR));
        image_tab.click();

        WebElement image = waitAndGetElement(driver,By.xpath(IMAGE_LOCATOR));
        image.click();

        WebElement page_button = waitAndGetElement(driver,By.xpath(SITE_BUTTON_LOCATOR));
        page_button.click();

        List a = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(a.get(1).toString());

        String site = driver.getCurrentUrl();
        Assert.assertEquals(site,"https://www.seleniumhq.org/");

    }

    @Test(groups = {"at24"})
    public void taskB() throws InterruptedException {
        driver.get("https://www.google.com/");

        WebElement google_input = waitAndGetElement(driver, By.xpath(INPUT_LOCATOR));
        google_input.sendKeys("seleniumhq\n");

        WebElement image_tab = waitAndGetElement(driver, By.xpath(IMAGES_LOCATOR));
        image_tab.click();

        WebElement image = waitAndGetElement(driver,By.xpath(IMAGE_LOCATOR));
        image.click();

        WebElement page_button = waitAndGetElement(driver,By.xpath(SITE_BUTTON_LOCATOR));
        page_button.click();
        Thread.sleep(2000);

        List a = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(a.get(1).toString());
        String title = driver.getTitle();

        Assert.assertEquals("Selenium - Web Browser Automation", title);
        driver.switchTo().window(a.get(0).toString());
        Thread.sleep(2000);

        WebElement search_image = waitAndGetElement(driver, By.xpath(SEARCH_IMAGES_BUTTON));
        search_image.click();
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement found_image = waitAndGetElement(driver,By.xpath(IMAGE_LOCATOR));
        WebElement field = waitAndGetElement(driver,By.xpath(SEARCH_IMAGES_TABLE));
        builder.dragAndDrop(found_image,field).build().perform();

        Thread.sleep(4000);
        waitAndGetElement(driver,By.xpath("//*[@id=\"resultStats\"]"));

        List<WebElement> sites = new ArrayList<>(driver.findElements(By.xpath("//h3")));
        sites.get(0).click();

        String site = driver.getCurrentUrl();
        Assert.assertEquals(site,"https://www.seleniumhq.org/selenium-ide/");
    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }
}
