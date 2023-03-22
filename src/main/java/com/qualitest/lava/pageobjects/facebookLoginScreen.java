package com.qualitest.lava.pageobjects;

import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookLoginScreen {

    AndroidDriver driver;

    // @AndroidBy(xpath = "//android.view.View[@content-desc='Mobile number or
    // email']/../android.widget.EditText")
    // private AndroidElement input_UserName;

    // @AndroidBy(xpath = "")
    // private AndroidElement input_Password;

    facebookLoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void enterUserNameAndPassword(String username, String Password) {

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(getInputUserNameTextField()));

        System.out.println(this.driver.findElement(getInputUserNameTextField()).getSize());
        this.driver.findElements(getInputFields()).get(0).sendKeys(username);
        this.driver.findElements(getInputFields()).get(1).sendKeys(Password);
        this.driver.findElement(getLoginButton()).click();

        System.out.println("entered passowrd :- ".toUpperCase() + Password);
    }

    private By getInputUserNameTextField() {
        return By.xpath("//android.view.View[@content-desc='Mobile number or email']");
    }

    private By getInputFields(){
        return By.xpath("//android.widget.EditText");
    }

    private By getLoginButton(){
        return By.xpath("//android.widget.Button[@content-desc='Log in']");
    }

}
