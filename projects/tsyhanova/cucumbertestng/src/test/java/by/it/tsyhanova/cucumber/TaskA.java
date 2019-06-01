package by.it.tsyhanova.cucumber;

import by.it.tsyhanova.pages.ResultPage;
import by.it.tsyhanova.pages.StartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class TaskA {

    private WebDriver driver;
    private StartPage startPage;
    private ResultPage resultPage;
    private int countTickets;

    @Before
    public void InitTest() {
        driver = new ChromeDriver();
    }


    @Given("^Home Page airline Is Loaded from \"([^\"]*)\"$")
    @Step("Home Page airline Is Loaded")
    public void home_Page_airline_Is_Loaded_from(String url) throws Throwable {
        driver.get(url);
        startPage = new StartPage(driver);
        assertNotNull(startPage);
    }

    @When("^User set Flight Mode$")
    @Step("User set Flight Mode")
    public void userSetFlightMode() throws Throwable {
        startPage.selectSearchFlightMode();
        assertNotNull(startPage);
    }

    @When("^User set One Way Ticket$")
    @Step("User set One Way Ticket")
    public void userSetOneWayTicket() throws Throwable {
        startPage.selectOneWay();
        assertNotNull(startPage);
    }

    @When("^Set Origin \"([^\"]*)\"$")
    @Step("Set Origin")
    public void set_Origin(String city) throws Throwable {
        startPage.setOrigin(city);
        assertNotNull(startPage);
    }

    @When("^Set Destination \"([^\"]*)\"$")
    @Step("Set Destination")
    public void set_Destination(String city) throws Throwable {
        startPage.setDestination(city);
        assertNotNull(startPage);
    }

    @When("^Set Date (\\d+)/(\\d+)/(\\d+)$")
    @Step("Set Date")
    public void setDate(int dd, int mm, int yyyy) throws Throwable {
        String stringDate = String.format("%02d/%02d/%04d/", dd, mm, yyyy);
        startPage.setDepartingDate("6/6/2019");
        assertNotNull(startPage);
    }

    @When("^Click Search$")
    @Step("Click Search")
    public void clickSearch() throws Throwable {
        resultPage = startPage.getSearch();
        assertNotNull(resultPage);
    }

    @When("^User seen List with result$")
    @Step("User seen List with result")
    public void userSeenListWithResult() throws Throwable {
        countTickets = resultPage.getResultSearchCount();
        assertTrue(countTickets >= 0);
    }

    @Then("^Count if results more (\\d+)$")
    @Step("Count if results more")
    public void countIfResultsMore(int count) throws Throwable {
        assertTrue(countTickets > count);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
