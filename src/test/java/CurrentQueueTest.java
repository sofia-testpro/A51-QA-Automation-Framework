import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.*;

public class CurrentQueueTest extends BaseTest {
    //1.Current Queue page should display currently played songs by a user in the app
    @Test
    public void currentlyPlayingSongDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        homePage.clickCurrentQueuePage();

        Assert.assertTrue(currentQueuePage.currentlyPlaylistSongDisplayed());
    }

    //2.The total count of songs should be displayed + 3.The total duration count of all songs should be displayed
    @Test
    public void totalCountAndDurationOfSongsDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        homePage.clickCurrentQueuePage();

        Assert.assertTrue(currentQueuePage.durationAndCountDisplayed());
}
    //4.ID, Title, Artist, Album, and Time should be correctly displayed
    @Test
    public void isSongInfoDisplayed() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        homePage.clickCurrentQueuePage();

        Assert.assertTrue(currentQueuePage.songInfoDisplayed());
    }

    //5.1 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    @Test
    public void toCurrentQueueFromHome() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.doubleClickSong();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //5.2 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    //Double click on a song doesnt work in here, but a shuffle button does
    @Test
    public void toCurrentQueueFromAllSongs() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.clickShuffleBtn();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //5.3 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    @Test
    public void toCurrentQueueFromAlbums() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AlbumsPage albumsPage = new AlbumsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAlbumsPage();
        albumsPage.doubleClickAlbum();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //5.4 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    @Test
    public void toCurrentQueueFromArtists() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
       ArtistsPage artistsPage = new ArtistsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickArtistsPage();
        artistsPage.doubleClickArtist();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //5.5 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    //Double click on a song doesnt work in here, but a shuffle button does
    @Test
    public void toCurrentQueueFromFavorites() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        FavoritesPage favoritesPage = new FavoritesPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.likeASong();
        homePage.clickFavoritesPlaylist();
        favoritesPage.clickShuffleBtn();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //5.5 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    //Double click on a song doesnt work in here, but a shuffle button does
    @Test
    public void toCurrentQueueFromRecentlyPlayed() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        RecentlyPlayedPage recentlyPlayedPage = new RecentlyPlayedPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        homePage.clickRecentlyPlayedPlaylist();
        recentlyPlayedPage.clickShuffleBtn();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }
    //5.5 User should be navigated to the Current Queue page after double clicking on the song on the following pages: Home, All songs, Albums, Artists, Favorites, Recently played, and user's created playlist
    //Double click on a song doesnt work in here, but a shuffle button does
    @Test
    public void toCurrentQueueFromCreatedPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        PlaylistPage playlistPage = new PlaylistPage(getThreadLocal());

        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.contextClickFirstSong();
        allSongsPage.addSongTo();
        allSongsPage.addSongToPlaylist();
        homePage.clickCreatedPlaylist();
        playlistPage.clickShuffleBtn();

        Assert.assertTrue(currentQueuePage.currentQueuePageDisplayed());
    }

    //6.'Shuffle All' button should shuffle songs
    @Test
    public void shuffleSongs() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.clickShuffleBtn();
        currentQueuePage.clickShuffleBtn();
        String name = currentQueuePage.getPlayingSongName().getText();
        currentQueuePage.clickShuffleBtn();
        String name2 = currentQueuePage.getPlayingSongName().getText();

        Assert.assertNotEquals(name,name2);
    }

    //7.The page should be empty after clicking on 'Clear' button. 'No songs queued. How about shuffling all songs?' message should appear.
    @Test
    public void clearCurrentQueue() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage allSongsPage = new AllSongsPage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickAllSongsPage();
        allSongsPage.clickShuffleBtn();
        currentQueuePage.clickClearBtn();
        String message = "No songs queued. " + "\r\n" + "How about shuffling all songs?";

        System.out.println("Expected message: " + message + " real message: " + currentQueuePage.getEmptyQueueMessage().getText());

        Assert.assertEquals(message, currentQueuePage.getEmptyQueueMessage().getText(), message);
    }

    //8.Songs should appear on the Current Queue page when clicking on the 'shuffling all songs'
    @Test
    public void songsAppearShuffleAllSongsBtn() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        CurrentQueuePage currentQueuePage = new CurrentQueuePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickCurrentQueuePage();
        currentQueuePage.clickShuffleAllSongsButton();

        Assert.assertTrue(currentQueuePage.isSongPlaying());
    }

}
