package by.it.okoyro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageB {

	private WebDriver driver;

	@FindBy
			(id = "tab-flight-tab-hp") WebElement flightTab;
	@FindBy
			(id = "flight-origin-hp-flight") WebElement flightInputFrom;
	@FindBy
			(id = "flight-destination-hp-flight") WebElement flightInputTo;
	@FindBy
			(id = "flight-type-one-way-label-hp-flight") WebElement oneWayButton;
	@FindBy
			(css = "section#section-flight-tab-hp button[type='submit']") WebElement searchButton;
	@FindBy
			(id = "flight-departing-single-hp-flight") WebElement departureDateInput;
	@FindBy
			(id = "typeaheadDataPlain") WebElement airportDropDawn;
	@FindBy
			(id = "ria-option-0") WebElement firstOption;
	@FindBy
			(id = "flight-returning-hp-flight") WebElement returningDateInput;
	@FindBy
			(className = "title-city-text") WebElement flightTitle;
	@FindBy
			(className = "datepicker-close-btn") WebElement closeDatepickerButton;

	public HomePageB(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePageB setSearchFlightMode() {
		flightTab.click();
		(new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("flight-type-one-way-label-hp-flight")));
		return this;
	}

}
