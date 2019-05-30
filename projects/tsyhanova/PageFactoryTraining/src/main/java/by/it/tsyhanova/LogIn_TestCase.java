package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogIn_TestCase {
    private static WebDriver driver = null;

    public static void main(String[] args) {

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch the Website
        driver.get("https://belavia.by/");

        // Find the element that's ID attribute is 'account'(My Account)

        driver.findElement(By.id("select-member")).click();

        // Find the element that's ID attribute is 'log' (Username)
        // Enter Username on the element found by above desc.
        driver.findElement(By.id("MemberId")).sendKeys("10012179365");

        // Find the element that's ID attribute is 'pwd' (Password)
        // Enter Password on the element found by the above desc.
        driver.findElement(By.id("Password")).sendKeys("L2R1J6\n");

        // Print a Log In message to the screen
        System.out.println(" Login Successfully.");

        // Close the driver
        driver.quit();

    }
}
