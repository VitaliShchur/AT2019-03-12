package by.it.tsyhanova;

import by.it.tsyhanova.pageObjects.LoginPage;
import by.it.tsyhanova.pageObjects.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestCaseBelavia {

    static WebDriver driver;




    public static void main(String[] args) throws InterruptedException{

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://flymerlin.by/");

        // This is to Instantiate Home Page and LogIn Page class
        StartPage StartPage = PageFactory.initElements(driver, StartPage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        // Once both classes Initialised, use their Web Element Objects

        LoginPage.myAccount.click();
        Thread.sleep(1000);
        LoginPage.userName.sendKeys("by-@tut.by");
        LoginPage.myPassword.sendKeys("NTAcWNFw27ACLHh\n");
        System.out.println("Login Successfully.");

        Thread.sleep(5000);
        StartPage.onWay.click();
        StartPage.originPlace.clear();
        StartPage.originPlace.sendKeys("Минск");
        StartPage.destinationPlace.sendKeys("Москва");
        StartPage.destinationAirport.click();
        StartPage.departureDate.clear();
        StartPage.departureDate.sendKeys("25.05.2019\n");
        StartPage.buttonClick.click();
        System.out.println("Search is done.");

        /*Thread.sleep(10000);
        System.out.println(SearchResultPage.allSearchResultElements.size());*/

        driver.quit();
    }


}
