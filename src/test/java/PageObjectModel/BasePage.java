package PageObjectModel;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    //SELENIUM PAGE FACTORY
    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void click (WebElement webElement) {
        findElement(webElement).click();
    }
    protected void doubleClick (WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }
    protected void contextClick(WebElement webElement) {
        actions.contextClick(findElement(webElement)).perform();
    }

    /*
    PAGE OBJECT MODEL(POM):

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
     protected WebElement findElement (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void click (By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    protected void doubleClick (By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }
    protected void contextClick (By locator) {
        actions.contextClick(findElement(locator)).perform();
    }
     */


}
