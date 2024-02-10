package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ArtistsPage extends BasePage {

    public ArtistsPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "div.artists")
    WebElement artistsList;
    @FindBy (xpath = "//section[@id='artistsWrapper']//article[1]//a[contains(text(),\"Play\")]")
    WebElement playArtistButton;
    @FindBy (css= "img[alt='Sound bars']")
    WebElement soundBars;


    public Boolean isArtistsListDisplayed () {
        return artistsList.isDisplayed();
    }
    public void playArtist () {
        wait.until(ExpectedConditions.elementToBeClickable(playArtistButton)).click();
    }
    public Boolean isSoundBarVisible() {
        wait.until(ExpectedConditions.visibilityOf(soundBars));
        return soundBars.isDisplayed();
    }



}
