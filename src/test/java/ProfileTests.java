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

        loginPage.provideEmailToLogin("lolitamantsiuk@gmail.com");
        loginPage.providePasswordToLogin("te$t$tudent");
        loginPage.clickSubmitBtn();
        homePage.clickProfile();
        profilePage.provideCurrentPassword("te$t$tudent");
        String name = profilePage.generateRandomName();
        profilePage.provideProfileName(name);
        profilePage.clickSave();
        TimeUnit.MILLISECONDS.sleep(1000);
        Assert.assertEquals(homePage.getProfileName().getText(), name);
    }
}
