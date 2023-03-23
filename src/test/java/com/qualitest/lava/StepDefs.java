package com.qualitest.lava;

import java.net.MalformedURLException;

import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

    TestSessionInitiator test;

    @Before
    public void setup() throws MalformedURLException{
        test = new TestSessionInitiator(); 
    }

    @Given("I have launched the facebook app")
    public void i_have_launched_the_facebook_app() {
        test.FBLoginScreen.launchFacebookApplication();
    }

    @When("I try to login using {string} and {string}")
    public void i_try_to_login_using_and(String userName, String password) {
        test.FBLoginScreen.enterUserNameAndPassword(userName, password);
    }

    @Then("I should see Profile Icon")
    public void i_should_see_the_message() {
        Assert.assertTrue(test.FBLoginScreen.getProfileIcon().isEnabled());
    }

    @Then("I should see the error {string}")
    public void i_should_see_the_message(String errorMessage) {
        Assert.assertEquals(test.FBLoginScreen.getErrorMessage(), errorMessage);
    }

}
