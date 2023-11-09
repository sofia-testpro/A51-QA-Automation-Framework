package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    String newNameForPlaylist = "test";

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = "[.playlist:nth-child(3)]")
    WebElement selectPlaylist;
    @FindBy(css = "[name='name']")
    WebElement newPlaylistNameField;

    //Helpers
    public void doubleClickOnSelectedPlaylist() {
        actions.doubleClick(selectPlaylist).perform();
    }
    public HomePage enterNewNameForPlaylist(){
        newPlaylistNameField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        newPlaylistNameField.sendKeys(newNameForPlaylist);
        newPlaylistNameField.sendKeys(Keys.ENTER);
        return this;
    }



    //locators
    private By userAvatarIcon = By.cssSelector("img.avatar");


    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public void chooseAllSongsList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    public WebElement hoverPlay() {
        WebElement play= driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        // WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        actions.moveToElement(play).perform();
        return wait.until(ExpectedConditions.visibilityOf(play));
    }
}
