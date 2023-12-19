import com.fasterxml.jackson.databind.ser.Serializers;
import net.bytebuddy.build.ToStringPlugin;
import pageObjectModel.AllSongsPage;
import pageObjectModel.BasePage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    //1.
    @Test
    public void newUserVerificationLogIn (){

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();
        String name = "student";

        basePage.isTextPresentInElement(homePage.getProfileName(), name);
        Assert.assertEquals(homePage.getProfileName().getText(), name);
    }

    //2.
    @Test
    public void recentlyPlayedSongs () {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        homePage.chooseAllSongsList();

        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();

        songsPage.navigateToHomepage();

        Assert.assertTrue(homePage.getRecentlyPlayedSongs().isDisplayed());
    }

    //3.
    @Test
    public void viewAllBtnIsDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getViewAllBtn().isDisplayed());
    }

    //4.
    @Test
    public void recentlyAddedSongsDisplayed(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getRecentlyAddedList().isDisplayed());
    }

    //5.
    @Test
    public void albumNameForRecentlyAddedSongs(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        AllSongsPage songsPage = new AllSongsPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getAlbumNameRecentlyAdded().isDisplayed());
    }

//    6.
//    @Test
//    public void downloadShuffleIconsAreDisplayedForRAS(){
//    }

//    7.
    @Test
    public void searchFieldAccessibleFromHomepage(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();
        homePage.accessSearchField();

        Assert.assertTrue(homePage.getSearchField().isDisplayed());
    }

    //8.
//    @Test
//    public void musicPanelIncludesAllPages() {
//    }

    //9.
//    @Test
//    public void playlistCreationBtn(){
//    }

    //10.
//    @Test
//    public void playlistPanelIncludesPages(){
//    }

    //11.1
    @Test
    public void profileLinkTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        homePage.clickProfile();

        Assert.assertTrue(homePage.getNewPasswordField().isDisplayed());
    }

    //11.2
    @Test
    public void logOutTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        homePage.logOut();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    //11.3
    @Test
    public void aboutKoelTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        homePage.clickAboutKoelBtn();

        Assert.assertTrue(homePage.getCurrentKoelVersion().isDisplayed());
    }






    @Test
    public void hoverOverPlayBtn() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }



}