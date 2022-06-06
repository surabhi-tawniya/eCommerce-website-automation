package org.ecom.automation.utils.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.utils.pageObjects.HomePage;
import org.ecom.automation.utils.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserLoginStepDef extends CommonActionsSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginStepDef.class);
    private final CommonActionsSteps commonSteps = new CommonActionsSteps(null);
    public WebDriver driver;

    public UserLoginStepDef() {
        super();
    }

    @Given("initialize the browser with chrome")
    public void initializingDriver() throws IOException {
        commonSteps.initializeTheBrowserWithChrome();
    }

    @When("navigates to {string} site")
    public void navigatingToUrl(String url) throws IOException {
        commonSteps.navigatesToSite(url);
    }

    @When("I clicks on Sign-in link")
    public void iClicksOnSignInLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninLink();
    }

    @And("enters <email_id> and <password>")
    public void entersEmail_idAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userEnterValidCredentials();
    }

    @Then("clicks on sign in button")
    public void ClicksOnSignInButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userClicksSignInButton();
    }

    @And("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        driver.getTitle();
        LOGGER.info("User is logged in successfully");
    }
}