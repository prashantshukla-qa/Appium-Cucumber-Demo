package com.qualitest.lava;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.qualitest.lava.pageobjects.FacebookLoginScreen;
import com.qualitest.lava.pageobjects.GooglePlayStore;
import com.qualitest.lava.pageobjects.PhoneCallAndSms;
import com.qualitest.lava.pageobjects.PlaystoreSearchResultPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class TestSessionInitiator {

    AndroidDriver driver;
    public FacebookLoginScreen FBLoginScreen;
    public GooglePlayStore googleplaystore;
    public PlaystoreSearchResultPage playstoreSearchResultPage;
    public PhoneCallAndSms phoneCallAndSms;

    public TestSessionInitiator() throws MalformedURLException {
        this.driver = driverInit();
        FBLoginScreen = new FacebookLoginScreen(this.driver);
        googleplaystore = new GooglePlayStore(this.driver);
        playstoreSearchResultPage = new PlaystoreSearchResultPage(this.driver);
        phoneCallAndSms = new PhoneCallAndSms(this.driver);
    }

    private AndroidDriver driverInit() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "ZF6222CSTS");
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("fullReset", "true");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        this.driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;

    }

    public AppiumDriver getDriver() {
        return this.driver;
    }



}
