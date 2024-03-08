import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class LogoutTests extends BaseTest {

    @Test
    public void logoutAfterLogin() {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+10@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.logOut();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());


    }
}





