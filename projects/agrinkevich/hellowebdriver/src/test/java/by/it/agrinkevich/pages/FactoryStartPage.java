package by.it.agrinkevich.pages;

import by.it.agrinkevich.tools.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FactoryStartPage {

    private WebDriver driver;

    public FactoryStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tab-flight-tab-hp")
    private WebElement buttonFlight;

    @FindBy(id = "flight-type-roundtrip-label-hp-flight")
    private WebElement buttonRoundTrip;

    @FindBy(id = "flight-origin-hp-flight")
    private WebElement inputOrigin;

    @FindBy(id = "flight-destination-hp-flight")
    private WebElement inputDestination;

    @FindBy(id = "flight-departing-hp-flight")
    private WebElement inputDepartingDate;

    @FindBy(id = "flight-returning-hp-flight")
    private WebElement inputReturningDate;

    @FindBy(id = "aria-option-0")
    private WebElement ariaOption0;

    @FindBy(xpath = "//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='traveler-selector-hp-flight']/div/ul/li/button")
    private WebElement selectNumberOfPeople;

    @FindBy(xpath = "//*[@id='traveler-selector-hp-flight']/div/ul/li/div/div/div/div[1]/div[4]/button")
    private WebElement buttonIncreaseNumberOfAdults;

    @FindBy(xpath = "//*[@id='flight-departing-wrapper-single-hp-flight']/div/div[2]/div[1]/button")
    private WebElement closeDepartingDatepickerButton;

    @FindBy(xpath = "//*[@class='datepicker-close-btn close btn-text']")
    private WebElement closeReturningDatepickerButton;

    @FindBy(id = "header-account-menu")
    private WebElement dropDownAccount;

    @FindBy(id = "account-signin")
    private WebElement signInOption;


    public FactoryStartPage openAccountDropDown() {
        dropDownAccount.click();
        return this;
    }

    public LoginPage openSignInForm() {
        signInOption.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public FactoryStartPage selectSearchFlightMode() throws InterruptedException {
        //too long timeout was set because of passing a captcha
        Thread.sleep(200000);
        buttonFlight.click();
        return this;
    }

    public FactoryStartPage selectRoundTrip() {
        buttonRoundTrip.click();
        return this;
    }

    public FactoryStartPage setOrigin(String origin) {
        inputOrigin.click();
        inputOrigin.sendKeys(origin);
        return this;
    }

    public FactoryStartPage setDestination(String destination) {
        inputDestination.click();
        inputDestination.sendKeys(destination);
        return this;
    }

    public FactoryStartPage setDepartingDate(int num) throws ParseException {
        inputDepartingDate.click();
        inputDepartingDate.sendKeys(setDate(num));
        inputDepartingDate.click();
        return this;
    }

    public FactoryStartPage setReturningDate(int num) throws ParseException {
        inputReturningDate.click();
        try {
            Robot robot = new Robot();
            Util.shortWait(driver);
            robot.keyPress(KeyEvent.VK_CONTROL);
            Util.shortWait(driver);
            robot.keyPress(KeyEvent.VK_A);
            Util.shortWait(driver);
            robot.keyRelease(KeyEvent.VK_A);
            Util.shortWait(driver);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_BACK_SPACE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Util.shortWait(driver);
        inputReturningDate.sendKeys(setDate(num));
        Util.shortWait(driver);
        inputReturningDate.click();
        return this;
    }

    public FactoryStartPage setTwoAdult() {
        selectNumberOfPeople.click();
        buttonIncreaseNumberOfAdults.click();
        selectNumberOfPeople.click();
        return this;
    }

    public FactoryResultPage getSearch() throws InterruptedException {
        Util.shortWait(driver);
        inputReturningDate.click();
        inputReturningDate.submit();

        FactoryResultPage factoryResultPage = new FactoryResultPage(driver);
        return factoryResultPage;
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
