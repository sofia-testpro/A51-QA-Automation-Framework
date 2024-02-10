import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.ArtistsPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.SmartPlaylistsPage;

public class SmartPlaylistTests extends BaseTest {
    //Acceptance Criteria:
    //
    //User should be able to create a Smart playlist in app with one rule
    //User should be able to create a Smart playlist in app with multiple rules
    //User should be able to create a Smart playlist in app with Group
    //After creating Smart playlist with a rule, related songs should appear in created Smart playlist
    //If a rule doesn't fit any existing song, empty Smart playlist should be created, 'No songs match the playlist's criteria' should be displayed
    //User should be able to add songs to the Smart playlist by editing existing rules and group settings
    //User should be able to delete Smart Playlist

    @Test //creating smart playlist with one rule
    public void smartPlaylistCreation1Rule() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test1";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.enterCriteria("dark days");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertEquals(smartPlaylistsPage.smartPlaylistName(), name);
    }

    @Test //creating smart playlist with 2 rules
    public void smartPlaylistCreation2Rules() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test2";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.enterCriteria("dark days");
        smartPlaylistsPage.clickAddRuleButton();
        smartPlaylistsPage.enterSecondCriteria("pluto");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertEquals(smartPlaylistsPage.secondSmartPlaylistName(), name);
    }

    @Test //creating smart playlist with group
    public void smartPlaylistCreationGroup() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test3";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.clickGroupButton();
        smartPlaylistsPage.enterCriteria("dark days");
        smartPlaylistsPage.enterGroupCriteria("pluto");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertEquals(smartPlaylistsPage.thirdSmartPlaylistName(), name);
    }

    @Test //verify related songs are present in a smart playlist created with a rule
    public void songPresentInSmartPlaylist1Rule() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test1";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.enterCriteria("dark days");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertTrue(smartPlaylistsPage.isSongInSmartPlaylist());
    }

    @Test //verify relates songs are present in a smart playlist created with a group
    public void songsPresentInSmartPlaylistGroup() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test3";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.clickGroupButton();
        smartPlaylistsPage.enterCriteria("dark days");
        smartPlaylistsPage.enterGroupCriteria("pluto");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertTrue(smartPlaylistsPage.isSongInSmartPlaylist());
        Assert.assertTrue(smartPlaylistsPage.isSongInSmartPlaylistGroup());
    }

    @Test //verify empty Smart playlist is created with 'No songs match the playlist's criteria' message if a rule doesn't fit any existing song
    public void emptySmartPlaylistMessage() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());
        String name = "test4";
        String message = "No songs match the playlist's criteria";

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.clickCreateNewPlaylistBtn();
        smartPlaylistsPage.clickNewSmartPlaylist();
        smartPlaylistsPage.enterPlaylistName(name);
        smartPlaylistsPage.enterCriteria("good days");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertTrue(smartPlaylistsPage.isEmptyPlaylistMessageDisplayed());
    }
    @Test //verify songs can be added to a smart playlist by changing its rules
    public void changingRuleSmartPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.contextClickExistingSmartPlaylist();
        smartPlaylistsPage.clickEditExistingSmartPlaylist();
        smartPlaylistsPage.clickGroupButton();
        smartPlaylistsPage.enterGroupCriteria("paranoid frustrations");
        smartPlaylistsPage.clickSaveButton();

        Assert.assertTrue(smartPlaylistsPage.successNotificationDisplayed());
    }
    @Test //verify smart playlist can be deleted
    public void deleteSmartPlaylist() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        SmartPlaylistsPage smartPlaylistsPage = new SmartPlaylistsPage(getThreadLocal());

        loginPage.provideLoginSucceed();
        smartPlaylistsPage.contextClickExistingSmartPlaylist();
        smartPlaylistsPage.clickDeleteSmartPlaylist();
        smartPlaylistsPage.clickOkButton();

        Assert.assertTrue(smartPlaylistsPage.successNotificationDisplayed());
    }

}



