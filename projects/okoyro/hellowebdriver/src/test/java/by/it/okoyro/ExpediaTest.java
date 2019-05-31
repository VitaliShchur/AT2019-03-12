package by.it.okoyro;

import by.it.okoyro.pages.HomePageB;
import by.it.okoyro.pages.SearchResultPage;
import by.it.okoyro.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpediaTest {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void taskA() throws Exception {
		driver.get("https://www.expedia.com/");

		HomePage homePage = new HomePage(driver);
		SearchResultPage resultPage = homePage
				.selectSearchFlightMode()
				.selectOneWayFlight()
				.setFlightFrom("minsk") //, Belarus (MSQ-All Airports
				.setFlightTo("moscow") // , Russia (MOW-All Airports
				.setDepartureDate("06/20/2019")
				.performSearch();
		int searchResultsQuantity = resultPage.countSearchResults();
		Assert.assertTrue(searchResultsQuantity > 1);
	}

	@Test
	public void taskB() throws Exception {
		driver.get("https://www.expedia.com/");

		HomePageB homePageB = new HomePageB(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}


}
