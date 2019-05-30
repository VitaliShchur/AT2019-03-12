package by.it.tsyhanova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckGoogleSiteTest {

    private static WebElement waitAndGetWebElement (WebDriver driver, By queryLocator){
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }

    @Test (groups = {"at23"})
    public void userTryFindHelloInGoogle() throws Exception{
        WebDriver driver=new ChromeDriver();
        try {
            driver.get("https://google.com");
            By queryLocator=By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("привет\n");
            waitAndGetWebElement(driver,By.xpath("//span[@class=\"csb ch\"]"));
        }
        finally {
            driver.quit();
        }
    }

    @Test (groups = {"at23"})
    public void userTryFindSeleniumHQ() throws Exception {
        //TaskB
        WebDriver driverB = new ChromeDriver();
        try {
            driverB.get("https://www.google.by/");
            //поиск поля ввода по его классу
            By queryLocatorB = By.xpath("//input[@class='gLFyf gsfi']");
            //ctrl+alt+m получение метода из кода
            WebElement queryInputB = waitAndGetWebElement(driverB, queryLocatorB);
            queryInputB.sendKeys("seleniumhq\n");
            //поиск элемента страницы, всегда присутствующего при выводе результатов поиска
            //waitAndGetWebElement(driverB,By.xpath("//div[@class='r']/a"));
            WebElement element = driverB.findElement(By.xpath("//div[@class='r']/a"));
            element.click();
            WebElement elementSeleniumDownload = driverB.findElement(By.xpath("//a[normalize-space(text())='Download']"));
            elementSeleniumDownload.click();
            WebElement elementMavenInformation = driverB.findElement(By.xpath("//a[normalize-space(text())='Maven Information']"));
            elementMavenInformation.click();
            WebElement elementDependency = driverB.findElement(By.xpath("//pre[1]"));
            String str = elementDependency.getText();
            int positionArtifactId = str.indexOf("<artifactId>selenium-java</artifactId>");
            if (positionArtifactId > -1) {
                System.out.println("Element <artifactId>selenium-java</artifactId> OK");
            } else {
                System.out.println("Element doesn't issue");
            }
            int posVersionStart = str.indexOf("<version>") + 9;
            int posVersionEnd = str.indexOf("</version>");
            String strVersion = str.substring(posVersionStart, posVersionEnd);
            System.out.println("Java Version: " + strVersion);
            //System.out.println(str);
        } finally {
            driverB.quit();
        }
    }

}
