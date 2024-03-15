package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PlaylistPage extends BasePage {
    public PlaylistPage (WebDriver givenDriver){
        super (givenDriver);
    }

    @FindBy (xpath = "//section[@id='playlistWrapper']//h1[1]")
    WebElement createdPlaylistHeader;
    @FindBy (css = "#playlistWrapper .btn-shuffle-all")
    WebElement shuffleBtn;

    public boolean createdPlaylistDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(createdPlaylistHeader));
        return createdPlaylistHeader.isDisplayed();
    }
    public void clickShuffleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleBtn));
        actions.moveToElement(shuffleBtn).click().perform();
    }
}
