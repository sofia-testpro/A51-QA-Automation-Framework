package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    public SearchPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "input[type='search']")
    WebElement searchField;
    @FindBy (xpath = "//section[@class='songs']//span[@class='details']")
    WebElement songDetailContainer;
    @FindBy(css = ".results .artists .name")
    WebElement nameArtist;
    @FindBy(css = ".results .albums .name")
    WebElement nameAlbum;


    public SearchPage searchSend (String songName) {
        findElement(searchField).sendKeys(songName);
        return this;
    }
    public boolean verifyMatchingSongResults (String songName) {
        findElement(songDetailContainer);
        return songDetailContainer.getText().contains(songName);
    }
    public String getArtistName() {
        findElement(nameArtist);
        return nameArtist.getText();
    }
    public String getAlbumName(){
        findElement(nameAlbum);
        return nameAlbum.getText();
    }


}
