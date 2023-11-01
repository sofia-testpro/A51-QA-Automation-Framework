import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException{
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        clickAvatar();
        provideCurrentPassword("te$t$tudent");
        String name = generateRandomName();
        provideProfileName(name);
        clickSave();
        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), name);



    }

    public void clickAvatar() throws InterruptedException{
        WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        avatar.click();
    }

    public void provideCurrentPassword (String currentPassword){
        WebElement currentPasswordField = driver.findElement(By.cssSelector("[name='current_password"));
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideProfileName(String name){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(name);
    }

    public void clickSave(){
        WebElement saveBtn = driver.findElement(By.cssSelector("button.btn-submit"));
        saveBtn.click();
    }
}
