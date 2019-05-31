package by.it.medvedeva.cucumber;

import by.it.medvedeva.pages.ResultPage;
import by.it.medvedeva.pages.StartPage;
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


    @Given("^Home Page airline Is Loaded$")
    public void homePageAviacompanyIsloaded() throws Throwable {
        driver.get("https://www.expedia.com");
        startPage = new StartPage(driver);
        assertTrue(startPage != null);
    }

    @When("^User set Flight Mode$")
    public void userSetFlightMode() throws Throwable {
        startPage.selectSearchFlightMode();

    }

    @When("^User set One Way Ticket$")
    public void userSetOneWayTicket() throws Throwable {
        startPage.selectOneWay();
    }

    @When("^Set Origin Minsk$")
    public void setOriginMinsk() throws Throwable {
        startPage.setOrigin("Minsk");

    }

    @When("^Set Destination$")
    public void setDestination() throws Throwable {
        startPage.setDestination("Moscow");

    }

    @When("^Set Date (\\d+)/(\\d+)/(\\d+)$")
    public void setDate(int dd, int mm, int yyyy) throws Throwable {
        String stringDate = String.format("%02d/%02d/%04d/", dd, mm, yyyy);
        startPage.setDepartingDate("28/6/2019");

    }

    @When("^Click Search$")
    public void clickSearch() throws Throwable {
        resultPage = startPage.getSearch();

    }

    @When("^User seen List with result$")
    public void userSeenListWithResult() throws Throwable {
        countTickets = resultPage.getResultSearchCount();

    }

    @Then("^Count if results more (\\d+)$")
    public void countIfResultsMore(int count) throws Throwable {
        try {
            assertTrue(countTickets > count);
        } finally {
            driver.quit();
        }


    }
}