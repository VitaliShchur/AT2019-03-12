package by.it.simanovich.at28taskB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy ("//*[@id=\"tab-flight-tab-hp\"]/span[1]")
    WebElement buttonFlight;

    @FindBy ("//*[@id=\"flight-origin-hp-flight\"]")
    WebElement fromSearchField;

    @FindBy ("//*[@id=\"flight-destination-hp-flight\"]")
    WebElement toSearchField;

    @FindBy ("//*[@id=\"flight-departing-hp-flight\"]")
    WebElement depardingDate


}
