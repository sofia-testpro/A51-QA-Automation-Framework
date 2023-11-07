import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest {
    String newPlaylistName = "test";
    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"test.\"";

        provideEmail("lolitamantsiuk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        doubleClickPlaylist();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        enterNewPlaylistName();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(getRenamedPlaylistSuccessMsg(), updatedPlaylistMsg);
    }
    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }
    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        playlistInputField.sendKeys(newPlaylistName);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public String getRenamedPlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
