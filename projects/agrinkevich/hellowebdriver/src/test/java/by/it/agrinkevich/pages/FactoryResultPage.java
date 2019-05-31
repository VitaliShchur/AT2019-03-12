package by.it.agrinkevich.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FactoryResultPage {

    private WebDriver driver;

    public FactoryResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindAll({
            @FindBy(xpath = "//*[@data-test-id='listing-price-dollars']")
    })
    List<WebElement> prices;

    public List<WebElement> getPrices() {
        return prices;
    }

}
