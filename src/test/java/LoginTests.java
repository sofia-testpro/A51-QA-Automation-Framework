import pageObjectModel.BasePage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.ProfilePage;

public class LoginTests extends BaseTest {

    @Test
    public void loginSuccessTest() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public static void loginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiukgmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test
    public void loginSucceedTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideLoginSucceed();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginUpdatedEmailTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        profilePage.provideNewEmail("lolitaharlan1@gmail.com");
        profilePage.clickSave();
        homePage.logOut();

        loginPage.provideEmailToLogin("lolitaharlan1@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginOldEmailDoesntWorkTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent1");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());

    }
}
