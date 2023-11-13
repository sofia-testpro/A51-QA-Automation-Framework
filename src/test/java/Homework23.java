import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

import java.time.Duration;

public class Homework23 extends BaseTest {

    String newNameForPlaylist = "test";
    @Test
    public void renameTestPlaylist(){

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com")
                 .providePasswordToLogin("te$t$tudent")
                 .clickSubmitBtn();

        homePage.doubleClickOnSelectedPlaylist();
        String newNamePlaylist = generateRandomPlaylistName();
        homePage.enterNewPlaylistName(newNamePlaylist);
        String updatedPlaylistMsg = "Updated playlist \"" + newNamePlaylist + ".\"";
        String renamedPlaylistMsd = getRenamedPlaylistSuccessMsg();
        Assert.assertEquals(getRenamedPlaylistSuccessMsg(),updatedPlaylistMsg);
    }

    private String generateRandomPlaylistName(){
        return "Playlist_" + UUID.randomUUID().toString().substring(0,8);
    }
    public String getRenamedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
