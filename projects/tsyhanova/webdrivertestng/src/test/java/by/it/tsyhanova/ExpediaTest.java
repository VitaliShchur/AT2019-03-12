package by.it.tsyhanova;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test(groups = {"at28"})
public class ExpediaTest{

    private WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
       driver = new ChromeDriver();
    }

    @Test(groups = {"at28"})
    public void TaskA() throws Exception{
        driver.get("https://www.expedia.com/");
        HomePage homePage = new HomePage(driver);
        homePage.assertMainPageLoaded();
        homePage.clickFlightSearch();
        homePage.typeDepartureAirport("Minsk, Belarus (MSQ-All Airports)");
        homePage.typeDestinationAirport("Moscow, Russia (MOW-All Airports)");
        homePage.selectDepartingDate();
        homePage.selectReturningDate();
        homePage.submitForm();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.checkMoreThanOneResult();
        Thread.sleep(3000);
        // waitForElementAndClick(By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button/span"));


    }

    @AfterMethod
    public void tearDownDriver(){
        driver.quit();
    }
}
