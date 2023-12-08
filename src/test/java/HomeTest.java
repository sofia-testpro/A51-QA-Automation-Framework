import pageObjectModel.AllSongsPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        homePage.chooseAllSongsList();

        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();

        Assert.assertTrue(songsPage.isSongPlaying());
    }

    @Test
    public void hoverOverPlayBtn() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }

}