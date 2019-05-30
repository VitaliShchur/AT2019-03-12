package by.it.tsyhanova.pages;

import by.it.tsyhanova.tools.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage {

    private WebDriver driver;

    private By byPrice=By.xpath("//*[@data-test-id='listing-price-dollars']");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getResultSearchCount(){
        List<WebElement> elements = Util.findAll(driver,byPrice);
        return elements.size();
    }
}
