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
    @FindBy(xpath = "//li[@class='playlist playlist']//a")
    WebElement selectPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement newPlaylistNameField;
    @FindBy(css="img.avatar")
    WebElement userAvatar;
    @FindBy(css = "div.success.show")
    WebElement nameMessage;

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Helpers
    public void doubleClickOnSelectedPlaylist() {
        doubleClick(selectPlaylist);
    }

    public HomePage enterNewNameForPlaylist(String playlistName) {
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(newPlaylistNameField).sendKeys(playlistName);
        findElement(newPlaylistNameField).sendKeys(Keys.ENTER);
        return this;
    }

    public String getRenamePlaylistSuccessMsg(){
        return findElement(nameMessage).getText();
    }

//    public String getPlaylistName() {
//            return findElement(selectPlaylist).getText();
//        }
//
//    public void chooseAllSongsList(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
//    }
//    public WebElement hoverPlay() {
//        WebElement play= driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//        actions.moveToElement(play).perform();
//        return wait.until(ExpectedConditions.visibilityOf(play));
//    }
}
