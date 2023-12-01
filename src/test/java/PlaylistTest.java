import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class PlaylistTest extends BaseTest {

    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \"test.\"";

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();
        homePage.doubleClickOnSelectedPlaylist();
        homePage.enterNewPlaylistName("test");

        Assert.assertEquals(homePage.getRenamedPlaylistSuccessMsg(), updatedPlaylistMsg);
    }
}
