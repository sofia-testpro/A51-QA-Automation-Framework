import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.BasePage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.RegistrationPage;

public class RegistrationTest extends BaseTest {

//Story:
//
//As a user, I want to create an account, so that I can log in and use Koel app
//Acceptance Criteria:
//
//User should be able to create an account in app
//Add email validation to the form(must have @ symbol, dot and @testpro.io domain). Show error message if email is not valid
//Prevent users to use + sign before @ sign to exclude multiple users generation for the same email
//if email already exist in DB show error message "user already registered"
//Password should be sent to user's email box
//User should be able to login into app after registration.
//User data should be correctly saved in DB: email, password. Password should be encrypted.
//All test cases should be automated (only for Automation Engineers)


    @Test
    public void provideValidEmailForRegistration() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        RegistrationPage registrationPage = new RegistrationPage(getThreadLocal());

        loginPage.getRegistrationLink().click();
        registrationPage.provideEmailForRegistration("lalita.mantsiuk@testpro.io");
        registrationPage.clickSubmit();
        Assert.assertTrue(registrationPage.confirmationMsgEnabled());
    }

    @Test
    public void provideInvalidEmailForRegistration() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        RegistrationPage registrationPage = new RegistrationPage(getThreadLocal());

        loginPage.getRegistrationLink().click();
        registrationPage.provideEmailForRegistration("lolitamantsiuk.com");
        registrationPage.clickSubmit();
        String errorMessageText = "Please include an '@' in the email address. 'lolitamantsiuk.com' is missing an '@'.";
        String validationMsg = registrationPage.getValidationMsg();
        Assert.assertEquals(errorMessageText, validationMsg);
    }

    @Test
    public void verifyRegistrationLogin() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void providePersonalEmailForRegistration() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        RegistrationPage registrationPage = new RegistrationPage(getThreadLocal());

        loginPage.getRegistrationLink().click();
        registrationPage.provideEmailForRegistration("lolitamantsiuk@gmail.com");
        registrationPage.clickSubmit();

        String errorMsgText = "Sorry, only certain emails are allowed, please do not use your personal email";

        Assert.assertEquals(errorMsgText, registrationPage.getError());
    }
}
