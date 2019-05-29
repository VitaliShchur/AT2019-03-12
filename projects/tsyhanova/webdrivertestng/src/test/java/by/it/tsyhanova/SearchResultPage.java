package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends Util {

    private static final By
            SEARCH_RESULT = By.xpath("//li[@class=\"flight-module segment offer-listing\"]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void checkMoreThanOneResult(){
        assertSeveralElements(SEARCH_RESULT);
    }
}
