package com.qualitest.lava.pageobjects;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {

    private AndroidDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(AndroidDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    protected void printPageSource(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.driver.getPageSource());
    }
    
}
