package by.it.akhmelev.cucumber;

import by.it.akhmelev.pages.ResultPage;
import by.it.akhmelev.pages.StartPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    public void home_Page_airline_Is_Loaded_from(String url) throws Throwable {
        driver.get(url);
        startPage = new StartPage(driver);
        assertNotNull(startPage);
    }

    @When("^User set Flight Mode$")
    public void userSetFlightMode() throws Throwable {
        startPage.selectSearchFlightMode();
        assertNotNull(startPage);
    }

    @When("^User set One Way Ticket$")
    public void userSetOneWayTicket() throws Throwable {
        startPage.selectOneWay();
        assertNotNull(startPage);
    }

    @When("^Set Origin \"([^\"]*)\"$")
    public void set_Origin(String city) throws Throwable {
        startPage.setOrigin(city);
        assertNotNull(startPage);
    }

    @When("^Set Desination \"([^\"]*)\"$")
    public void set_Desination(String city) throws Throwable {
        startPage.setDestination(city);
        assertNotNull(startPage);
    }

    @When("^Set Date (\\d+)/(\\d+)/(\\d+)$")
    public void setDate(int arg1, int arg2, int arg3) throws Throwable {
        startPage.setDepartingDate("6/6/2019");
        assertNotNull(startPage);
    }

    @When("^Click Search$")
    public void clickSearch() throws Throwable {
        resultPage = startPage.getSearch();
        assertNotNull(resultPage);
    }

    @When("^User seen List with result$")
    public void userSeenListWithResult() throws Throwable {
        countTickets = resultPage.getResultSearchCount();
        assertTrue(countTickets>=0);
    }

    @Then("^Count if results more (\\d+)$")
    public void countIfResultsMore(int count) throws Throwable {
        assertTrue(countTickets > count);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
