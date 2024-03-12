package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecentlyPlayedPage extends BasePage{
    public RecentlyPlayedPage (WebDriver givenDriver) {
        super (givenDriver);
    }
    @FindBy (xpath = "//section[@id='recentlyPlayedWrapper']//h1[1]")
    WebElement recentlyPlayedPlaylistHeader;
    @FindBy (css = "#recentlyPlayedWrapper .fa-random")
    WebElement shuffleBtn;

    public boolean recentlyPlayedPlaylistDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(recentlyPlayedPlaylistHeader));
        return recentlyPlayedPlaylistHeader.isDisplayed();
    }
    public void clickShuffleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleBtn));
        actions.moveToElement(shuffleBtn).click().perform();
    }
}
