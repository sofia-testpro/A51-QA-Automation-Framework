package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    String newNameForPlaylist = "test";

    //LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = "href=['#!/playlist/76749']")
    WebElement selectPlaylist;
    @FindBy(css = "[name='name']")
    WebElement newPlaylistNameField;
    @FindBy(css="img.avatar")
    WebElement userAvatar;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Helpers
    public void doubleClickOnSelectedPlaylist() {
        WebElement selectPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("href=['#!/playlist/76749']")));
        doubleClick(selectPlaylist);
    }
    public HomePage enterNewNameForPlaylist(String playlistName){
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement getUserAvatar() {
        return findElement(userAvatar);
    }

    public String getPlaylistName () {
        return findElement(selectPlaylist).getText();
    }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        // WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
