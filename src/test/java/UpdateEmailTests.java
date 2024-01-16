import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.ProfilePage;

public class UpdateEmailTests extends BaseTest {


    //Story:
    //
    //As a user, I want to update an account email.
    //
    //Acceptance Criteria:
    //
    //User should be able to update account email in app
    //Add validation to the email field: email must have @ symbol, dot and domain. Show error message if email is not valid
    //If the new email is already in the database, show the message "this user already exists"
    //User should be able to login into app with updated email
    //User should not be able to login into app with old email
    //The updated email should be correctly saved to the database
    //

    @Test
    public void updateEmail() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+1@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();

        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("lalita.mann@testpro.io");
        profilePage.clickSave();

        Assert.assertTrue(profilePage.successMessageShow());
    }

    @Test
    public void validationPresentInEmailField(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();

        Assert.assertTrue(profilePage.validationTextPresent());
    }

    @Test
    public void testUpdateWithInvalidEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();

        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("lalita.mann.com");
        profilePage.clickSave();

        String errorMsg = "Please include an '@' in the email address. 'lalita.mann.com' is missing an '@'.";
        String getValidationMsg = profilePage.getValidationMsg();

        Assert.assertEquals(errorMsg, getValidationMsg);
    }

    @Test
    public void updateEmailWithAlreadyExistingInDBEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();

        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("admin@koel.dev");
        profilePage.clickSave();

        Assert.assertTrue(profilePage.errorMessageShow());
    }

    @Test
    public void testLoginUpdatedEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mann@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void testLoginOldEmail(){
        LoginPage loginPage = new LoginPage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+1@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

}
