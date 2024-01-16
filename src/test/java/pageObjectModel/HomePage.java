package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement selectPlaylist;
    @FindBy(css = "[name='name']")
    WebElement newPlaylistNameField;
    @FindBy(css="img[class='avatar']")
    WebElement userAvatarIcon;
    @FindBy(css = "a.view-profile")
    WebElement profileBtn;
    @FindBy (css = "span[class='name']")
    WebElement profileName;
    @FindBy (css = "a.logout.control")
    WebElement logOutBtn;
    @FindBy (css = "ol[class='recent-song-list']")
    WebElement recentlyPlayedSongs;
    @FindBy (css = "button[data-testid='home-view-all-recently-played-btn']")
    WebElement viewAllBtn;
    @FindBy (xpath = "//section//h1[text()='Recently Added']")
    WebElement recentlyAddedList;
    @FindBy (xpath = "//section//ol//div//a[text() = 'Dark Days EP']")
    WebElement albumNameRecentlyAdded;
    @FindBy (css = "input[type='search']")
    WebElement searchField;
    @FindBy (css = "i[title='Create a new playlist']")
    WebElement createPlaylistBtn;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylistBtn;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-smart']")
    WebElement newSmartPlaylistBtn;
    @FindBy (css = "input[id='inputProfileNewPassword']")
    WebElement newPasswordField;
    @FindBy (css = "button[title='About Koel']")
    WebElement aboutKoelBtn;
    @FindBy (css ="p[class='current-version']")
    WebElement currentKoelVersion;



    //Helpers
    public void doubleClickOnSelectedPlaylist() {
      doubleClick(selectPlaylist);
    }
    public void enterNewPlaylistName (String playlistName){
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);
    }

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    public WebElement hoverPlay() {
        WebElement play= driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }

    public void clickProfile () {
        wait.until(ExpectedConditions.elementToBeClickable(profileBtn)).click();
    }

    public WebElement getProfileName(){
        return findElement(profileName);
    }

    public String getRenamedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
    public void logOut(){
        findElement(logOutBtn).click();
    }

    public WebElement getRecentlyPlayedSongs(){
        return findElement(recentlyPlayedSongs);
    }
    public WebElement getViewAllBtn(){
        return findElement(viewAllBtn);
    }
    public WebElement getRecentlyAddedList(){
        return findElement(recentlyAddedList);
    }
    public WebElement getAlbumNameRecentlyAdded(){
        return findElement(albumNameRecentlyAdded);
    }
    private final By recentlyAddedColumnItems = By.xpath("//ol[@class=\"recently-added-album-list\"][1]/li");

    public void accessSearchField(){
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
    }

    public WebElement getSearchField(){
        return findElement(searchField);
    }
    public void clickCreatePlaylistBtn(){
        wait.until(ExpectedConditions.visibilityOf(createPlaylistBtn)).click();
    }
    public void doubleClickCreatePlaylistBtn(){
        wait.until(ExpectedConditions.visibilityOf(createPlaylistBtn));
        doubleClick(createPlaylistBtn);
    }
    public void clickCreateNewPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(newPlaylistBtn)).click();
    }
    public void clickCreateNewSmartPlaylist(){
        wait.until(ExpectedConditions.visibilityOf(newSmartPlaylistBtn)).click();
    }
    public WebElement getCreatePlaylistBtn(){
        return findElement(createPlaylistBtn);
    }
    public WebElement getNewPasswordField(){
        return findElement(newPasswordField);
    }
    public void clickAboutKoelBtn(){
        wait.until(ExpectedConditions.visibilityOf(aboutKoelBtn)).click();
    }
    public WebElement getCurrentKoelVersion(){
        return findElement(currentKoelVersion);
    }









    }



