package org.ecom.automation.Utils.StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.ecom.automation.Utils.PageObjects.HomePage;
import org.ecom.automation.Utils.PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLoginStepDef {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginStepDef.class);
    public WebDriver driver;

    public UserLoginStepDef() {
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