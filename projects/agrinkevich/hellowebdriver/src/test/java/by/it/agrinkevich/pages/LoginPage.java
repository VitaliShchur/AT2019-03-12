package by.it.agrinkevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gss-signin-email")
    WebElement inputEmail;

    @FindBy(id = "gss-signin-password")
    WebElement inputPassword;

    @FindBy(id = "gss-signin-submit")
    WebElement signInButton;

    public LoginPage setEmail(String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage setPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public FactoryStartPage doLogin() {
        signInButton.click();
        FactoryStartPage factoryStartPage = new FactoryStartPage(driver);
        return factoryStartPage;
    }


}
