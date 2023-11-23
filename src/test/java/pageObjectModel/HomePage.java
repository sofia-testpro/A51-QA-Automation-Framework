package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    String newNameForPlaylist = "test";

    //LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement selectPlaylist;
    @FindBy(css = "[name='name']")
    WebElement newPlaylistNameField;
    @FindBy(css="img.avatar")
    WebElement userAvatar;

    @FindBy(css = "playlist playlist")
    WebElement playlist;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Helpers
    public void doubleClickOnSelectedPlaylist() {
        findElement(selectPlaylist);
        doubleClick(selectPlaylist);
    }

    public HomePage enterNewNameForPlaylist(String playlistName) {
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public void enterNewPlaylistName (String playlistName) {
//        newPlaylistNameField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
//        newPlaylistNameField.sendKeys(newNamePlaylist);
//        newPlaylistNameField.sendKeys(Keys.ENTER);
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);

    }
    public WebElement getUserAvatar() {
        return findElement(userAvatar);
    }

    public String getPlaylistName() {
            return findElement(selectPlaylist).getText();
        }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public WebElement hoverPlay() {
        WebElement play= driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
