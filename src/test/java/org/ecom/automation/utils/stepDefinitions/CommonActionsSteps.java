package org.ecom.automation.utils.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.ecom.automation.utils.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class CommonActionsSteps extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonActionsSteps.class);
    private static String url;

    @Given("initialize the browser")
    public void initializingTheBrowserWithChrome() throws IOException {
     initializeDriver();
    }

    @And("navigates to {string} site")
    public void navigatesToSite(String url) throws IOException {
        super.navigatesToSite(url);
    }
}
