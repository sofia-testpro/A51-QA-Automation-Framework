import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        // WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue (avatar.isDisplayed());
        driver.quit();
    }
    @Test (dataProvider = "LoginData")
    public void loginDataProvider (String email, String password) throws InterruptedException {
        navigateToLoginPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        driver.quit();
    }
    @Test
    public void loginInvalidEmailValidPassword () throws InterruptedException {
        navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        providePassword("te$t$tudent");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
    @Test
    public void loginValidEmailNoPassword () throws InterruptedException {
        navigateToLoginPage();
        provideEmail("demo@class.com");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
