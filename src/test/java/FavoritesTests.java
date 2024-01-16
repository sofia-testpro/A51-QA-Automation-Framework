import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.SearchPage;

public class FavoritesTests extends BaseTest {

    //Story:
    //
    //As a user I want to be able to save songs to my Favorites Playlist.
    //
    //Acceptance Criteria:
    //
    //Favorites playlist page should contain all songs saved as a favorite by the user
    //If no songs are marked as a favorite, the playlist page should be empty
    //User should be able to delete songs from the Favorites playlist page
    //User should be able to download songs from the Favorites playlist page

    @Test
    public void testFavoriteSongsAreOnFavoritesPage(){

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SearchPage searchPage = new SearchPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.chooseAllSongsList();

    }
}
