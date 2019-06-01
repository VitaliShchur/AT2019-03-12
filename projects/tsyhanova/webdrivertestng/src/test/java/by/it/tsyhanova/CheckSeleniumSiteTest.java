package by.it.tsyhanova;

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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Test(groups = {"at23"})
public class CheckSeleniumSiteTest {
    private static final String
            INPUT_LOCATOR = "//input[@class=\"gLFyf gsfi\"]",
            MAVEN_INFO = "//*[@id=\"nav\"]//a[@href=\"/download/maven.html\"]",
            DEPENDENCY_BLOCK = "//*[@id=\"mainContent\"]/pre[1]";

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


    @Test(groups = {"at23"})
    public void task() {
        driver.get("https://www.google.com/");

        WebElement google_input = waitAndGetElement(driver, By.xpath(INPUT_LOCATOR));
        google_input.sendKeys("seleniumhq\n");

        By resultheader = By.xpath("//*[@id=\"hdtbSum\"]");
        waitAndGetElement(driver, resultheader);

        List<WebElement> sites = new ArrayList<>(driver.findElements(By.xpath("//h3")));
        sites.get(0).click();

        By downloads = By.id("menu_download");
        waitAndGetElement(driver,downloads).click();
        waitAndGetElement(driver,By.xpath(MAVEN_INFO)).click();
        String dependency = waitAndGetElement(driver,By.xpath(DEPENDENCY_BLOCK)).getText();
        Assert.assertTrue(dependency.contains("<artifactId>selenium-java</artifactId>"));
        Pattern pattern = Pattern.compile("(?!<version>)([0-9].?)+");
        Matcher matcher = pattern.matcher(dependency);
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }

    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }
}
