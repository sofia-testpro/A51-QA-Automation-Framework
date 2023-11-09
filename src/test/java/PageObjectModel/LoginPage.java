package PageObjectModel;

import com.fasterxml.jackson.databind.ser.Serializers;
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
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");


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
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password){
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}
