package by.it.agrinkevich;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckGoogleSiteTest {

    @Test(groups = {"at23"})
    public void userTryFindHelloInGoogle() throws Exception {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Assert.assertTrue(driver.getTitle().contains("Google"));
        } finally {
            driver.quit();
        }
    }
}
