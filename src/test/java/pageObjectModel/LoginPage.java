package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[type='email']")
    WebElement emailTxtField;
    @FindBy(css = "[type='password']")
    WebElement passwordTxtField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;
    @FindBy(css = "a[href='registration']")
    WebElement registrationLink;
    @FindBy(css = "[class='logo']")
    WebElement koelAppLogo;


    public LoginPage provideEmailToLogin(String email) {
            findElement(emailTxtField).sendKeys(email);
        return this;
    }
    public LoginPage providePasswordToLogin(String password) {
        findElement(passwordTxtField).sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn() {
        submitButton.click();
        return this;
    }
    public WebElement getRegistrationLink() {
        return findElement(registrationLink);
    }
    public void provideLoginSucceed() {
        provideEmailToLogin("lalita.mantsiuk+2@testpro.io");
        providePasswordToLogin("Te$t$tudent1");
        clickSubmitBtn();
    }
}

