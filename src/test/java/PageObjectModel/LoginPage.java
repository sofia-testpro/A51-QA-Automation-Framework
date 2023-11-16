package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = "[type='email']")
    WebElement emailTxtField;
    @FindBy(css = "[type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;


    //LOCATORS BY
     By emailField = By.cssSelector("input[type='email']");
     By passwordField = By.cssSelector("input[type='password']");
     By submitBtn = By.cssSelector("button[type='submit']");


    //HELPER METHODS USING PAGE FACTORY
    public LoginPage provideEmailToLogin(String email){
        emailTxtField.sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password){
        passwordTxtField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }


    public void provideEmail(String email){
        findElement((WebElement) emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement((WebElement) passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement((WebElement) submitBtn).click();
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
