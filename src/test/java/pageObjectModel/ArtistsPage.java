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
    @FindBy (css = "section#artistsWrapper h1")
    WebElement artistsPageHeader;
    @FindBy (xpath = "//section[@id='artistsWrapper']//article[1]//span//span//a[@role='button']")
    WebElement firstArtistInTheList;


    public Boolean isArtistsListDisplayed () {
        return artistsList.isDisplayed();
    }
    public void playArtist () {
        wait.until(ExpectedConditions.elementToBeClickable(playArtistButton)).click();
    }
    public Boolean isSoundBarVisible() {
        WebElement soundBar = wait.until(ExpectedConditions.visibilityOf(soundBars));
        return soundBar.isDisplayed();
    }
    public boolean artistsPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(artistsPageHeader));
        return artistsPageHeader.isDisplayed();
    }
    public void doubleClickArtist() {
        wait.until(ExpectedConditions.elementToBeClickable(firstArtistInTheList));
        actions.moveToElement(firstArtistInTheList).doubleClick().perform();
    }
}
