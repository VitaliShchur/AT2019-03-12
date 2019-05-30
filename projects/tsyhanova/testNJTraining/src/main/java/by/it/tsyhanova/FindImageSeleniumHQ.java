package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class FindImageSeleniumHQ {
    public static void main(String[] args) throws Exception {

        WebDriver driver;

       driver = new FirefoxDriver();
       driver.manage().window().maximize();




            driver.get("https://www.google.com");
            // Engish page
            // driver.get("https://www.google.com/webhp?hl=en");
            By byQueryInput = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, byQueryInput);
            queryInput.sendKeys("seleniumhq\n");
            queryInput.submit();
            /*By byButtonSearch = By.xpath("//input[@class='gNO89b']");
            WebElement buttonSearch = waitAndGetWebElement(driver, byButtonSearch);
            buttonSearch.click();*/

            By byLinkImagesSearch = By.xpath("//a[@class='q qs'][contains(@href,'tbm=isch')]");
            WebElement linkImagesSearch = waitAndGetWebElement(driver, byLinkImagesSearch);
            linkImagesSearch.click();

            By byLinkResultFirstImage = By.xpath("//*[@class='rg_bx rg_di rg_el ivg-i'][@data-ri='0']");
            WebElement linkResultFirstImage = waitAndGetWebElement(driver, byLinkResultFirstImage);
            linkResultFirstImage.click();

            By byLinkResultSite = By.xpath("//a[@class='irc_vpl i3599 irc_lth'][@tabindex=0]");
            WebElement linkResultSite = waitAndGetWebElement(driver, byLinkResultSite);

            //wait rendering (но лучше проверить это явно)
            Thread.sleep(333);
            linkResultSite.click();

            //open a new tab and check url at the last tab
            /*Set<String> handles = driver.getWindowHandles();
            List<String> handlesList = new ArrayList<>(handles);
            String newTab = handlesList.get(handlesList.size() - 1);
            String prevTab=handlesList.get(handlesList.size()-2);*/

            ArrayList tabs=new ArrayList(driver.getWindowHandles());


            // switch to new tab
            //driver.switchTo().window(newTab);
            driver.switchTo().window((String) tabs.get(tabs.size()-1));
            String url = driver.getCurrentUrl();
           // assertTrue("not complete find", url.startsWith("https://www.seleniumhq.org"));
        System.out.println(url);
        driver.get(url);
        String title=driver.getTitle();
        System.out.println(title);
        String titleSelenium="Selenium - Web Browser Automation";
        Boolean titleIsEqual=title.equals(titleSelenium);
        if(titleIsEqual) {
            System.out.println("Title is Selenium - Web Browser Automation");
        }
        else{
            System.out.println("Title is not Selenium - Web Browser Automation");
        }

        driver.switchTo().window((String) tabs.get(0));
        //driver.close();


        By byLinkImagesSearchCrist = By.xpath("//*[@id='irc_cb']");
        WebElement linkImagesSearchCrist = waitAndGetWebElement(driver, byLinkImagesSearchCrist);
        linkImagesSearchCrist.click();


        //drag and drop of image

        By byQueryInputTo = By.xpath("//input[@class='gLFyf gsfi']");
        WebElement queryInputTo = waitAndGetWebElement(driver, byQueryInputTo);
        queryInputTo.clear();

        By byLinkImagesSearchFrom = By.xpath("//img[@id='i48MSmX01sE18M:']");
        WebElement linkImagesSearchFrom = waitAndGetWebElement(driver, byLinkImagesSearchFrom);

        Actions builder=new Actions(driver);
        builder.dragAndDrop(linkImagesSearchFrom,queryInputTo).perform();

        //  driver.quit();
        }
    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }

    }
