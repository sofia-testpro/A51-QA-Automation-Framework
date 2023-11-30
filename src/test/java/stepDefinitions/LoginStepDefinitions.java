package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Given ("User opens Login Page")
    public void userOpensLoginPage() {
        driver.get("https://qa.koel.app");
    }

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmailToLogin(email);
    }

    @And("User enters password {string}")
    public void userEntersPassword(String password) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePasswordToLogin(password);
    }

    @And("User submits")
    public void userSubmits() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='submit']"))).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitBtn();
    }

    @Then("User should get logged in")
    public void userShouldGetLoggedIn() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Then("User should not get logged in")
    public void userShouldNotGetLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getKoelLogo().isDisplayed());
    }
}
