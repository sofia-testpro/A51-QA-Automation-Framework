import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test

    public void playSong() throws InterruptedException {
        navigateToLoginPage();
        provideEmail("lolitamantsiuk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        clickPlayNextSong();
        clickPlaySong();
        WebElement pauseBtn = driver.findElement(By.cssSelector("span[data-testid='pause-btn']"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }

    public void clickPlayNextSong() throws InterruptedException {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        playNextSongBtn.click();
        Thread.sleep(2000);
    }

    public void clickPlaySong() throws InterruptedException {
        WebElement playBtn = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playBtn.click();
        Thread.sleep(2000);
    }
}
