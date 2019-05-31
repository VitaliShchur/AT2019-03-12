package by.it.tsyhanova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id='merlin-search-container']/div[2]/footer/div[1]/div[1]/a[1]")
    @CacheLookup
    public static WebElement myAccount;

    @FindBy(how = How.ID, using = "Email")
    @CacheLookup
    public static WebElement userName;

    @FindBy(how = How.ID, using = "Password")
    @CacheLookup
    public static WebElement myPassword;



    // This method will take two arguments ( Username nd Password)
    public void LogInAction(String sUserName, String sPassword){
        userName.sendKeys(sUserName);
        myPassword.sendKeys(sPassword);
    }
    // This is a constructor, as every page need a base driver to find web elements
    public LoginPage(WebDriver driver){this.driver = driver;}

}
