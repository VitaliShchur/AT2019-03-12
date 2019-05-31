package by.it.okoyro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By flightTab = By.id("tab-flight-tab-hp");
	private By flightInputFrom = By.id("flight-origin-hp-flight");
	private By flightInputTo = By.id("flight-destination-hp-flight");
	private By oneWayButton = By.id("flight-type-one-way-label-hp-flight");
	private By searchButton = By.cssSelector("section#section-flight-tab-hp button[type='submit']");
	private By departureDateInput = By.id("flight-departing-single-hp-flight");
	private By airportDropDawn = By.id("typeaheadDataPlain");
	private By firstOption = By.id("aria-option-0");
	private By returningDateInput = By.id("flight-returning-hp-flight");
	private By flightTitle = By.className("title-city-text");
	private By closeDatepickerButton = By.className("datepicker-close-btn");


	// TODO: 2019-05-21 add all required locators

	public HomePage selectSearchFlightMode() {
		driver.findElement(flightTab).click();
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(oneWayButton));
		return this;
	}

	public HomePage selectOneWayFlight() {
		driver.findElement(oneWayButton).click();
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.invisibilityOfElementLocated(returningDateInput));
		return this;
	}

	public HomePage setFlightFrom(String destinationFrom) {
		driver.findElement(flightInputFrom).click();
		shortWait(driver);
		driver.findElement(flightInputFrom).sendKeys(destinationFrom);
		shortWait(driver);
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(airportDropDawn));
		driver.findElement(firstOption).click();
		return this;
	}

	public HomePage setFlightTo(String destinationTo) {
		driver.findElement(flightInputTo).click();
		shortWait(driver);
		driver.findElement(flightInputTo).sendKeys(destinationTo);
		shortWait(driver);
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(airportDropDawn));
		driver.findElement(firstOption).click();
		return this;
	}

	public HomePage setDepartureDate(String date) {
		driver.findElement(departureDateInput);
		shortWait(driver);
		driver.findElement(departureDateInput).click();
		shortWait(driver);
		driver.findElement(departureDateInput).sendKeys(date);
		driver.findElement(closeDatepickerButton).click();
		return this;
	}

	public SearchResultPage performSearch() {
		driver.findElement(searchButton).click();
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(flightTitle));
		SearchResultPage resultPage = new SearchResultPage(driver);
		return resultPage;
	}

	public static void shortWait(WebDriver driver) {
		new Actions(driver).pause(1000).perform();
	}
}
