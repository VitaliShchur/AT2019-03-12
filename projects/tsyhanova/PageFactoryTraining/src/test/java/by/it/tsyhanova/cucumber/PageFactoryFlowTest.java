package by.it.tsyhanova.cucumber;

import by.it.tsyhanova.pageObjects.LoginPage;
import by.it.tsyhanova.pageObjects.SearchResultPage;
import by.it.tsyhanova.pageObjects.StartPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

@Test
public class PageFactoryFlowTest {

    private WebDriver driver;
    StartPage startPage;
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    SearchResultPage searchResultPage;
    private int countTickets;

    @Before
    public void InitTest(){
        driver = new ChromeDriver();

    }


    @Given("^Home Page aviacompany is Loaded$")
    public void homePageAviacompanyIsLoaded() throws Throwable {
        //определяем стартовую страницу
        driver.get("https://flymerlin.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //передаем драйвер в стартовую страницу
        loginPage=new LoginPage(driver);
        //ожидание
        Assert.assertTrue(loginPage!=null);
    }

    @When("^User Click Sign In$")
    public void userClickSignIn() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.MyAccountClick();
    }

    @When("^User set own Login Name$ and own Password$")
    public void userSetOwnLoginName() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       loginPage.LogInAction("by-@tut.by","NTAcWNFw27ACLHh\n");
        Thread.sleep(5000);
        startPage=new StartPage(driver);
        System.out.println("1");
    }

    @When("^User set TicketMode$")
    public void userSetTicketMode() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startPage.SetOneWay();
    }

    @When("^User set Origin Place$")
    public void userSetOriginPlace() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startPage.SetOriginPlace("Минск");
    }

    @When("^User set Destination Place$")
    public void userSetDestinationPlace() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        startPage.SetDestinationPlace("Москва");
    }

    @When("^User set Date$")
    public void userSetDate() throws Throwable {
     startPage.SetDepartureDate();
     searchResultPage=new SearchResultPage(driver);
    }

    @When("^User seen List with result$")
    public void userSeenListWithResult() throws Throwable {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        countTickets=searchResultPage.getCount();
    }

    @Then("^Count if results more (\\d+)$")
    public void countIfResultsMore(int count) throws Throwable {
        try {
            Assert.assertTrue(countTickets > count);
        }
        finally {
            driver.quit();
        }
    }
}
