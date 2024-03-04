package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InfoPanelPage extends BasePage {
    public InfoPanelPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (css = "button.control.text-uppercase.active")
    WebElement infoButton;
    @FindBy (css = "div.tabs")
    WebElement infoPanel;
    @FindBy (css = "button[id='extraTabLyrics']")
    WebElement lyricsTab;
    @FindBy (css = "button[id='extraTabArtist']")
    WebElement artistTab;
    @FindBy (css = "button[id='extraTabAlbum']")
    WebElement albumTab;
    @FindBy (css = "article[id='lyrics']")
    WebElement songLyrics;
    @FindBy (css = "h1.name")
    WebElement artistName;
    @FindBy (css = "article.album-info.sidebar")
    WebElement albumNameCover;
    @FindBy (css = "i.fa.fa-bars")
    WebElement shuffleButton;
    @FindBy (css = "a.queue.active")
    WebElement currentQueue;

    public void clickInfoButton () {
        wait.until(ExpectedConditions.elementToBeClickable(infoButton)).click();
    }
    public Boolean infoPanelOpen () {
        wait.until(ExpectedConditions.visibilityOf(infoPanel));
        return true;
    }
    public Boolean infoPanelClosed () {
        wait.until(ExpectedConditions.invisibilityOf(infoPanel));
        return true;
    }
    public void clickLyricsTab () {
        wait.until(ExpectedConditions.visibilityOf(lyricsTab)).click();
    }
    public void clickArtistTab () {
        wait.until(ExpectedConditions.visibilityOf(artistTab)).click();
    }
    public void clickAlbumTab () {
        wait.until(ExpectedConditions.visibilityOf(albumTab)).click();
    }
    public Boolean lyricsDisplayed () {
        wait.until(ExpectedConditions.visibilityOf(songLyrics));
        return songLyrics.isDisplayed();
    }
    public Boolean artistNameDisplayed () {
        wait.until(ExpectedConditions.visibilityOf(artistName));
        return artistName.isDisplayed();
    }
    public Boolean albumDisplayed () {
        wait.until(ExpectedConditions.visibilityOf(albumNameCover));
        return albumNameCover.isDisplayed();
    }
    public void shuffleSongsArtist () {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButton)).click();
    }
    public void shuffleSongsAlbum () {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButton)).click();
    }
    public Boolean queueActive () {
        wait.until(ExpectedConditions.visibilityOf(currentQueue));
        return currentQueue.isDisplayed();
    }
}
