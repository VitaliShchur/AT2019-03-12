package by.it.tsyhanova.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Util {
    //пауза в 1 секунду
    //отличается от слипа тем, что она может быть или нет, в зависимости от того, успевает драйвер или нет
    //если в поле ввода города не печатается первая буква, нужно увеличить значение паузы
    public static void shortWait(WebDriver driver){
        new Actions(driver).pause(1000).perform();
    }

    //поиск элемента с явным ожиданием в 25 секунд
    public static WebElement find(WebDriver driver, By queryLocator) {
        return (new WebDriverWait(driver, 25))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
    }

    //поиск элементов с явным ожиданием в 10 секунд
    public static List<WebElement> findAll(WebDriver driver, By queryLocator) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(queryLocator));
        return driver.findElements(queryLocator);
    }
}
