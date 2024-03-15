import com.fasterxml.jackson.databind.ser.Serializers;
import net.bytebuddy.build.ToStringPlugin;
import org.apache.xmlbeans.impl.store.Cur;
import pageObjectModel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    //1.Welcome message for a new user should be the following: 'Hello, Student!'
    @Test
    public void newUserVerificationLogIn (){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        String name = "student";

        basePage.isTextPresentInElement(homePage.getProfileName(), name);
        Assert.assertEquals(homePage.getProfileName().getText(), name);
    }

    //2.Recently played songs should be present if user played at least one song
    @Test
    public void recentlyPlayedSongs () {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.chooseAllSongsList();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        songsPage.navigateToHomepage();

        Assert.assertTrue(homePage.getRecentlyPlayedSongs().isDisplayed());
    }

    //3.'View All' button should be displayed next to Recently played songs
    @Test
    public void viewAllBtnIsDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getViewAllBtn().isDisplayed());
    }

    //4. Recently added songs should be present
    @Test
    public void recentlyAddedSongsDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getRecentlyAddedList().isDisplayed());
    }

    //5.Album name should be displayed for the Recently added songs
    @Test
    public void albumNameForRecentlyAddedSongs(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getAlbumNameRecentlyAdded().isDisplayed());
    }

    //6.1 Shuffle icon should be present for Recently added songs
    @Test
    public void shuffleIconDisplayedForRAS(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.isShuffleBtnVisible();

        Assert.assertTrue(homePage.isShuffleBtnVisible());
    }

    //6.2 Download icon should be present for Recently added songs
    @Test
    public void downloadIconDisplayedForRAS(){
       LoginPage loginPage = new LoginPage(getThreadLocal());
       HomePage homePage = new HomePage(getThreadLocal());

       loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
       loginPage.providePasswordToLogin("Te$tPro123!");
       loginPage.clickSubmitBtn();
       homePage.isDownloadBtnVisible();

       Assert.assertTrue(homePage.isDownloadBtnVisible());
    }

    //7.Search field should be present and user should be able to access Search from the Homepage
    @Test
    public void searchFieldAccessibleFromHomepage(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.accessSearchField();

        Assert.assertTrue(homePage.getSearchField().isDisplayed());
    }

    //8.1 Your music panel should include the following pages: Home, Current Queue, All Songs, Albums, Artists
    @Test
    public void musicPanelIncludesHomePage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.homePageClick();

        Assert.assertTrue(homePage.getRecentlyAddedList().isDisplayed());
    }

    //8.2 Your music panel should include the following pages: Home, Current Queue, All Songs, Albums, Artists
    @Test
    public void musicPanelIncludesCurrentQueuePage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickCurrentQueuePage();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //8.3 Your music panel should include the following pages: Home, Current Queue, All Songs, Albums, Artists
    @Test
    public void musicPanelIncludesAllSongsPage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();

        Assert.assertTrue(allSongsPage.allSongsPageDisplayed());
    }

    //8.4 Your music panel should include the following pages: Home, Current Queue, All Songs, Albums, Artists
    @Test
    public void musicPanelIncludesAlbumsPage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AlbumsPage albumsPage = new AlbumsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAlbumsPage();

        Assert.assertTrue(albumsPage.albumsPageDisplayed());
    }

    //8.5 Your music panel should include the following pages: Home, Current Queue, All Songs, Albums, Artists
    @Test
    public void musicPanelIncludesArtistsPage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ArtistsPage artistsPage = new ArtistsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickArtistsPage();

        Assert.assertTrue(artistsPage.artistsPageDisplayed());
    }

    //9.1 PLAYLISTS panel should include:  button for new playlist creation and new smart playlist
    @Test
    public void playlistCreationBtnNewPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        Thread.sleep(1);
        homePage.clickCreatePlaylistBtn();
        homePage.createNewPlaylistOption();

        Assert.assertTrue(homePage.newPlaylistOptionValid());
    }

    //9.2 PLAYLISTS panel should include:  button for new playlist creation and new smart playlist
    @Test
    public void playlistCreationBtnNewSmartPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        Thread.sleep(1);
        homePage.clickCreatePlaylistBtn();
        homePage.createNewSmartPlaylistOption();

        Assert.assertTrue(homePage.newSmartPlaylistOptionValid());
    }

    //10.1 Playlists panel should include, Favorites playlist, Recently played playlist, smart playlists and user's created playlists
    @Test
    public void playlistPanelFavoritesPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        FavoritesPage favoritesPage = new FavoritesPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickFavoritesPlaylist();

        Assert.assertTrue(favoritesPage.favoritesPlaylistDisplayed());
    }

    //10.2 Playlists panel should include, Favorites playlist, Recently played playlist, smart playlists and user's created playlists
    @Test
    public void playlistPanelRecentlyPlayedPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickRecentlyPlayedPlaylist();

        Assert.assertTrue(recentlyPlayedPage.recentlyPlayedPlaylistDisplayed());
    }

    //10.3 Playlists panel should include, Favorites playlist, Recently played playlist, smart playlists and user's created playlists
    @Test
    public void playlistPanelCreatedPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickCreatedPlaylist();

        Assert.assertTrue(playlistPage.createdPlaylistDisplayed());
    }

    //10.3 Playlists panel should include, Favorites playlist, Recently played playlist, smart playlists and user's created playlists
    @Test
    public void playlistPanelCreatedSmartPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickCreatedSmartPlaylist();

        Assert.assertTrue(smartPlaylistsPage.createdSmartPlaylistDisplayed());
    }

    //11.1Profile link, Logout and About Koel icons should be displayed and linked to correct pages.
    @Test
    public void profileLinkTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.clickProfile();

        Assert.assertTrue(homePage.getNewPasswordField().isDisplayed());
    }

    //11.2
    @Test
    public void logOutTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.logOut();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    //11.3
    @Test
    public void aboutKoelTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        homePage.clickAboutKoelBtn();

        Assert.assertTrue(homePage.getCurrentKoelVersion().isDisplayed());
    }

}