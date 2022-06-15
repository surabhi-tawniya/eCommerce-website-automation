package org.ecom.automation.utils.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.ecom.automation.utils.pageObjects.RegistrationPage;
import org.ecom.automation.utils.pageObjects.HomePage;
import org.ecom.automation.utils.pageObjects.Sign_inPage;
import org.ecom.automation.utils.pageObjects.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserRegistrationStepDef extends TestBase  {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationStepDef.class);

    private final HomePage homePage;
    public UserRegistrationStepDef(HomePage homePage) {
        this.homePage = homePage;
    }

    @When("user clicks on Sign-in link")
    public void userClicksOnSignInLink() {
        homePage.clickOnSigninLink();
    }

    @And("verify the title of registration page")
    public void verifyTheTitleOfRegistrationPage() {
        RegistrationPage registration = new RegistrationPage(getDriver());
        registration.verifyHomePageTitle();

    }

    @Then("clicks on Registration button")
    public void clicksOnRegistrationButton() {
        RegistrationPage authenticate = new RegistrationPage(getDriver());
        authenticate.clickOnSubmitButton();
    }

    @And("verify that the user is registered successfully")
    public void verifyThatTheUserIsRegisteredSuccessfully() {
        MyAccountPage registrationSuccessful = new MyAccountPage(getDriver());
        registrationSuccessful.verifyMyAccountPageTitle();
        registrationSuccessful.verifyMyAccountName();
        LOGGER.info("User is registered successfully");

    }

    @And("enters {string} in create an account section and clicks the button")
    public void entersInCreateAnAccountSectionAndClicksTheButton(String email) {
        Sign_inPage sign_in = new Sign_inPage(getDriver());
        sign_in.clickOnCreateAccountButton(email);
        tearDown();
    }

}




