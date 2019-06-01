package by.it.udalyou;

import by.it.udalyou.Tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalcPage {

    private WebDriver driver;

    public CalcPage(WebDriver dreiver){
        this.driver=dreiver;}

    private By byFildExpression = By.id("expression");
    private By byButtonEnter = By.id("submit");
    private By byFildResult = By.id("results");


    public CalcPage enter() {
        Util.find(driver, byButtonEnter).click();
        Util.shortWait(driver);
        return this;
    }


    public CalcPage selectFildExpression(String expression) {
        WebElement expressionInput = Util.find(driver, byFildExpression);
                Util.shortWait(driver);
        expressionInput.sendKeys(expression);
        Util.shortWait(driver);
        System.out.println(this);
        return this;
    }



    public CalcPage getResult() {
        WebElement getResults = Util.find(driver, byFildResult);
        Util.shortWait(driver);
        getResults.getText();
        System.out.println(getResults);
        Util.shortWait(driver);

        return this;
    }
}
