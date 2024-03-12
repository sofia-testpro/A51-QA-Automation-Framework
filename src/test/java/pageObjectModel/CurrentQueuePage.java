package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CurrentQueuePage extends BasePage {
    public CurrentQueuePage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (css = "section#queueWrapper h1")
    WebElement currentQueuePageHeader;
    @FindBy (xpath = "//section[@id='queueWrapper']//tr[@class='song-item playing']")
    WebElement currentlyPlayingSong;
    @FindBy (css = "[data-test='list-meta']")
    WebElement durationAndCountOfSongs;
    @FindBy (css = "#queueWrapper .fa-random")
    WebElement shuffleBtn;
    @FindBy (xpath = "//section[@id='queueWrapper']//table[@class='items']//tr[1]//td[@class='title']")
    WebElement playingSongName;
    @FindBy (css = ".btn-clear-queue")
    WebElement clearBtn;
    @FindBy (css = "section#queueWrapper .text")
    WebElement emptyQueueMessage;
    @FindBy (xpath = "//section[@id='queueWrapper']//a[@class='start']")
    WebElement shuffleAllSongsBtn;
    @FindBy (css = "div.bars")
    WebElement soundBars;
    @FindAll({
            @FindBy (css = "td.artist"),
            @FindBy (css = "td.title"),
            @FindBy (css = "td.album"),
            @FindBy (css = "td.time.text-secondary")
    })
    private List<WebElement> columns;



    public boolean currentQueuePageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(currentQueuePageHeader));
        return currentQueuePageHeader.isDisplayed();
    }
    public boolean currentlyPlaylistSongDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(currentlyPlayingSong));
        return currentlyPlayingSong.isDisplayed();
    }
    public boolean durationAndCountDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(durationAndCountOfSongs));
        return durationAndCountOfSongs.isDisplayed();
    }
    public void clickShuffleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleBtn)).click();
    }
    public WebElement getPlayingSongName() {
        return playingSongName;
    }
    public void clickClearBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(clearBtn)).click();
    }
    public WebElement getEmptyQueueMessage() {
        return emptyQueueMessage;
    }
    public void clickShuffleAllSongsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(shuffleAllSongsBtn)).click();
    }
    public boolean isSongPlaying() {
        wait.until(ExpectedConditions.visibilityOf(soundBars));
        return soundBars.isDisplayed();
    }
    public boolean songInfoDisplayed() {
        for (WebElement info: columns) {
            return (!info.getText().isEmpty());
        } return false;
    }

}
