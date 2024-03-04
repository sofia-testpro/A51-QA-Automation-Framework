import pageObjectModel.BasePage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.ProfilePage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public static void loginEmptyEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public static void loginEmptyPasswordTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public static void loginWrongEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiukk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public void loginUpdateEmailTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("lolitaharlan1@gmail.com");
        profilePage.clickSave();

        homePage.logOut();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
    @Test
    public void loginWithUpdatedEmailTest() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lolitaharlan1@gmail.com");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    @Test
    public void loginOldEmailDoesntWorkTest(){
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}
