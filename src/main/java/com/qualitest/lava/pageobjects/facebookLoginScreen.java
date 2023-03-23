package com.qualitest.lava.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import java.util.List;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookLoginScreen extends BasePage {

    private AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private List<WebElement> input_credentials_field;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log in']")
    private WebElement button_Login;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Go to profile']")
    private WebElement profileIcon;

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> errorMessage;

    public FacebookLoginScreen(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void enterUserNameAndPassword(String username, String Password) {

        wait.until(ExpectedConditions.presenceOfElementLocated(getInputUserNameTextField()));

        input_credentials_field.get(0).sendKeys(username);
        input_credentials_field.get(1).sendKeys(Password);

        button_Login.click();
    }


    public String getErrorMessage(){
        return errorMessage.get(0).getText();
    }

    public WebElement getProfileIcon(){
        return profileIcon;
    }

    private By getInputUserNameTextField() {
        return By.xpath("//android.view.View[@content-desc='Mobile number or email']");
    }

}
