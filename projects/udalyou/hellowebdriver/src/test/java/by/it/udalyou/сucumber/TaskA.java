package by.it.udalyou.сucumber;

import by.it.udalyou.pages.ResultPage;
import by.it.udalyou.pages.StartPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static afu.org.checkerframework.checker.units.UnitsTools.mm;
import static org.testng.Assert.*;
@Test
public class TaskA {

    private WebDriver driver;
    private StartPage startPage;
    private ResultPage resultPage;
    private int countTickets;

    @Before
    public void InitTest(){
        driver=new ChromeDriver();
    }


    @Given("^Home Page airline Is Loaded from \"([^\"]*)\"$")
    public void homePageAirlineIsLoadedFrom() throws Throwable {
    driver.get("https://www.expedia.com/");
        startPage=new StartPage(driver);
       assertNotNull (startPage);
    }

    @When("^User set Flight Mode$")
    public void userSetFlightMode() throws Throwable {
        startPage.selectSearchFlightMode();
        assertNotNull (startPage);
    }

    @When("^User set One Way Ticket$")
    public void userSetOneWayTicket() throws Throwable {
        startPage.selectOneWay();
        assertNotNull (startPage);
    }

    @When("^Set Origin \"([^\"]*)\"$")
    public void setOrigin() throws Throwable {
        startPage.setOrigin("Minsk, Belarus (MSQ-All Airports)");
        assertNotNull (startPage);
    }

    @When("^Set Destination \"([^\"]*)\"$")
    public void setDestination() throws Throwable {
        startPage.setDestination("Moscow, Russia (MOW-All Airports)");
        assertNotNull (startPage);
    }

    @When("^Set Date (\\d+)/(\\d+)/(\\d+)$")
    public void setDate() throws Throwable {
       // String stringDate = String.format("%02d/%02d/%04d/",dd,mm,yyyy);
        startPage.setDepartingDate("20/06/2019");
        assertNotNull (startPage);
    }


    @When("^Click Search$")
    public void clickSearch() throws Throwable {
        resultPage=startPage.getSearch();
        assertNotNull (resultPage);
    }

    @When("^User seen List with result$")
    public void userSeenListWithResult() throws Throwable {
        countTickets=resultPage.getResultSearchCount();
        assertTrue(countTickets>=0);
    }

    @Then("^Count if results more (\\d+)$")
    public void countIfResultsMore(int count) throws Throwable {

        assertTrue(countTickets > count);
    }
      @After
              public void swichOfDriver(){
          driver.quit();}

    }

