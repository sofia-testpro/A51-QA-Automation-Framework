import pageObjectModel.AllSongsPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    String newPlaylistName = "Sample Edited Playlist";


    //TESTS START HERE
    @Test
    public void playSong(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());
        //login
        loginPage.provideEmailToLogin("demo@class.com");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitBtn();

        homePage.chooseAllSongsList();

        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();

        //assertions
        Assert.assertTrue(songsPage.isSongPlaying());
    }
    @Test
    public void hoverOverPlayBtn() {
        //login
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("demo@class.com");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitBtn();

        //assertion
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }







//    @Test
//    public void countSongsInPlaylist() throws InterruptedException {
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Thread.sleep(2000);
//        //choose playlist by name
//        choosePlaylistByName("Guadeloupe");
//        Thread.sleep(2000);
//        //display all songs
//        displayAllSongs();
//        Thread.sleep(2000);
//        //assertions
//        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));
//    }
//    public void renamePlaylist() throws InterruptedException {
//
//        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";
//
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        Thread.sleep(2000);
//        doubleClickPlaylist();
//        enterNewPlaylistName();
//        Assert.assertEquals(getRenamedPlaylistSuccessMsg(), updatedPlaylistMsg);
//    }

    //    @Test
//    public void hoverOverPlayButton() {
//        //login
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        //assertion
//        Assert.assertTrue(hoverPlay().isDisplayed());
//    }

    //    @Test
//    public void playSongWithContextClick(){
//        //login procedural programming
//        provideEmail("demo@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        //choose all song list
//        chooseAllSongsList();
//        //right/context click
//        contextClickFirstSong();
//        //choose play
//        choosePlayOption();
//        //assertions
//        Assert.assertTrue(isSongPlaying());
//    }

    //TESTS END HERE



    //HELPER METHODS START HERE
//    public void doubleClickPlaylist(){
//        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist;nth-child(3)")));
//        actions.doubleClick(playlistElement).perform();
//    }
//    public void enterNewPlaylistName() {
//        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
//        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
//        playlistInputField.sendKeys(newPlaylistName);
//        playlistInputField.sendKeys(Keys.ENTER);
//    }
//    public String getRenamedPlaylistSuccessMsg(){
//        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
//        return notification.getText();
//    }
//
//    public void choosePlaylistByName(String playlistName){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"']"))).click();
//    }
//    public int countSongs(){
//        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
//    }
//    public String getPlaylistDetails(){
//        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
//    }
//    public void displayAllSongs(){
//        List<WebElement> songlist = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
//        System.out.println("Number of songs found:"+ countSongs());
//        for (WebElement e: songlist){
//            System.out.println(e.getText());
//        }
//    }
//    public WebElement hoverPlay() {
//        WebElement play= driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//       // WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
//        actions.moveToElement(play).perform();
//        return wait.until(ExpectedConditions.visibilityOf(play));
//    }
//    public void chooseAllSongsList(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
//    }
//    public void contextClickFirstSong(){
//       WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
//       actions.contextClick(firstSongElement).perform();
//    }
//    public void choosePlayOption(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback"))).click();
//    }
//    public boolean isSongPlaying(){
//        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='sound-bar-play']")));
//        return soundBarVisualizer.isDisplayed();
//    }

    // HELPER METHODS END HERE
}
