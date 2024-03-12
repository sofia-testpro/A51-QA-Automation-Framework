package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage {
    public AllSongsPage(WebDriver givenDriver){
        super(givenDriver);
    }
    @FindBy(css = "section#songsWrapper h1")
    WebElement allSongsPageHeader;
    @FindBy(css = "a.home")
    WebElement homePage;
    @FindBy (css = "div.bars")
    WebElement soundBars;
    @FindBy (css = ".all-songs tr.song-item:nth-child(1)")
    WebElement fistSongInTheList;
    @FindBy (css = "li.playback")
    WebElement contextPlay;
    @FindBy (xpath = "//section[@id='songsWrapper']//tr[1]//button/i")
    WebElement likeBtnFirstSong;
    @FindBy (css = ".has-sub")
    WebElement addSongToOption;
    @FindBy (css = "#songsWrapper .fa-random")
    WebElement shuffleBtn;
    @FindBy (css = ".menu.song-menu .playlist")
    WebElement selectPlaylist;

    public boolean allSongsPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(allSongsPageHeader));
        return allSongsPageHeader.isDisplayed();
    }
    public void contextClickFirstSong(){
        wait.until(ExpectedConditions.visibilityOf(fistSongInTheList));
        actions.moveToElement(fistSongInTheList).contextClick().perform();
    }
    public void doubleClickSong(){
        wait.until(ExpectedConditions.visibilityOf(fistSongInTheList));
        actions.moveToElement(fistSongInTheList).doubleClick().perform();
    }
    public void choosePlayOption(){
        wait.until(ExpectedConditions.visibilityOf(contextPlay));
        actions.moveToElement(contextPlay).click().perform();
    }
    public boolean isSongPlaying(){
        wait.until(ExpectedConditions.visibilityOf(soundBars));
        return soundBars.isDisplayed();
    }
    public void navigateToHomepage(){
        wait.until(ExpectedConditions.elementToBeClickable(homePage));
        actions.moveToElement(homePage).click().perform();
    }
    public void likeASong() {
        wait.until(ExpectedConditions.elementToBeClickable(likeBtnFirstSong)).click();
    }
    public void addSongTo() {
        wait.until(ExpectedConditions.visibilityOf(addSongToOption));
        actions.moveToElement(addSongToOption).perform();
    }
    public void addSongToPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(selectPlaylist));
        actions.moveToElement(selectPlaylist).click().perform();
    }


    public void clickShuffleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleBtn));
        actions.moveToElement(shuffleBtn).click().perform();
    }
}
