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

public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = ".playlist:nth-child(3)")
    WebElement selectPlaylist;
    @FindBy (css = "[name='name']")
    WebElement newPlaylistNameField;
    @FindBy (css = "img[class='avatar']")
    WebElement userAvatarIcon;
    @FindBy (css = "a.view-profile")
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
    @FindBy (css = ".fa-plus-circle")
    WebElement createPlaylistBtn;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy (xpath = "//section[@id='playlists']/form[@name='create-simple-playlist-form']")
    WebElement newSimplePlaylistForm;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-smart']")
    WebElement newSmartPlaylist;
    @FindBy (css = ".smart-playlist-form  form")
    WebElement newSmartPlaylistForm;
    @FindBy (css = "input[id='inputProfileNewPassword']")
    WebElement newPasswordField;
    @FindBy (css = "button[title='About Koel']")
    WebElement aboutKoelBtn;
    @FindBy (css = "p[class='current-version']")
    WebElement currentKoelVersion;
    @FindBy (xpath = "//section[@id='homeWrapper']/div/section[1]//ol[@class='recently-added-album-list']/li[1]")
    WebElement recentlyAddedSong;
    @FindBy (xpath = "//ol[@class='recently-added-album-list']//li[1]//p[@class='meta']//span[@class='right']//a[@class='shuffle-album']")
    WebElement shuffleBtnRecentlyAddedSong;
    @FindBy (xpath = "//ol[@class='recently-added-album-list']//li[1]//p[@class='meta']//span[@class='right']//a[@class='download-album']")
    WebElement downloadBtnRecentlyAddedSong;
    @FindBy (css = "ul.menu")
    WebElement musicPanel;
    @FindBy (css = "a.home.active")
    WebElement homePage;
    @FindBy (css = "a.queue")
    WebElement currentQueuePage;
    @FindBy (css = "a.albums")
    WebElement albumsPage;
    @FindBy (css = ".menu .artists")
    WebElement artistsPage;
    @FindBy (css = "a.songs")
    WebElement allSongsPage;
    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist favorites']")
    WebElement favoritesPlaylist;
    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist recently-played']")
    WebElement recentlyPlayedPlaylist;
    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist playlist']")
    WebElement createdPlaylist;
    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist playlist smart']")
    WebElement createdSmartPlaylist;
    @FindBy (css = "html.with-extra-panel")
    WebElement themeStyle;



    public void doubleClickOnSelectedPlaylist() {
        doubleClick(selectPlaylist);
    }
    public void enterNewPlaylistName(String playlistName) {
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);
    }
    public WebElement getUserAvatar() {
        wait.until(ExpectedConditions.elementToBeClickable(userAvatarIcon));
        return userAvatarIcon;
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
    public void clickProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profileBtn)).click();
    }
    public WebElement getProfileName() {
        return findElement(profileName);
    }
    public String getRenamedPlaylistSuccessMsg() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
    public void logOut() {
        wait.until(ExpectedConditions.visibilityOf(logOutBtn)).click();
    }
    public WebElement getRecentlyPlayedSongs() {
        return findElement(recentlyPlayedSongs);
    }
    public WebElement getViewAllBtn() {
        return findElement(viewAllBtn);
    }
    public WebElement getRecentlyAddedList() {
        return findElement(recentlyAddedList);
    }
    public WebElement getAlbumNameRecentlyAdded() {
        return findElement(albumNameRecentlyAdded);
    }
    public void accessSearchField() {
        wait.until(ExpectedConditions.visibilityOf(searchField)).click();
    }
    public WebElement getSearchField() {
        return findElement(searchField);
    }
    public void clickCreatePlaylistBtn() {
        wait.until(ExpectedConditions.elementToBeSelected(createPlaylistBtn));
        createPlaylistBtn.click();
    }
    public void createNewPlaylistOption() {
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
        actions.moveToElement(newPlaylist).click().perform();
    }
    public boolean newPlaylistOptionValid() {
        wait.until(ExpectedConditions.visibilityOf(newSimplePlaylistForm));
        return newSimplePlaylistForm.isDisplayed();
    }
    public void createNewSmartPlaylistOption() {
        wait.until(ExpectedConditions.elementToBeClickable(newSmartPlaylist)).click();
    }
    public boolean newSmartPlaylistOptionValid() {
        wait.until(ExpectedConditions.visibilityOf(newSmartPlaylistForm));
        return newSmartPlaylistForm.isDisplayed();
    }
    public WebElement getNewPasswordField() {
        return findElement(newPasswordField);
    }
    public void clickAboutKoelBtn() {
        wait.until(ExpectedConditions.visibilityOf(aboutKoelBtn)).click();
    }
    public WebElement getCurrentKoelVersion() {
        return findElement(currentKoelVersion);
    }
    public boolean isShuffleBtnVisible() {
        wait.until(ExpectedConditions.visibilityOf(recentlyAddedSong));
        actions.moveToElement(recentlyAddedSong).perform();
        wait.until(ExpectedConditions.visibilityOf(shuffleBtnRecentlyAddedSong));
        return shuffleBtnRecentlyAddedSong.isDisplayed();
    }
    public boolean isDownloadBtnVisible() {
        wait.until(ExpectedConditions.visibilityOf(recentlyAddedSong));
        actions.moveToElement(recentlyAddedSong).perform();
        wait.until(ExpectedConditions.visibilityOf(downloadBtnRecentlyAddedSong));
        return downloadBtnRecentlyAddedSong.isDisplayed();
    }
    public void homePageClick() {
        wait.until(ExpectedConditions.visibilityOf(homePage)).click();
    }
    public void clickCurrentQueuePage() {
        wait.until(ExpectedConditions.visibilityOf(currentQueuePage)).click();
    }
    public void clickAllSongsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(allSongsPage)).click();
    }
    public void clickAlbumsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(albumsPage)).click();
    }
    public void clickArtistsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(artistsPage)).click();
    }
    public void clickFavoritesPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(favoritesPlaylist)).click();
    }
    public void clickRecentlyPlayedPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(recentlyPlayedPlaylist)).click();
    }
    public void clickCreatedPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(createdPlaylist)).click();
    }
    public void clickCreatedSmartPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(createdSmartPlaylist)).click();
    }
    public void doubleClickSong(){
        wait.until(ExpectedConditions.elementToBeClickable(recentlyAddedSong));
        actions.moveToElement(recentlyAddedSong).doubleClick().perform();
    }
    public WebElement getThemeName() {
        return themeStyle;
    }
}


