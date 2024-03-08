import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.AllSongsPage;
import pageObjectModel.HomePage;
import pageObjectModel.InfoPanelPage;
import pageObjectModel.LoginPage;

public class InfoPanelTests extends BaseTest {
    @Test
    public void openInfoPanel() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();

        Assert.assertTrue(infoPanelPage.infoPanelOpen());
    }
    @Test
    public void closeInfoPanel() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();

        infoPanelPage.clickInfoButton();

        Assert.assertTrue(infoPanelPage.infoPanelNotDisplayed());
    }
    @Test
    public void lyricsForPlayingSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();
        homePage.clickAllSongsPage();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        infoPanelPage.clickLyricsTab();

        Assert.assertTrue(infoPanelPage.lyricsDisplayed());
    }
    @Test
    public void artisNameForPlayingSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();
        homePage.clickAllSongsPage();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        infoPanelPage.clickArtistTab();

        Assert.assertTrue(infoPanelPage.artistNameDisplayed());
    }
    @Test
    public void albumForPlayingSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();
        homePage.clickAllSongsPage();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        infoPanelPage.clickAlbumTab();

        Assert.assertTrue(infoPanelPage.albumDisplayed());
    }
    @Test
    public void shuffleSongsByPlayingArtist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();
        homePage.clickAllSongsPage();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        infoPanelPage.clickArtistTab();
        infoPanelPage.shuffleSongsArtist();

        Assert.assertTrue(infoPanelPage.queueActive());
    }
    @Test
    public void shuffleSongsByPlayingAlbum() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        InfoPanelPage infoPanelPage = new InfoPanelPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        infoPanelPage.clickInfoButton();
        homePage.clickAllSongsPage();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        infoPanelPage.clickAlbumTab();
        infoPanelPage.shuffleSongsAlbum();

        Assert.assertTrue(infoPanelPage.queueActive());
    }
}
