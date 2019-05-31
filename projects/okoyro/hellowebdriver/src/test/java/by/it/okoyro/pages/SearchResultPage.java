package by.it.okoyro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

	private WebDriver driver;
	private By foundedFlight = By.cssSelector("#flightModuleList span.show-flight-details");

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public int countSearchResults() {
		List<WebElement> searchResults = driver.findElements(foundedFlight);
		int searchResultsQuantity = searchResults.size();
		return searchResultsQuantity;

	}
}
