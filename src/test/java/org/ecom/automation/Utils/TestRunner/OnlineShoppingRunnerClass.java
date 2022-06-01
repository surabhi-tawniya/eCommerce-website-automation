package org.ecom.automation.Utils.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

public class OnlineShoppingRunnerClass {
    @RunWith(Cucumber.class)
    @CucumberOptions(
            monochrome = true,
            features = {"src/test/resources/features/"},
            glue = {"StepDefinations"},
            plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber.json"})

    public static class CucumberRunnerTest {
    }
}
