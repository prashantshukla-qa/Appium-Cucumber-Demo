package com.qualitest.lava;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty",
        "html:target/cucumber/report.html" }, features = "classpath:features/")
public class RunCucumberTest {
}