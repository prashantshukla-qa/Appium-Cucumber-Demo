package com.qualitest.lava.pageobjects;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

    AndroidDriver driver;
    public facebookLoginScreen FBLoginScreen;

    public BaseClass() throws MalformedURLException {
        this.driver = driverInit();
        FBLoginScreen = new facebookLoginScreen(driver);
    }

    private AndroidDriver driverInit() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "ZF6222CSTS");
        desiredCapabilities.setCapability("appium:appPackage", "com.facebook.katana");
        desiredCapabilities.setCapability("appium:appActivity", "LoginActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        this.driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        return driver;

    }

    public AppiumDriver getDriver() {
        return this.driver;
    }

    public void launchApplication() {
        Activity activity = new Activity("com.facebook.katana", "LoginActivity");
        this.driver.startActivity(activity);
    }

}
