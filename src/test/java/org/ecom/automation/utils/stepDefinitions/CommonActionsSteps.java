package org.ecom.automation.utils.stepDefinitions;

/*import io.cucumber.java.en.And;
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
    public WebDriver driver;

    public CommonActionsSteps(WebDriver driver) {

        this.driver = driver;
    }

    public CommonActionsSteps() {

    }
    @Given("initialize the browser with chrome")
    public void initializingTheBrowserWithChrome() throws IOException {
     TestBase.driver = initializeDriver();
    }

    @And("navigates to {string} site")
    public void navigatesToSite(String url) throws IOException {
        CommonActionsSteps.url = url;
        url = readUrlFromDataProperties();
        TestBase.driver.get(url);
        TestBase.driver.manage().window().maximize();
    }

    @And("verify the title of the homepage")
    public void verifyTheTitleOfTheHomepage() {
        HomePage homePage = new HomePage(TestBase.driver);
        String title1 = homePage.verifyHomePageTitle();
        TestBase.driver.get(title1);
        LOGGER.info(title1);
    }
}*/
