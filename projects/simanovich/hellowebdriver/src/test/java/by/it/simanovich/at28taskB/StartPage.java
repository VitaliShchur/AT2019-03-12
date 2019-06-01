package by.it.simanovich.at28taskB;

import by.it.simanovich.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By byButtonFlight = By.id("tab-flight-tab-hp");
    private By byButtonOneWay = By.id("flight-type-one-way-label-hp-flight");
    private By byInputOrigin = By.id("flight-origin-hp-flight");
    private By byInputDestination = By.id("flight-destination-hp-flight");
    private By byInputDepartingDate = By.id("flight-departing-single-hp-flight");
    private By byAriaOption0 = By.id("aria-option-0");

    public StartPage selectSearchFlightMode() {
        Util.find(driver, byButtonFlight).click();
        return this;
    }

    public StartPage selectOneWay() {
        Util.find(driver, byButtonOneWay).click();
        return this;
    }

    public StartPage setOrigin(String origin) {
        WebElement originInput = Util.find(driver, byInputOrigin);
        originInput.click();
        Util.shortWait(driver);
        originInput.sendKeys(origin);
        Util.shortWait(driver);
        WebElement dropDownValie = Util.find(driver, byAriaOption0);
        dropDownValie.click();
        return this;
    }

    public StartPage setDestination(String destination) {
        WebElement inputDestination = Util.find(driver, byInputDestination);
        inputDestination.click();
        Util.shortWait(driver);
        inputDestination.sendKeys(destination);
        Util.shortWait(driver);
        WebElement dropDownValie = Util.find(driver, byAriaOption0);
        dropDownValie.click();
        return this;
    }

    public StartPage setDepartingDate(String date) {
        WebElement inputDepartingDate = Util.find(driver, byInputDepartingDate);
        inputDepartingDate.click();
        Util.shortWait(driver);
        inputDepartingDate.sendKeys(date);
        Util.shortWait(driver);
        return this;
    }

    public ResultPage getSearch() {
        WebElement inputDepartingDate = Util.find(driver, byInputDepartingDate);
        inputDepartingDate.sendKeys("\n");
        Util.shortWait(driver);
        ResultPage resultPage=new ResultPage(driver);
        return resultPage;
    }

}
