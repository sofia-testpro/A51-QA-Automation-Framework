import com.fasterxml.jackson.databind.ser.Serializers;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.ArtistsPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class ArtistsTests extends BaseTest {
    //Acceptance Criteria:
    //
    //User should be able to see artists in app
    //User should be able to find artists using search field
    //User should be able to play a song of selected artist
    //Artists should be displayed correctly in DB

    @Test
    public void testArtistsDisplayed() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ArtistsPage artistsPage = new ArtistsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickArtists();

        Assert.assertTrue(artistsPage.isArtistsListDisplayed());
    }
    @Test
    public void testSelectedArtistPlaying() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ArtistsPage artistsPage = new ArtistsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.clickArtists();

        artistsPage.playArtist();

        Assert.assertTrue(artistsPage.isSoundBarVisible());
    }
}
