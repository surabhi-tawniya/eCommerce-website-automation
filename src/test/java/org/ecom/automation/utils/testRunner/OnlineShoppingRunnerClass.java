package org.ecom.automation.utils.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class OnlineShoppingRunnerClass {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            monochrome = true,
            features = {"src/test/resources/features/"},
            glue = {"stepDefinitions"},
            plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json"})

    public static class CucumberRunnerTest {
    }
}
