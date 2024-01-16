package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    public SearchPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='search']")
    WebElement searchField;

    public SearchPage searchSend (String songName) {
        findElement(searchField).sendKeys(songName);
        return this;
    }


}
