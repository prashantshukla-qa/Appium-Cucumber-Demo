package com.qualitest.lava;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeCallAndSmsTest {

    TestSessionInitiator test;

    @BeforeTest
    public void setupFacebookTest() throws MalformedURLException {
        test = new TestSessionInitiator();
    }

    // @Test
    public void testImeiNumbers() throws IOException, InterruptedException {
        SortedSet<String> actualNumbers = test.phoneCallAndSms.launchCallDialer().getIMEInumber();

        SortedSet<String> expectedNumbers = new TreeSet<>();

        expectedNumbers.add("351866092029775 / 20");
        expectedNumbers.add("35186609202977");
        expectedNumbers.add("351866092029783 / 20");

        Assert.assertEquals(actualNumbers.size(), expectedNumbers.size());
        Assert.assertEquals(actualNumbers, expectedNumbers);

    }


    // @Test
    public void testCallWithoutNetwork() throws IOException, InterruptedException{
        test.phoneCallAndSms.launchCallDialer().makePhoneCall("+919811052762", 10);
        Assert.assertEquals(test.phoneCallAndSms.getNetworkMessage(), "Cellular network not available for voice calls.");
    }


    @Test
    public void testNotifications(){
        test.phoneCallAndSms.readNotifications();
    }

    @AfterClass(alwaysRun = true)
    public void closeDialer(){
        test.phoneCallAndSms.endPhoneCall();
    }
}
