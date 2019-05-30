package by.it.simanovich.at28taskB;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class LoginPage {

    public void setupBrowser() {
        WebDriver driver = new ChromeDriver();
    }


       @FindBy ("//*[@id=\"account-signin\"]")
               WebElement signInbutton;

       @FindBy ("//*[@id=\"gss-signin-email\"]")
               WebElement emailField;

       @FindBy ("//*[@id=\"gss-signin-password\"]")
               WebElement passwordField;

       @FindBy ("//*[@id=\"gss-signin-submit\"]")
               WebElement signInConfirmButton;


       public void logIn (String email, String password){

           emailField.sendKeys(email);
           passwordField.sendKeys(password);
           signInConfirmButton.click();


       }



}
