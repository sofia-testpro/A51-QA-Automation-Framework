import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.UUID;

import java.time.Duration;

public class Homework23 extends BaseTest {
    @Test
    public void renameTestPlaylist()  {

        String updatedPlaylistMsg = "Updated playlist \"test.\"";


        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com")
                 .providePasswordToLogin("te$t$tudent")
                 .clickSubmitBtn();


        homePage.doubleClickOnSelectedPlaylist();

        homePage.enterNewNameForPlaylist("test1");


        Assert.assertEquals(homePage.getPlaylistName(),updatedPlaylistMsg);

    }
}
