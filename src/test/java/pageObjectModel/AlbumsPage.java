package pageObjectModel;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlbumsPage extends BasePage {
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "section#albumsWrapper")
    WebElement albumsPageHeader;
    @FindBy(xpath = "//section[@id='albumsWrapper']//article[1]//span//span//a[@role='button']")
    WebElement firstAlbumInTheList;
    public boolean albumsPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(albumsPageHeader));
        return albumsPageHeader.isDisplayed();
    }
    public void doubleClickAlbum(){
        wait.until(ExpectedConditions.elementToBeClickable(firstAlbumInTheList));
        actions.moveToElement(firstAlbumInTheList).doubleClick().perform();
    }
}
