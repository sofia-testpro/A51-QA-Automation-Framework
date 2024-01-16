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

    @Test
    public void changeProfileName() throws InterruptedException {

        LoginPage loginPage = new LoginPage(getThreadLocal());
        HomePage homePage = new HomePage(getThreadLocal());
        ProfilePage profilePage = new ProfilePage(getThreadLocal());
        BasePage basePage = new BasePage(getThreadLocal());

        loginPage.provideEmailToLogin("lalita.mantsiuk@testpro.io");
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
}
