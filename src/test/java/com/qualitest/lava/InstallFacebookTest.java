package com.qualitest.lava;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InstallFacebookTest {

    TestSessionInitiator test;

    @BeforeTest
    public void setupFacebookTest() throws MalformedURLException {
        test = new TestSessionInitiator();
    }

    @Test
    public void TC01_UninstallFacebookApp() {
        test.googleplaystore.launchGooglePlayStore().searchForApplication("Facebook").uninstallApplication();

        Assert.assertEquals(test.playstoreSearchResultPage.getInstallButton().getAttribute("content-desc"),
                "Install");
    }

    @Test(dependsOnMethods = "TC01_UninstallFacebookApp")
    public void TC02_installFacebookFromGoogleService() {
        test.googleplaystore.launchGooglePlayStore().searchForApplication("Facebook").uninstallApplication();

        Assert.assertTrue(test.playstoreSearchResultPage.getOpenButton().isEnabled(),
                "Open button is not enabled after installation");
    }

}
