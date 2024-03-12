package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "[name='current_password']")
    WebElement currentPasswordField;
    @FindBy (css = "[name='name']")
    WebElement profileName;
    @FindBy (css = "button.btn-submit")
    WebElement saveBtn;
    @FindBy (css = "[name='email']")
    WebElement profileEmail;
    @FindBy (css = "div.success.show")
    WebElement successMessage;
    @FindBy (css = "p[class='password-rules help']")
    WebElement validationText;
    @FindBy (css = "div.error.show")
    WebElement errorMessage;
    @FindBy (css = "#inputProfileNewPassword")
    WebElement newPasswordField;
    @FindBy (xpath = "//section[@id='profileWrapper']//section[1]/ul[@class='themes']/li[3]/div")
    WebElement thirdThemeInTheList;
    @FindBy (css = ".menu .home")
    WebElement homePage;
    @FindBy (css = "html.mac.with-extra-panel")
    WebElement themeStyle;
    @FindBy (css = "[data-testid='album-art-overlay']")
    WebElement overlay;
    @FindBy (xpath = "//section[@id='profileWrapper']/div[@class='main-scroll-wrap']//input[@name='show_album_art_overlay']")
    WebElement overlayOption;


    public void provideCurrentPassword (String currentPassword){
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }
    public void  provideProfileName(String name){
        profileName.clear();
        profileName.sendKeys(name);
    }
    public void clickSave(){
        saveBtn.click();
    }
    public void provideNewEmail(String email){
        profileEmail.clear();
        profileEmail.sendKeys(email);
    }
    public boolean successMessageShow () {
        return successMessage.isEnabled();
    }
    public String getValidationMsg() {
        return findElement(profileEmail).getAttribute("validationMessage");
    }
    public boolean validationTextPresent(){
        return validationText.isDisplayed();
    }
    public boolean errorMessageShow(){
        return errorMessage.isEnabled();
    }
    public void provideNewPassword(String password){
        newPasswordField.clear();
        newPasswordField.sendKeys(password);
    }
    public void changeTheme() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdThemeInTheList)).click();
    }
    public WebElement getThemeName() {
        return themeStyle;
    }
    public void clickHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage)).click();
    }
    public void clickOverlayOption() {
        wait.until(ExpectedConditions.visibilityOf(overlayOption));
        actions.scrollToElement(overlayOption).click();
    }
    public boolean isOverlayOn() {
        wait.until(ExpectedConditions.visibilityOf(overlay));
        return overlay.isEnabled();
    }


}
