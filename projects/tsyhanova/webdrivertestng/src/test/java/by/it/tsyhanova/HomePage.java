package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Util {

    protected HomePage(WebDriver driver) {
        super(driver);
    }

    private static final By
            FLIGHT_SEARCH_BUTTON = By.id("tab-flight-tab-hp"),
            FLIGHT_ORIGIN_FIELD = By.id("flight-origin-hp-flight"),
            FLIGHT_DESTINATION_FIELD = By.id("flight-destination-hp-flight"),
            DEPARTURE_DATE_FIELD = By.xpath("//input[@id=\"flight-departing-hp-flight\"]"),
            DEPARTURE_DATE = By.xpath("//*[@id=\"flight-departing-wrapper-hp-flight\"]/div//button[@data-day=1]"),
            RETURNING_DATE_FIELD = By.xpath("//input[@id=\"flight-returning-hp-flight\"]"),
            RETURNING_DATE = By.xpath("//*[@id=\"flight-returning-wrapper-hp-flight\"]/div//button[@data-day=30]"),
            SUBMIT_BUTTON = By.xpath("//*[@id=\"gcw-flights-form-hp-flight\"]/div//label/button"),
            MAIN_FORM = By.id("gcw-packages-form-hp-package");


    public void clickFlightSearch(){
        waitForElementAndClick(FLIGHT_SEARCH_BUTTON);
    }

    public void typeDepartureAirport(String text){
        waitForElementAndSendKeys(FLIGHT_ORIGIN_FIELD,text);
    }

    public void typeDestinationAirport(String text){
        waitForElementAndSendKeys(FLIGHT_DESTINATION_FIELD, text);
    }

    public void selectDepartingDate(){
        waitForElementAndClick(DEPARTURE_DATE_FIELD);
        waitForElementAndClick(DEPARTURE_DATE);
    }

    public void selectReturningDate(){
        waitForElementAndClick(RETURNING_DATE_FIELD);
        waitForElementAndClick(RETURNING_DATE);
    }

    public void submitForm(){
        waitForElementAndClick(SUBMIT_BUTTON);
    }

    public void assertMainPageLoaded(){
        waitForElement(10000,MAIN_FORM);
    }


}
