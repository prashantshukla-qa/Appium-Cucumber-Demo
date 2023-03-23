package com.qualitest.lava.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PhoneCallAndSms extends BasePage {

    private AndroidDriver driver;

    public PhoneCallAndSms(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='key pad']")
    private WebElement keypadButton;

    @AndroidFindBy(id = "com.google.android.dialer:id/deviceid_hex")
    private List<WebElement> imeiNumbersText;

    @AndroidFindBy(id = "android:id/message")
    private WebElement noNetworkMesage;

    @AndroidFindBy(id = "android:id/title")
    private List<WebElement> notificationHeaders;

    public int makePhoneCall(String phoneNum, int callDuration) throws IOException, InterruptedException {

        callDuration *= 1000;
        String deviceId = this.driver.getCapabilities().getCapability("appium:deviceName").toString();
        String cmd = "adb -s " + deviceId + " shell am start -a android.intent.action.CALL -d tel:" + phoneNum;
        System.out.println(cmd);
        Process exec = Runtime.getRuntime().exec(cmd);
        Thread.sleep(callDuration);
        return exec.exitValue();
    }

    public PhoneCallAndSms launchCallDialer() {
        Activity activity = new Activity("com.google.android.dialer",
                "com.google.android.dialer.extensions.GoogleDialtactsActivity");
        this.driver.startActivity(activity);
        return this;
    }

    public String readNotifications(){
        this.driver.openNotifications();

        System.out.println("\nTHERE ARE " + notificationHeaders.size() + " UNREAD NOTIFICATIONS !!!");

        for(WebElement elem : notificationHeaders){
            System.out.println("\t- " + elem.getText());
        }
        System.out.println("");
        return "";
    }

    public SortedSet<String> getIMEInumber() {
        SortedSet<String> imeiNumbers = new TreeSet<>();
        keypadButton.click();
        this.driver.pressKey(new KeyEvent(AndroidKey.STAR));
        this.driver.pressKey(new KeyEvent(AndroidKey.POUND));
        this.driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_0));
        this.driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6));
        this.driver.pressKey(new KeyEvent(AndroidKey.POUND));

        for (WebElement elem : imeiNumbersText) {
            imeiNumbers.add(elem.getText());
        }

        return imeiNumbers;

    }

    public void readSMS() {
        this.driver.openNotifications();
    }

    public String getNetworkMessage() {
        return noNetworkMesage.getText();
    }

    public void endPhoneCall() {
        this.driver.terminateApp("com.google.android.dialer");
    }
}
