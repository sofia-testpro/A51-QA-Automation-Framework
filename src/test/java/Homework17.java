import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {
    @Test
    public void addSongToPlaylist() throws InterruptedException {
        String expectedNotification = "Added 1 song into \"dream playlist.\"";
        navigateToLoginPage();
        provideEmail("lolitamantsiuk@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        searchForASong("night");
        clickViewAllBtn();
        chooseFirstSong();
        addTo();
        choosePlaylist();
        Assert.assertEquals(notificationSuccess(), expectedNotification);
    }

    public void searchForASong(String name) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys(name);
        Thread.sleep(2000);
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void chooseFirstSong() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//td[1]"));
        firstSong.click();
        Thread.sleep(2000);
    }

    public void addTo() throws InterruptedException {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[data-test='add-to-btn']"));
        addToBtn.click();
        Thread.sleep(2000);
    }

    public void choosePlaylist() throws InterruptedException {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'dream playlist')]"));
        playlist.click();
        Thread.sleep(2000);
    }

    public String notificationSuccess() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }



}
