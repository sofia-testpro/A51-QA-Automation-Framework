import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String notification = "Deleted playlist \"firstplaylist.\"";

        provideEmail("lolitamantsiuk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        choosePlaylist();
        XPlaylist();
//        confirmDelete();
        Assert.assertEquals(notificationPlaylistDeleted(), notification);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[@href='#!/playlist/74360']"));
        playlist.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void XPlaylist() throws InterruptedException {
        WebElement XPlaylistBtn = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        XPlaylistBtn.click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public void confirmDelete() throws InterruptedException{
        WebElement okBtn = driver.findElement(By.cssSelector("button[class='ok']"));
        okBtn.click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public String notificationPlaylistDeleted() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}
