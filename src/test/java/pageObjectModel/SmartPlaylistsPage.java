package pageObjectModel;

import com.github.dockerjava.api.command.AuthCmd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SmartPlaylistsPage extends BasePage {
    public SmartPlaylistsPage (WebDriver givenDriver) {super(givenDriver);}

    @FindBy (css = "i[title='Create a new playlist']")
    WebElement createNewPlaylistBtn;
    @FindBy (css = "li[data-testid='playlist-context-menu-create-smart']")
    WebElement newSmartPlaylist;
    @FindBy (css = "input[name='name']")
    WebElement playlistNameField;
    @FindBy (css = "select[name='model[]']")
    WebElement dropdownCriteriaBtn;
    @FindBy (css = "input[name='value[]']")
    WebElement inputCriteriaField;
    @FindBy (xpath = "//footer//button[contains(text(),\"Save\")]")
    WebElement saveButton;
    @FindBy (xpath = "//h1[contains(text(),\"test1\")]")
    WebElement createdSmartPlaylist;
    @FindBy (css = "button.btn-add-rule")
    WebElement addRuleButton;
    @FindBy (xpath = "//div[3]//input[@name='value[]']")
    WebElement inputSecondCriteriaField;
    @FindBy (xpath = "//h1[contains(text(),\"test2\")]")
    WebElement secondCreatedSmartPlaylist;
    @FindBy (css = "button.btn-add-group")
    WebElement groupButton;
    @FindBy (xpath = "//h1[contains(text(),\"test3\")]")
    WebElement thirdCreatedSmartPlaylist;
    @FindBy (xpath = "//section[@id='playlistWrapper']//td[text()='Dark Days']")
    WebElement songDarkDays;
    @FindBy (xpath = "//section[@id='playlistWrapper']//td[text()='Pluto']")
    WebElement songPluto;
    @FindBy (xpath = "//div[2][@class='rule-group']//input[@name='value[]']")
    WebElement groupCriteriaField;
    @FindBy (xpath = "//div[contains(text(), \"No songs match the playlist's\")]")
    WebElement emptySmartPlaylistMessage;
    @FindBy (xpath = "//section[@id='playlists']//li[@class='playlist playlist smart'][1]")
    WebElement existingSmartPlaylist;
    @FindBy (xpath = "//li[@class='playlist playlist smart'][1]//li[contains(text(), \"Edit\")]")
    WebElement editExistingSmartPlaylist;
    @FindBy (css = "div.success.show")
    WebElement updateSuccessNotification;
    @FindBy (xpath = "//li[@class='playlist playlist smart'][1]//li[contains(text(), \"Delete\")]")
    WebElement deleteSmartPlaylist;
    @FindBy (css = "button.ok")
    WebElement okButton;


    public void clickCreateNewPlaylistBtn() {
        //actions.moveToElement(createNewPlaylistBtn).perform();
        //wait.until(ExpectedConditions.visibilityOf(createNewPlaylistBtn)).click();
        WebElement createNewPlaylistButton = wait.until(ExpectedConditions.visibilityOf(createNewPlaylistBtn));
        actions.moveToElement(createNewPlaylistButton).click().perform();
    }
    public void clickNewSmartPlaylist() {
        //actions.moveToElement(newSmartPlaylist).perform();
        WebElement clickNewSmartPL = wait.until(ExpectedConditions.visibilityOf(newSmartPlaylist));
        actions.moveToElement(clickNewSmartPL).click().perform();
    }
    public void enterPlaylistName(String name) {
        playlistNameField.clear();
        playlistNameField.sendKeys(name);
    }
    public void enterCriteria(String criteria) {
        inputCriteriaField.clear();
        inputCriteriaField.sendKeys(criteria);
    }
    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }
    public String smartPlaylistName() {
        return createdSmartPlaylist.getText();
    }
    public void clickAddRuleButton()  {
        wait.until(ExpectedConditions.elementToBeClickable(addRuleButton)).click();
    }
    public void enterSecondCriteria(String criteria) {
        inputSecondCriteriaField.clear();
        inputSecondCriteriaField.sendKeys(criteria);
    }
    public String secondSmartPlaylistName() {
        return secondCreatedSmartPlaylist.getText();
    }
    public void clickGroupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(groupButton)).click();
    }
    public String thirdSmartPlaylistName() {
        return thirdCreatedSmartPlaylist.getText();
    }
    public Boolean isSongInSmartPlaylist() {
        return songDarkDays.isDisplayed();
    }
    public Boolean isSongInSmartPlaylistGroup() {
        return songPluto.isDisplayed();
    }
    public void enterGroupCriteria(String criteria) {
        groupCriteriaField.clear();
        groupCriteriaField.sendKeys(criteria);
    }
    public boolean isEmptyPlaylistMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(emptySmartPlaylistMessage));
        return emptySmartPlaylistMessage.isDisplayed();
    }
    public void contextClickExistingSmartPlaylist() {
        actions.moveToElement(existingSmartPlaylist).perform();
        wait.until(ExpectedConditions.visibilityOf(existingSmartPlaylist));
        actions.contextClick(existingSmartPlaylist).perform();
    }
    public void clickEditExistingSmartPlaylist() {
        actions.moveToElement(editExistingSmartPlaylist).perform();
        wait.until(ExpectedConditions.visibilityOf(editExistingSmartPlaylist)).click();
    }
    public Boolean successNotificationDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(updateSuccessNotification));
        return updateSuccessNotification.isEnabled();
    }
    public void clickDeleteSmartPlaylist() {
        actions.moveToElement(deleteSmartPlaylist).perform();
        wait.until(ExpectedConditions.visibilityOf(deleteSmartPlaylist)).click();
    }
    public void clickOkButton() {
        actions.moveToElement(okButton).perform();
        wait.until(ExpectedConditions.visibilityOf(okButton)).click();
    }
}
