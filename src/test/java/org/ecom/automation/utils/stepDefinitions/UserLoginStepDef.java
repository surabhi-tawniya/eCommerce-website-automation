package org.ecom.automation.utils.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.utils.fileUtils.TestBase;
import org.ecom.automation.utils.pageObjects.HomePage;
import org.ecom.automation.utils.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginStepDef extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginStepDef.class);
    public WebDriver driver;

    public UserLoginStepDef() {

    }

    @When("I clicks on Sign-in link")
    public void iClicksOnSignInLink() {
        HomePage homePage = new HomePage(TestBase.driver);
        homePage.clickOnSigninLink();
    }

    @And("enters {string} and {string}")
    public void entersAnd(String email_id, String password) {
        LoginPage loginPage = new LoginPage(TestBase.driver);
        loginPage.userEnterValidCredentials(email_id, password);

    }

    @Then("clicks on sign in button")
    public void ClicksOnSignInButton() {
        LoginPage loginPage = new LoginPage(TestBase.driver);
        loginPage.userClicksSignInButton();
    }

    @And("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        TestBase.driver.getTitle();
        LOGGER.info("User is logged in successfully");
        tearDown();
    }

}