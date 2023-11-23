package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // LOCATORS SELENIUM PAGE FACTORY
    @FindBy(css = "input[type='email']")
    private WebElement emailTextField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordTxtField;
    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;
    @FindBy (css = "input[type='email']")
    private WebElement emailField;
    @FindBy (css = "input[type='password']")
    private WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    private WebElement submitBtn;

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }



    //HELPER METHODS USING SELENIUM PAGE FACTORY
    public LoginPage provideEmailToLogin(String email){
        emailTextField.sendKeys(email);
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




    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);

   }
    public void clickSubmit(){
        findElement(submitBtn).click();
    }
    public void login(){
        provideEmailToLogin("demo@class.com");
        providePasswordToLogin("te$t$tudent");
        clickSubmitBtn();
    }

    /* PAGE OBJECT MODEL (POM)
    private By submitButtonLocator = By.cssSelector("[type='submit']");
    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");

    public LoginPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage clickSubmitBtn(){
    driver.findElement(submitButtonLocator).click();
    return this;
    }

    public loginPage provideEmail (String email){
    WebElement emailElement = driver.findElement(emailField);
    emailElement.sendKeys(email);
    return this;
    }

    public loginPage providePassword (String password){
    WebElement passwordElement = driver.findElement(passwordField);
    passwordElement.sendKeys(password);
    return this;
    }
    */
}
