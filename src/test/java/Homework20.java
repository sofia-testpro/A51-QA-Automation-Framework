import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String notification = "Deleted playlist \"test.\"";

        provideEmail("lolitamantsiuk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        choosePlaylist();
        XPlaylist();
//        confirmDelete();
        Assert.assertEquals(notificationPlaylistDeleted(), notification);
    }
    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[@href='#!/playlist/75061']")));
        playlist.click();
    }
    public void XPlaylist() throws InterruptedException {
        WebElement XPlaylistBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='del btn-delete-playlist']")));
        XPlaylistBtn.click();
    }
//        public void confirmDelete() throws InterruptedException{
//        WebElement okBtn = driver.findElement(By.cssSelector("button[class='ok']"));
//        okBtn.click();
//        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//    }
    public String notificationPlaylistDeleted() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}
