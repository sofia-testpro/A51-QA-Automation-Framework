package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavoritesPage extends BasePage {
    public FavoritesPage (WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy (xpath = "//section[@id='favoritesWrapper']//h1[1]")
    WebElement favoritesPlaylistHeader;
    @FindBy (css = "#favoritesWrapper .btn-shuffle-all")
    WebElement shuffleButton;

    public boolean favoritesPlaylistDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(favoritesPlaylistHeader));
        return favoritesPlaylistHeader.isDisplayed();
    }
    public void clickShuffleBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(shuffleButton));
        actions.moveToElement(shuffleButton).click().perform();
    }



}
