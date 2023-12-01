package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy (css = "a.view-profile>span")
    WebElement profileName;


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
        wait.until(ExpectedConditions.visibilityOf(profileBtn)).click();
    }

    public WebElement getProfileName(){
        return findElement(profileName);
    }

    public String getRenamedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
