package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    public RegistrationPage (WebDriver givenDriver) {super (givenDriver);}

    @FindBy (css = "[type='email']")
    WebElement emailRegistrationTxtField;

    @FindBy (css = "[type='submit']")
    WebElement submitRegistrationBtn;

    @FindBy (xpath = "//div[text()=\"We've sent a confirmation link to the email. Please continue by clicking on it\"]")
    WebElement confirmationMessage;

    @FindBy (css = "[class='errors']")
    WebElement errorMessage;

   public RegistrationPage provideEmailForRegistration (String email) {
       findElement(emailRegistrationTxtField).sendKeys(email);
       return this;
   }

   public RegistrationPage clickSubmit() {
       findElement(submitRegistrationBtn).click();
       return this;
   }

   public RegistrationPage getConfirmation() {
       findElement(confirmationMessage).getText();
       return this;
   }

   public boolean confirmationMsgEnabled() {
       return confirmationMessage.isDisplayed();
   }

   public String getError() {
       return findElement(errorMessage).getText();
   }


    public String getValidationMsg() {
        return findElement(emailRegistrationTxtField).getAttribute("validationMessage");
    }
















}
