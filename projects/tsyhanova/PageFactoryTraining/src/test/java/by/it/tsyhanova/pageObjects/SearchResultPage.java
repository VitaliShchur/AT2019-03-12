package by.it.tsyhanova.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchResultPage {

    final WebDriver driver;

    //@FindBy(how = How.CLASS_NAME, using = "course")
    @FindAll(@FindBy(how = How.CLASS_NAME, using = "course"))
    @CacheLookup
    public static List<WebElement> allSearchResultElements;

    public int getCount(){
        return allSearchResultElements.size();
    }


    // This is a constructor, as every page need a base driver to find web elements
    public SearchResultPage(WebDriver driver){this.driver = driver;}
}
