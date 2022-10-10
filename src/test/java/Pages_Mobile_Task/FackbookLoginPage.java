package Pages_Mobile_Task;

import BasePage_Mobile_Task.BaseClass;
import BasePage_Mobile_Task.ReadCredentials;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FackbookLoginPage extends BaseClass {

    ReadCredentials data1 =  new ReadCredentials();

    By userName = By.xpath("//android.widget.EditText[@content-desc=\"Username\"]");
    By password = By.xpath("//android.widget.EditText[@content-desc=\"Password\"]");
    By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Log In\"]");
    By skipButton = By.xpath("//android.widget.Button[@content-desc=\"Skip\"]");
    By denyButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Deny\"]");
    By goToProfileButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Go to profile\"]");

    public void clickAndEnterValueInUserName(){
    try{
        data1.ReadPropFile();
        Thread.sleep(25000);
        driver.findElement(userName).click();
        driver.findElement(userName).sendKeys(data1.getuserName());
    } catch (Exception e) {
    e.printStackTrace();
}
    }
    public void clickAndEnterValueInPassword(){
    try {
            Thread.sleep(5000);
            driver.findElement(password).click();
            driver.findElement(password).sendKeys(data1.getpassword());
    }catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(loginButton).click();
    }

    public void clickOnSkipButton() throws InterruptedException {
        Thread.sleep(30000);
        driver.findElement(skipButton).click();
    }

    public void clickOnDenyButton() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(denyButton).click();
    }
    public void clickOnGoToProfileButton() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(goToProfileButton).click();
    }

    @Test
    public void RunLoginPage() throws InterruptedException {
        clickAndEnterValueInUserName();
        clickAndEnterValueInPassword();
        clickOnLoginButton();
        clickOnSkipButton();
        clickOnDenyButton();
        clickOnGoToProfileButton(); }

    }
