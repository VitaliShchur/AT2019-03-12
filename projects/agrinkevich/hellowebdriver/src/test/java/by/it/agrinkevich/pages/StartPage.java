package by.it.agrinkevich.pages;

import by.it.agrinkevich.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    //private By bySearchButton = By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button");
    //private By byCloseDatepickerButton = By.xpath("//*[@id='flight-departing-wrapper-single-hp-flight']/div/div[2]/div[1]/button");

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
        WebElement dropDownValue = Util.find(driver, byAriaOption0);
        dropDownValue.click();
        return this;
    }

    public StartPage setDestination(String destination) {
        WebElement inputDestination = Util.find(driver, byInputDestination);
        inputDestination.click();
        Util.shortWait(driver);
        inputDestination.sendKeys(destination);
        Util.shortWait(driver);
        WebElement dropDownValue = Util.find(driver, byAriaOption0);
        dropDownValue.click();
        return this;
    }

    public StartPage setDepartingDate(int num) throws ParseException {
        WebElement inputDepartingDate = Util.find(driver, byInputDepartingDate);
        inputDepartingDate.click();
        Util.shortWait(driver);
        inputDepartingDate.sendKeys(setDate(num));
        //Util.shortWait(driver);
        //Util.find(driver, byCloseDatepickerButton).click();
        return this;
    }

    public ResultPage getSearch() {
        Util.shortWait(driver);
        WebElement inputDepartingDate = Util.find(driver, byInputDepartingDate);
        inputDepartingDate.submit();
        ResultPage resultPage = new ResultPage(driver);
        return resultPage;
    }

    private String setDate(int num) throws ParseException {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strCurrentDate = formatter.format(currentDate);  // Start date
        Calendar c = Calendar.getInstance();
        c.setTime(formatter.parse(strCurrentDate));
        c.add(Calendar.DATE, num);  // number of days to add
        strCurrentDate = formatter.format(c.getTime());// strCurrentDate is now the new date

        return strCurrentDate;
    }
}
