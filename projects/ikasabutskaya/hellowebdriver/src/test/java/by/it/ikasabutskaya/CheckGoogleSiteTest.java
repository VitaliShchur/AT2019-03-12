package by.it.ikasabutskaya;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*public class CheckGoogleSiteTest {

    @Test

    public void userTryFindRasrasrasInGoogle() throws Exception {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://www.google.com");
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("ras ras ras\n");
            waitAndGetWebElement(driver, By.xpath("//span[@class=\"csb ch\"]"));

        }
        finally {
            driver.quit();

        }
    }

    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));

        return driver.findElement(queryLocator);
    }
}*/

public class CheckGoogleSiteTest {
    @Test
    public void userTryFindHelloInGoogle() throws Exception{
        WebDriver driver=new ChromeDriver();
        try {

            driver.get("https://www.google.by/");
            //поиск поля ввода по его классу
            By queryLocator = By.xpath("//input[@class='gLFyf gsfi']");
            //ctrl+alt+m получение метода из кода
            WebElement queryInput = waitAndGetWebElement(driver, queryLocator);
            queryInput.sendKeys("ras ras ras\n");
            //поиск элемента страницы, всегда присутствующего при выводе результатов поиска
            waitAndGetWebElement(driver, By.xpath("//*[@id='logo']/img"));
        }
        finally {
            //quit
            driver.quit();
        }

    }
    @Test
    public void userTryFindSeleniumHQ() throws Exception{
        //TaskB
        WebDriver driver2=new ChromeDriver();
        try {
            driver2.get("https://www.google.by/");
            //поиск поля ввода по его классу
            By queryLocator2 = By.xpath("//input[@class='gLFyf gsfi']");
            //ctrl+alt+m получение метода из кода
            WebElement queryInput2 = waitAndGetWebElement(driver2, queryLocator2);
            queryInput2.sendKeys("seleniumhq\n");
            //поиск элемента страницы, всегда присутствующего при выводе результатов поиска
            //waitAndGetWebElement(driverB,By.xpath("//div[@class='r']/a"));
            WebElement element = driver2.findElement(By.xpath("//div[@class='r']/a"));
            element.click();
            WebElement elementSeleniumDownload = driver2.findElement(By.xpath("//a[normalize-space(text())='Download']"));
            elementSeleniumDownload.click();
            WebElement elementMavenInformation = driver2.findElement(By.xpath("//a[normalize-space(text())='Maven Information']"));
            elementMavenInformation.click();
            WebElement elementDependency = driver2.findElement(By.xpath("//pre[1]"));
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
        }
        finally {
            driver2.quit();
        }
    }


    private static WebElement waitAndGetWebElement(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElement(queryLocator);
    }
}
