import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework23 extends BaseTest {

    String newNameForPlaylist = "test";
    @Test
    public void renameTestPlaylist() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"test.\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com")
                 .providePasswordToLogin("te$t$tudent")
                 .clickSubmitBtn();
        Thread.sleep(2000);
        homePage.doubleClickOnSelectedPlaylist();
        Thread.sleep(2000);
        homePage.enterNewNameForPlaylist();
        Thread.sleep(2000);
        getRenamedPlaylistSuccessMsg();
        Thread.sleep(2000);
        Assert.assertEquals(getRenamedPlaylistSuccessMsg(),updatedPlaylistMsg);
    }


//    public void doubleClickPlaylist(){
//        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//        actions.doubleClick(playlistElement).perform();
//    }
//    public void enterNewPlaylistName() {
//        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        playlistInputField.sendKeys(newNameForPlaylist);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        playlistInputField.sendKeys(Keys.ENTER);
//    }



    public String getRenamedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
