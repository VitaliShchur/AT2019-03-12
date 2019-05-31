package by.it.tsyhanova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StartPage {

    final WebDriver driver;



    @FindBy(how = How.ID, using = "mat-input-0")
    @CacheLookup
    public static WebElement originPlace;

    @FindBy(how = How.ID, using = "mat-input-1")
    @CacheLookup
    public static WebElement destinationPlace;

    @FindBy(how = How.XPATH, using = "//*[@id='mat-option-9']/span/span[1]")
    @CacheLookup
    public static WebElement destinationAirport;

    //т.к. хром имеет проблему с кликом по радио, вместо радио используем его label
    @FindBy(how = How.XPATH, using = "//*[@id='mat-radio-3']/label/div[2]")
    @CacheLookup
    public static WebElement onWay;

    //выпадающий календарь
    @FindBy(how = How.ID, using = "mat-input-2")
    @CacheLookup
    public static WebElement departureDate;

    @FindBy(how = How.XPATH, using = "//*[@id='merlin-search-container']/div[1]/form/div[6]/button")
    @CacheLookup
    public static WebElement buttonClick;

    public void SetFlightDetailes(String sOriginPlace, String sDestinationPlace, String sDepartureDate){
        onWay.click();
        originPlace.clear();
        originPlace.sendKeys(sOriginPlace);
        destinationPlace.sendKeys(sDestinationPlace);
        destinationAirport.click();
        departureDate.clear();
        departureDate.sendKeys(sDepartureDate);
        buttonClick.click();
    }

    // This is a constructor, as every page need a base driver to find web elements
    public StartPage(WebDriver driver){this.driver = driver;}

}
