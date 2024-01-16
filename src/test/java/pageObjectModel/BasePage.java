package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    public WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void click(WebElement webElement) {
        findElement(webElement).click();
    }

    public void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();
    }

    public Boolean isTextPresentInElement(WebElement webElement, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
            return true;  // Return true if the text is present
        } catch (TimeoutException e) {
            return false;  // Return false if the text is not present within the timeout
        }


//        protected List<WebElement> findElements (By locator) {
//        elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//            return elements;
//        }
//        By locator = driver.findElements(By.xpath("//ol[@class=\"recently-added-album-list\"]//span[text()='by']"));

    }

}
