package com.qualitest.lava.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PlaystoreSearchResultPage extends BasePage{

    private AndroidDriver driver;

    @AndroidFindBy(uiAutomator =  "new UiSelector().descriptionStartsWith(\"Image of app or game icon for Facebook\")")
    private WebElement facebookicon;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Uninstall']")
    private WebElement uninstallButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Uninstall']")
    private List<WebElement> uninstallButtons;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Cancel']")
    private WebElement cancelUninstallButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Install']")
    private WebElement installButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Open']")
    private WebElement openButton;


    public PlaystoreSearchResultPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void uninstallApplication(){
        facebookicon.click();
        uninstallButton.click();
        uninstallButton.click();
    }

    public void installApplication(){
        facebookicon.click();
        installButton.click();
    }

    public WebElement getInstallButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Install']")));
        return this.installButton;
    }

    public WebElement getOpenButton(){
        return this.openButton;
    }
    
}
