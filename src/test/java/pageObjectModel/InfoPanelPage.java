package pageObjectModel;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InfoPanelPage extends BasePage {
    public InfoPanelPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (xpath = "//footer[@id='mainFooter']//button[@title='View song information']")
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
    @FindBy (xpath = "//div[@id='extraPanelArtist']/article[@class='artist-info sidebar']//i[@class='fa fa-random']")
    WebElement shuffleButtonArtist;
    @FindBy (xpath = "//div[@id='extraPanelAlbum']/article[@class='album-info sidebar']//i[@class='fa fa-random']")
    WebElement shuffleButtonAlbum;
    @FindBy (css = "a.queue.active")
    WebElement currentQueue;

    public void clickInfoButton () {
        wait.until(ExpectedConditions.visibilityOf(infoButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",infoButton);
    }
    public Boolean infoPanelOpen () {
        wait.until(ExpectedConditions.visibilityOf(infoPanel));
        return true;
    }
    public Boolean infoPanelClosed () {
        wait.until(ExpectedConditions.invisibilityOf(infoPanel));
        return true;
    }

        public boolean infoPanelNotDisplayed() {
        // Utilizes the waitForElementToBeNotVisible method to check if the user avatar icon is not visible
        return waitForElementToBeNotVisible(infoPanel);
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
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButtonArtist));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",shuffleButtonArtist);
    }
    public void shuffleSongsAlbum () {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButtonAlbum));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",shuffleButtonAlbum);
    }
    public Boolean queueActive () {
        wait.until(ExpectedConditions.visibilityOf(currentQueue));
        return currentQueue.isDisplayed();
    }
}
