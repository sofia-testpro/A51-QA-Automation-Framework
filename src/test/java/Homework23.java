import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        homePage.enterNewNameForPlaylist("Lalita");


        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);

    }
}
