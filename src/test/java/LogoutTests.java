import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class LogoutTests extends BaseTest {

    @Test
    public void logoutAfterLogin() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        loginPage.providePasswordToLogin("Te$t$tudent1");
        loginPage.clickSubmitBtn();
        homePage.logOut();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());


    }
}





