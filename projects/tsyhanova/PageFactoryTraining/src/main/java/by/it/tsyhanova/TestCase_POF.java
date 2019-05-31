package by.it.tsyhanova;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestCase_POF {
    private static WebDriver driver;

    @FindBy(how = How.ID, using = "select-member")
    @CacheLookup
    private static WebElement myAccount;

    @FindBy(how = How.ID, using = "MemberId")
    @CacheLookup
    private static WebElement userName;

    @FindBy(how = How.ID, using = "Password")
    @CacheLookup
    private static WebElement myPassword;

    public static void main(String[] args) throws InterruptedException{

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://belavia.by/");
        PageFactory.initElements(driver, TestCase_POF.class);

        myAccount.click();
        userName.sendKeys("10012179365");
        myPassword.sendKeys("L2R1J6\n");

        System.out.println(" Login Successfully.");

        driver.quit();

    }
}
