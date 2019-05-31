package by.it.simanovich.cucumber;

import by.it.simanovich.at28taskB.ResultPage;
import by.it.simanovich.at28taskB.StartPage;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

@Test
public class TaskA {

   private WebDriver driver;
   private StartPage startPage;
   private ResultPage resultPage;
   private int countResult;


   @Before
   public void InitTest (){
       driver = new ChromeDriver();
   }

    @Given("^Home Page aviacompany Is Loaded$")
    public void home_Page_aviacompany_Is_Loaded() throws Throwable {
        driver.get("https://www.expedia.com/");
        startPage = new StartPage(driver);
        assertTrue (startPage != null);
    }

    @When("^User set Flight Mode$")
    public void user_set_Flight_Mode() throws Throwable {
        startPage.selectSearchFlightMode();
    }

    @When("^User set One Way Ticket$")
    public void user_set_One_Way_Ticket() throws Throwable {
        startPage.selectOneWay();
    }

    @When("^Set Origin Minsk$")
    public void set_Origin_Minsk() throws Throwable {
        startPage.setOrigin("Minsk");
    }

    @When("^Set Destination Moscow$")
    public void set_Destination_Moscow() throws Throwable {
        startPage.setDestination("Moscow");
    }

    @When("^Set Date (\\d+)/(\\d+)/(\\d+)$")
    public void set_Date(int arg1, int arg2, int arg3) throws Throwable {
        startPage.setDepartingDate("6/6/2019");
    }

    @When("^Click Search$")
    public void click_Search() throws Throwable {
        resultPage = startPage.getSearch();
    }

    @When("^User seen List with result$")
    public void user_seen_List_with_result() throws Throwable {
        countResult = resultPage.getResultSearchCount();
    }

    @Then("^Count if results more (\\d+)$")
    public void count_if_results_more(int count) throws Throwable {
       try {


           assertTrue(countResult > count);
       }
       finally {
           driver.quit();
       }
    }
}
