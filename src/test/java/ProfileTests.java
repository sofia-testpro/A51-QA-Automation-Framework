import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.BasePage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import pageObjectModel.ProfilePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProfileTests extends BaseTest {
    //1.User should be able to change his name in the Name field + 2.Updated name should be correctly displayed on the Homepage (and DB).
    @Test
    public void changeProfileUpdateName() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+1@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.provideCurrentPassword("Te$tPro123!");
        String name = profilePage.generateRandomName();
        profilePage.provideProfileName(name);
        profilePage.clickSave();

        basePage.isTextPresentInElement(homePage.getProfileName(), name);
        System.out.println("Expected Profile Name: " + name);
        System.out.println("Actual Profile Name: " + homePage.getProfileName());

        Assert.assertEquals(homePage.getProfileName().getText(), name);
    }

    //3.User should be able to update Email.
    @Test
    public void changeProfileUpdateEmail() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk+1@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("lalita.mantsiuk@testpro.io");
        profilePage.clickSave();

        Assert.assertTrue(profilePage.successMessageShow());
    }

    //4.User should be able to update Password.
    @Test
    public void changeProfileUpdatePassword() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.provideCurrentPassword("Te$tPro123!");
        profilePage.provideNewEmail("lalita.mantsiuk@testpro.io");
        profilePage.provideNewPassword("Te$tPro12345!");
        profilePage.clickSave();

        Assert.assertTrue(profilePage.successMessageShow());
    }

    //5.Updated Email and Password should be correctly displayed in DB.
    //dont know how to work with database. if can share the code to analyze please share.

    //6.User should be able to change Theme of the app. Verify that selected Theme is changed in any other page except the Profile & Preferences page.
    @Test
    public void changeTheme() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.changeTheme();
        profilePage.clickHomePage();
        String name = profilePage.getThemeName().getText();
        String name2 = homePage.getThemeName().getText();
        System.out.println("chosen theme style is: " + name + "home page style is also: " + name2);

        Assert.assertEquals(name, name2);
    }

    //7.Currently playing song should appear as notification when the "Show Now Playing” song notification checkbox is marked
    // does not work


    //8.Confirmation window when closing Koel app should appear when the 'Confirm before closing Koel' checkbox is marked
    // does not work

    //9.'Show a translucent, blurred overlay of the current album’s art' should be marked and album cover should be displayed with a translucent, blurred overlay
    @Test
    public void overlayOn() {
        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
        loginPage.providePasswordToLogin("Te$tPro123!");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.clickOverlayOption();

        Assert.assertTrue(profilePage.isOverlayOn());
    }
}
