package org.ecom.automation.Utils.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.Utils.PageObjects.AuthenticationPage;
import org.ecom.automation.Utils.PageObjects.HomePage;
import org.ecom.automation.Utils.PageObjects.Sign_inPage;
import org.ecom.automation.Utils.PageObjects.UserRegistrationSuccessful;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserRegistrationStepDef {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationStepDef.class);
    public WebDriver driver;
    private CommonActionsSteps commonSteps = new CommonActionsSteps(driver);

    public UserRegistrationStepDef() {
    }

    @Given("initialize the browser with chrome")
    public void initializingDriver() throws IOException {
        commonSteps.initializeTheBrowserWithChrome();
    }

    @When("navigates to {string} site")
    public void navigatingToUrl(String url) throws IOException {
        commonSteps.navigatesToSite(url);
    }

    @And("verify the title of the homepage")
    public void verifyingTitleOfLandingPage() {
        commonSteps.verifyTheTitleOfTheHomepage();
    }

    @When("user clicks on Sign-in link")
    public void userClicksOnSignInLink() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnSigninLink();
    }

    @And("enters email_id in create an account section and clicks the button")
    public void entersEmail_idInCreateAnAccountSectionAndClicksTheButton() {
        Sign_inPage sign_in = new Sign_inPage(driver);
        sign_in.clickOnCreateAccountButton();
    }

    @And("user enters his personal information")
    public void userEntersHisPersonalInformation() {
        AuthenticationPage authenticate = new AuthenticationPage(driver);
        authenticate.enterPersonalInformation();
    }

    @Then("clicks on Registration button")
    public void clicksOnRegistrationButton() {
        AuthenticationPage authenticate = new AuthenticationPage(driver);
        authenticate.clickOnSubmitButton();
    }

    @And("verify that the user is registered successfully")
    public void verifyThatTheUserIsRegisteredSuccessfully() {
        UserRegistrationSuccessful registrationSuccessful = new UserRegistrationSuccessful(driver);
        registrationSuccessful.verifyMyAccountPageTitle();
        registrationSuccessful.verifyMyAccountName();
        LOGGER.info("User is registered successfully");
        driver.close();
    }
}




