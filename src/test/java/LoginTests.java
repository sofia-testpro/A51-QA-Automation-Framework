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
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        // WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue (avatar.isDisplayed());
        driver.quit();
    }


    // FLUENT WAY STARTS HERE
    @Test
    public void loginValidEmailPasswordByPageFactory() throws InterruptedException {
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);

       loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtn();

       Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
    //FLUENT WAY ENDS HERE


    @Test (dataProvider = "LoginData")
    public void loginDataProvider (String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
    }
    @Test
    public void loginInvalidEmailValidPassword () throws InterruptedException {
        provideEmail("invalidemail@class.com");
        providePassword("te$t$tudent");
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test
    public void loginValidEmailNoPassword () throws InterruptedException {
        provideEmail("demo@class.com");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
