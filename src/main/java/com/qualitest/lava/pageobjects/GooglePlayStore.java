package com.qualitest.lava.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GooglePlayStore extends BasePage {

    private AndroidDriver driver;

    public GooglePlayStore(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement searchbar;

    @AndroidFindBy(xpath = "//android.view.ImageView")
    private List<WebElement> searchicon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for apps & games']")
    private WebElement searchBarText;

    public GooglePlayStore launchGooglePlayStore() {
        Activity activity = new Activity("com.android.vending", "com.google.android.finsky.activities.MainActivity");

        this.driver.startActivity(activity);
        return this;
    }

    public PlaystoreSearchResultPage searchForApplication(String appName) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.view.ViewGroup")));
        searchBarText.click();
        searchbar.sendKeys(appName);
        this.driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        return new PlaystoreSearchResultPage(this.driver);

    }

}
