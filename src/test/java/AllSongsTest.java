import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.AllSongsPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class AllSongsTest extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.chooseAllSongsList();

        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();

        Assert.assertTrue(songsPage.isSongPlaying());
    }
}
